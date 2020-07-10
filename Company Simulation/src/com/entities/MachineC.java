package com.entities;

import java.awt.Image;

import com.entities.Product.productType;
import com.event.CEvent;
import com.event.CEvent.Event;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;


public class MachineC extends Machine{

	private Product storageIn;
	private Product storageOut;
	private int pPosX = 650;
	private int pPosY = 550;
	
	public MachineC(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_C));
		standardTaskPoints = 300;
		isWorking = false;
		dedicatedStaff = new Employee[2];
	}

	public void process() {
		if(isWorking) {
			varTaskPoints += efficiency;
			
			if(isProzessFinished()) {
				isWorking = false;
				storageIn = storageOut;
				storageIn = null;
				throwEvent(new CEvent(Event.MACHINE_C_UNLOAD));
			}
		}
	}
	
	public void loadMachine(Employee employee) {
		if(employee.getCarryProduct()!=null) {
			storageIn = employee.getCarryProduct();
			
			storageIn.setxPos(pPosX);
			storageIn.setyPos(pPosY);
			storageOut = storageIn;
			storageOut.setImage(imageProvider.getImage(Imagefor.PRODUCT_C_CERTIFIED));
			storageOut.setType(productType.PRODUCT_C_CERTIFIED);
			setupMachine();
			employee.increaseEventStep();
		}
	}
	
	public void unloadMachine(Employee employee) {
		if(storageOut!=null) {
			employee.setCarryProduct(storageOut);
			storageOut = null;
			employee.increaseEventStep();
		}
	}
	
	protected void setupMachine() {
		if(storageIn==null) {
			if(company.getStorage().checkForProductType(productType.PRODUCT_C)>0) {
				throwEvent(new CEvent(Event.MACHINE_C_REFILL));
				isWaiting = false;
			} else {
				isWaiting = true;
			}
		} else {
			calculateTaskPoints();
			calculateEfficiency();
			isWorking = true;
		}
	}
}
