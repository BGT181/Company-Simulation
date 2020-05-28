package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Employee extends Entity{

	public enum Qualification {
		LOGISTICS,		//#0
		PREPROCESSING,	//#1
		PROCESSING,		//#2
		QUALITYCHECK	//#3
	}
	
	private String name;
	private boolean[] qualification = new boolean[4];
	private double loan = 3000;
	private double efficiencyLvl = 1; 
	private boolean isAvailable = true;
	
	public Employee(Image image, int xPos, int yPos, int orientation, String name) {
		super(image, xPos, yPos, orientation);
		this.name = name;
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

	public boolean getQualification(int x) {
		return qualification[x];
	}

	public void setQualification(int qualificationNum) {
		this.qualification[qualificationNum] ^= true;
	}

	public String getName() {
		return name;
	}

}
