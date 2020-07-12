package com.entities;

import java.awt.Graphics2D;
import java.awt.Image;

import com.entities.Product.productType;
import com.event.CEvent;
import com.event.CEvent.Event;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementTask.Position;


public class MachineC extends Machine{

	private Product storageIn;
	private Product storageOut;
	private int pPosX = 659;
	private int pPosY = 590;
	private ImageProvider ip = new ImageProvider();
	
	public MachineC(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		this.company = company;
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_C));
		standardTaskPoints = 20;
		isRequested = false;
		dedicatedStaff = new Employee[2];
		isWorking = false;
		for (int i = 0; i < dedicatedStaff.length; i++) {
			throwEvent(new CEvent(Event.MACHINE_C_REQUEST_STAFF));
		}
	}

	public void process() {
		if(isWorking) {
			varTaskPoints += efficiency;
			if(efficiency<=0.5) {
				calculateEfficiency();
			}
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
	
	public void loadMachine(Employee employee) {
		if(employee.getCarryProduct()!=null) {
			storageIn = employee.getCarryProduct();
			storageIn.setxPos(pPosX);
			storageIn.setyPos(pPosY);
			employee.setCarryProduct(null);
			setupMachine();
			employee.increaseEventStep();
		}
	}
	
	public void unloadMachine(Employee employee) {
		if(employee.reachedPosition(Position.MACHINE_C)) {
			if(storageOut!=null) {
				employee.setCarryProduct(storageOut);
				storageOut = null;
				isRequested = false;
				employee.increaseEventStep();
			}
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
				this.taskPoints = standardTaskPoints + getRandomInt();
				calculateEfficiency();
				isWorking = true;
			}		
		}
	}

	public void AddDedicatedStaff(Employee employee) {
		for (int i = 0; i < dedicatedStaff.length; i++) {
			if(dedicatedStaff[i]==null) {
				dedicatedStaff[i] = employee;
				if(i==0) {
					employee.setPosition(Position.MACHINE_C_SLOT1);
				} else {
					employee.setPosition(Position.MACHINE_C_SLOT2);
				}
				employee.setAvailability(false);
				break;
			}
		}
	}

	public void drawItems(Graphics2D g2d) {
		if(storageIn!=null) {
			g2d.drawImage(storageIn.getImage(),storageIn.getxPos(),storageIn.getyPos(),null);
		}
		if(storageOut!=null) {
			g2d.drawImage(storageOut.getImage(),storageOut.getxPos(),storageOut.getyPos(),null);
		}
	}
}
