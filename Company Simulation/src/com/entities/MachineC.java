package com.entities;

import java.awt.Image;

import com.event.CEvent;
import com.event.CEvent.Event;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;


public class MachineC extends Machine{

	Product storageIn;
	Product storageOut;
	
	public MachineC(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_C));
		standardTaskPoints = 300;
		isWorking = false;
		dedicatedStaff = new Employee[2];
	}

	public void process() {
		
	}
	
	public void loadMachine(Employee employee) {
		if(employee.getCarryProduct()!=null) {
			storageIn = employee.getCarryProduct();
			setupMachine();
			employee.increaseEventStep();
		}
	}
	
	public void unloadMachine(Employee employee) {
		if(employee.getCarryProduct()!=null) {
			employee.setCarryProduct(storageOut);
			storageOut = null;
			employee.increaseEventStep();
		}
	}
	
	protected void setupMachine() {
		if(storageIn==null) {
			throwEvent(new CEvent(Event.MACHINE_C_REFILL));
		} else {
			calculateTaskPoints();
			calculateEfficiency();
		}
	}
	
	
	protected void calculateTaskPoints() {
		taskPoints = standardTaskPoints+getRandomInt();
	}
	
	protected void calculateEfficiency() {
		for (int i = 0; i < dedicatedStaff.length; i++) {
			if(dedicatedStaff[i]!=null) {
				efficiency += dedicatedStaff[i].getEfficiencyLvl();
			}
		}
		if(efficiency<=0) {
			efficiency = 0.1;
		}
	}
	
}
