package com.entities;

import java.awt.Dimension;
import java.awt.Image;

import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementManager;
import com.gamelogic.MovementTask.Position;


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

	private String name;
	private boolean[] qualification = new boolean[4];
	private double loan = 3000;
	private double efficiencyLvl = 1;
	private boolean isAvailable = true;
	private boolean isArrived = false;
	
	private Product carryProduct;
	private MovementManager movementManager = new MovementManager(this);
	private ImageType imageType;
	private ImageProvider ip = new ImageProvider();
	
	
	public Employee(ImageType imageType, Position position, String name) {
		super(null, 1, 1 ,0);		
		setPosition(position);
		this.name = name;
		this.imageType = imageType;
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

	public void increaseLoan(double increasementLoan) {
		this.loan = loan * increasementLoan;
	}
	public double getLoan() {
		return this.loan;
	}
	public void increaseEfficiencyLvl(double increasementEfficiency) {
		this.efficiencyLvl = efficiencyLvl * increasementEfficiency;
	}
	public double getEfficiencyLvl() {
		return this.efficiencyLvl;
	}
	public void setAvailability(boolean availability) {
		this.isAvailable = availability;
	}
	public boolean getAvailability() {
		return isAvailable;
	}
	public boolean isArrived() {
		return isArrived;
	}
	public void setArrived(boolean isArrived) {
		this.isArrived = isArrived;
	}
	public void setPosition(Position position) {
		super.setxPos(movementManager.getMovementTask().getXofPosition(position));
		super.setyPos(movementManager.getMovementTask().getYofPosition(position));
	}
	public boolean getQualification(int x) {
		return qualification[x];
	}
	public void setQualification(int qualificationNum) {
		this.qualification[qualificationNum] ^= true;
	}
	public String getName() {
		return name;
	}
	public MovementManager getMovementManager() {
		return movementManager;
	}
}
