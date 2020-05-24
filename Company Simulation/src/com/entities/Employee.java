package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Employee extends Entity{

	public enum Qualification {
		LOGISTICS,
		PREPROCESSING,
		PROCESSING,
		QUALITYCHECK
	}
	
	private boolean[] qualification = new boolean[4];
	private double loan = 3000;
	private double efficiencyLvl = 1; 
	private boolean isAvailable = true;
	
	public Employee(Image image, int xPos, int yPos, int orientation) {
		super(image, xPos, yPos, orientation);
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
	
	public void setPosition(int xPos, int yPos, int orientation) {
		super.setxPos(xPos);
		super.setyPos(yPos);
		super.setOrientation(orientation);
	}

	public boolean[] getQualification() {
		return qualification;
	}

	public void setQualification(boolean[] qualification) {
		this.qualification = qualification;
	}

}
