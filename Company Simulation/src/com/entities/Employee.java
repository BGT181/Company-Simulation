package com.entities;

import java.awt.Dimension;
import java.awt.Image;

import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementManager;
import com.gamelogic.MovementTask.Position;
import com.gamelogic.Task;

public class Employee extends Entity {

	public enum Qualification {
		LOGISTICS, 		// #0
		PREPROCESSING, 	// #1
		PROCESSING, 	// #2
		QUALITYCHECK 	// #3
	}
	
	public enum ImageType {
		EMPLOYEE_A,
		EMPLOYEE_B,
		EMPLOYEE_C
	}

	private Task task;
	private Product carryProduct;
	private MovementManager movementManager = new MovementManager(this);
	private ImageType imageType;
	private ImageProvider ip = new ImageProvider();
	
	
	private String name;
	private boolean[] qualification = new boolean[4];
	private double loan = 3000;
	private double efficiencyLvl = 1;
	private boolean isAvailable = true;
	private boolean isArrived = false;

	
	/*
	 * Constructor for the Employee-Class.
	 * Requires multiple argument, the only special is name.
	 */
	public Employee(Image image, int xPos, int yPos, int orientation, String name) {
		super(image, xPos, yPos, orientation);
		this.name = name;
	}
	
	public Employee(ImageType imageType, int xPos, int yPos, int orientation, String name) {
		super(null, xPos, yPos, orientation);
		changeImage(0,-1);
		this.imageType = imageType;
		this.name = name;
	}
	
	public Employee(ImageType imageType, Position position, String name) {
		super(null, 0, 0 ,0);
		//super.setxPos(movementManager.getMovementTask().getXofPosition(position));
		//super.setyPos(movementManager.getMovementTask().getYofPosition(position));
		this.name = name;
		changeImage(0,-1);
	}
	
	public void changeImage(int dirX, int dirY) {
		if(imageType == ImageType.EMPLOYEE_A) {
			switch(dirX) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_A_RIGHT));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_A_LEFT));	break;
			}
			switch(dirY) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_A_DOWN));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_A_UP));		break;
			}
		}
		
		if(imageType == ImageType.EMPLOYEE_B) {
			switch(dirX) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_B_RIGHT));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_B_LEFT));	break;
			}
			switch(dirY) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_B_DOWN));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_B_UP));		break;
			}
		}
		
		if(imageType == ImageType.EMPLOYEE_C) {
			switch(dirX) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_C_RIGHT));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_C_LEFT));	break;
			}
			switch(dirY) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_C_DOWN));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_C_UP));		break;
			}
		}	
	}

	//Increases the loan of this object by (double) x percent.
	public void increaseLoan(double increasementLoan) {
		this.loan = loan * increasementLoan;
	}

	//Getter for the loan.
	public double getLoan() {
		return this.loan;
	}

	//The efficiency-level of this employee object.
	public void increaseEfficiencyLvl(double increasementEfficiency) {
		this.efficiencyLvl = efficiencyLvl * increasementEfficiency;
	}

	//Getter for the efficiency-level.
	public double getEfficiencyLvl() {
		return this.efficiencyLvl;
	}

	//###Depends on Movement and Task
	//Setter for the availability of an employee.
	public void setAvailability(boolean availability) {
		this.isAvailable = availability;
	}

	//###Depends on Movement and Task
	//Getter for the availability of an employee.
	public boolean getAvailability() {
		return isAvailable;
	}

	//###Depends on Movement and Task
	//Getter for the arrived-parameter.
	public boolean isArrived() {
		return isArrived;
	}

	//###Depends on Movement and Task
	//Setter for the arrived-parameter.
	public void setArrived(boolean isArrived) {
		this.isArrived = isArrived;
	}

	//Setter for the position of an employee. 
	public void setPosition(int xPos, int yPos, int orientation) {
		super.setxPos(xPos);
		super.setyPos(yPos);
		super.setOrientation(orientation);
	}

	//Getter for the qualifications of an employee.
	//The parameter depends on the var of the boolean-array. Returns true or false.
	public boolean getQualification(int x) {
		return qualification[x];
	}

	
	//Setter for the qualification of an employee.
	//The parameter represents the slot an switch it, when called.
	public void setQualification(int qualificationNum) {
		this.qualification[qualificationNum] ^= true;
	}

	public String getName() {
		return name;
	}

	//Depends on Movement and Task
	public Task getTask() {
		return task;
	}

	//Depends on Movement and Task
	public void setTask(Task task) {
		this.task = task;
	}

	public MovementManager getMovementManager() {
		return movementManager;
	}

}
