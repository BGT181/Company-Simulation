package com.entities;

import java.awt.Image;

import com.entities.Product.productType;
import com.event.CEvent;
import com.event.CEvent.Event;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;

public class MachineA extends Machine{

	private Product storageIn;
	private Product storageOut;
	private productType previousProductType;
	private int pPosX = 650;
	private int pPosY = 150;
	private int punishmentTaskPoints;
	
	public MachineA(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_A));
		standardTaskPoints = 40;
		punishmentTaskPoints = 40;
		isRequested = false;
		dedicatedStaff = new Employee[4];
		isWorking = false;
		for (int i = 0; i < dedicatedStaff.length; i++) {
			throwEvent(new CEvent(Event.MACHINE_A_REQUEST_STAFF));
		}
	}
	
	protected void setupMachine() {
		if(!isWorking) {
			if(storageIn==null) {
				if((company.getStorage().checkForProductType(productType.PRODUCT_C)>=0)&&!isRequested) {
					throwEvent(new CEvent(Event.MACHINE_C_REFILL));
					isRequested = true;
				}
			} else {
				isRequested = false;
				calculateTaskPoints();
				calculateEfficiency();
				isWorking = true;
			}		
		}
	}
	
	
	
	
	
	public void process() {
		if(isWorking) {
			varTaskPoints += efficiency;
			
			if(isProzessFinished()) {
				isWorking = false;
				storageOut = storageIn;
				storageOut.setType(productType.PRODUCT_C_CERTIFIED);
				storageIn = null;
				varTaskPoints = 0;
				throwEvent(new CEvent(Event.MACHINE_C_UNLOAD));
			}
		} else {
			setupMachine();
		}
	}

}
