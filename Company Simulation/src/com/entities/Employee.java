package com.entities;

import java.awt.Dimension;
import java.awt.Image;

import com.gamelogic.Company.Tasks;

public class Employee extends Entity {

	public enum Qualification {
		LOGISTICS, // #0
		PREPROCESSING, // #1
		PROCESSING, // #2
		QUALITYCHECK // #3
	}

	private String name;
	private boolean[] qualification = new boolean[4];
	private double loan = 3000;
	private double efficiencyLvl = 1;
	private boolean isAvailable = true;
	private boolean isArrived = false;
	private Tasks task;

	public Employee(Image image, int xPos, int yPos, int orientation, String name) {
		super(image, xPos, yPos, orientation);
		this.name = name;
	}

//	public void process() {
//		switch (task) {
//		case GET_PRODUCT_A_TO_MACHINE_A:
//			
//			break;
//case GET_PRODUCT_B_TO_MACHINE_A:
//			
//			break;
//
//
//case GET_PRODUCT_A_PROCESSED_TO_MACHINE_B:
//	
//	break;
//
//
//case GET_PRODUCT_B_PROCESSED_TO_MACHINE_B:
//	
//	break;
//
//
//case :
//	
//	break;
//
//
//		
//		}
//	}

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

	public void setPosition(int xPos, int yPos, int orientation) {
		super.setxPos(xPos);
		super.setyPos(yPos);
		super.setOrientation(orientation);
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

	public Tasks getTask() {
		return task;
	}

	public void setTask(Tasks task) {
		this.task = task;
	}

}
