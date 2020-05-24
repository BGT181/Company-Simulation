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
	private double loan;
	private double efficiencyLvl; 
	private boolean isAvailable;
	
	public Employee(Image image, int xPos, int yPos, int orientation) {
		super(image, xPos, yPos, orientation);
	}

}
