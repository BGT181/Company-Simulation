package com.entities;

import java.awt.Graphics2D;
import java.awt.Image;

import com.entities.Product.productType;
import com.event.CEvent;
import com.event.CEvent.Event;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementTask.Position;

public class MachineA extends Machine{

	private Product storageIn;
	private Product storageOut;
	private productType previousProductType;
	private int pPosX = 660;
	private int pPosY = 185;
	
	public MachineA(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_A));
		this.company = company;
		standardTaskPoints = 50;
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
				
				if((company.getStorage().checkForProductType(productType.PRODUCT_A)>=0)&&!isRequested) {
					throwEvent(new CEvent(Event.MACHINE_A_REFILL));
					isRequested = true;
				} else {
					if(company.getStorage().checkForProductType(productType.PRODUCT_B)>=0&&!isRequested) {
						throwEvent(new CEvent(Event.MACHINE_A_REFILL));
						isRequested = true;
					}
				}
			} else {
				if(previousProductType!=null) {
					if(storageIn.getType()!=previousProductType) {
						calculateTaskPoints(2);
					} else {
						calculateTaskPoints(1);	
					}
				} else {
					calculateTaskPoints(1);
				}
				this.previousProductType = storageIn.getType();
				calculateEfficiency();
				isWorking = true;
			}		
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
				if(storageIn.getType()==productType.PRODUCT_A) {
					storageOut.setType(productType.PRODUCT_A_PROCESSED);
				} else {
					if(storageIn.getType()==productType.PRODUCT_B) {
						storageOut.setType(productType.PRODUCT_B_PROCESSED);
					}
				}
				storageIn = null;
				varTaskPoints = 0;
				efficiency = 0;
				throwEvent(new CEvent(Event.MACHINE_A_UNLOAD));
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
		if(employee.reachedPosition(Position.MACHINE_A)) {
			if(storageOut!=null) {
				employee.setCarryProduct(storageOut);
				storageOut = null;
				isRequested = false;
				storageIn = null;
				employee.increaseEventStep();
			}
		}
	}
	
	protected void calculateTaskPoints(int x) {
		this.taskPoints = 0;
		this.taskPoints = (standardTaskPoints + getRandomInt())*x;
	}
	
	public void AddDedicatedStaff(Employee employee) {
		for (int i = 0; i < dedicatedStaff.length; i++) {
			if(dedicatedStaff[i]==null) {
				dedicatedStaff[i] = employee;
					switch(i) {
						case 0: employee.setPosition(Position.MACHINE_A_SLOT1); break;
						case 1:	employee.setPosition(Position.MACHINE_A_SLOT2); break;
						case 2:	employee.setPosition(Position.MACHINE_A_SLOT3); break;
						case 3:	employee.setPosition(Position.MACHINE_A_SLOT4); break;
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
