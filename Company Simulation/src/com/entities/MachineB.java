package com.entities;

import java.awt.Graphics2D;
import java.awt.Image;

import com.entities.Product.productType;
import com.event.CEvent;
import com.event.CEvent.Event;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementTask.Position;

public class MachineB extends Machine{

	private Product storageInA;
	private Product storageInB;
	private Product storageOut;
	private int xPosA = 660;
	private int yPosA = 300;
	private int xPosB = 660;
	private int yPosB = 350;
	
	public MachineB(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_B));
		this.company = company;
		standardTaskPoints = 60;
		isRequested = false;
		dedicatedStaff = new Employee[6];
		isWorking = false;
		for (int i = 0; i < dedicatedStaff.length; i++) {
			throwEvent(new CEvent(Event.MACHINE_B_REQUEST_STAFF));
		}
	}
		
	public void process() {
		if(isWorking) {
			varTaskPoints += efficiency;
				
			if(isProzessFinished()) {
				isWorking = false;
				storageOut = new Product(imageProvider.getImage(Imagefor.PRODUCT_C), 660, 400, productType.PRODUCT_C);
				storageOut.setType(productType.PRODUCT_C);
				storageInA = null;
				storageInB = null;
				varTaskPoints = 0;
				throwEvent(new CEvent(Event.MACHINE_B_UNLOAD));
			}
		} else {
			setupMachine();
		}
	}

	protected void setupMachine() {
		if(!isWorking) {
			if((storageInA==null)&&(storageInB==null)) {
				if((company.getStorage().checkForProductType(productType.PRODUCT_A_PROCESSED)>=0)&&!isRequested) {
					if((company.getStorage().checkForProductType(productType.PRODUCT_B_PROCESSED)>=0)&&!isRequested){
						throwEvent(new CEvent(Event.MACHINE_B_REFILL_A));
						throwEvent(new CEvent(Event.MACHINE_B_REFILL_B));
						isRequested = true;
					}
				}
			} else {
				if((storageInA!=null)&&(storageInB!=null)){
					this.taskPoints = standardTaskPoints + getRandomInt();
					calculateEfficiency();
					isWorking = true;
				}
			}		
		}
	}
	
	public void loadMachine(Employee employee) {
		if(employee.getCarryProduct()!=null) {
			if(employee.getCarryProduct().getType()==productType.PRODUCT_A_PROCESSED) {
				storageInA = employee.getCarryProduct();
				storageInA.setxPos(xPosA);
				storageInA.setyPos(yPosA);
				employee.setCarryProduct(null);
				setupMachine();
				employee.increaseEventStep();
			} else {
				if(employee.getCarryProduct().getType()==productType.PRODUCT_B_PROCESSED) {
					storageInB = employee.getCarryProduct();
					storageInB.setxPos(xPosB);
					storageInB.setyPos(yPosB);
					employee.setCarryProduct(null);
					setupMachine();
					employee.increaseEventStep();
				}
			}
		}
	}
	
	public void unloadMachine(Employee employee) {
		if(employee.reachedPosition(Position.MACHINE_B)) {
			if(storageOut!=null) {
				employee.setCarryProduct(storageOut);
				storageOut = null;
				isRequested = false;
				employee.increaseEventStep();
			}
		}
	}
	
	public void AddDedicatedStaff(Employee employee) {
		for (int i = 0; i < dedicatedStaff.length; i++) {
			if(dedicatedStaff[i]==null) {
				dedicatedStaff[i] = employee;
					switch(i) {
						case 0: employee.setPosition(Position.MACHINE_B_SLOT1); break;
						case 1:	employee.setPosition(Position.MACHINE_B_SLOT2); break;
						case 2:	employee.setPosition(Position.MACHINE_B_SLOT3); break;
						case 3:	employee.setPosition(Position.MACHINE_B_SLOT4); break;
						case 4:	employee.setPosition(Position.MACHINE_B_SLOT5); break;
						case 5:	employee.setPosition(Position.MACHINE_B_SLOT6); break;
					}
				employee.setAvailability(false);
				break;
			}
		}
	}
	
	public void drawItems(Graphics2D g2d) {
		if(storageInA!=null) {
			g2d.drawImage(storageInA.getImage(),storageInA.getxPos(),storageInA.getyPos(),null);
		}
		if(storageInB!=null) {
			g2d.drawImage(storageInB.getImage(),storageInB.getxPos(),storageInB.getyPos(),null);
		}
		if(storageOut!=null) {
			g2d.drawImage(storageOut.getImage(),storageOut.getxPos(),storageOut.getyPos(),null);
		}
	}

}
