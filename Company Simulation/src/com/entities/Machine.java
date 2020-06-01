package com.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

public class Machine extends Entity {

	private enum DurationFactors {
		MACHINE_A, // #0
		MACHINE_B, // #1
		MACHINE_C, // #2
	}

	private final int[] durationFactors = { 2, 5, 1 };
	private int durationFactor;
	private final int[] durationDifferenceRange = { -5, 5 };
	private final int standardDuration = 30;
	private Employee[] employee = new Employee[3];
	private int assignedEmployees = 0;
	private Product[] product = new Product[2];
	private Timer workingduration = new Timer();
	private Product.productType processableProduct;
	private DurationFactors machineType;
	private	final Product.productType[][] neededProducts = {{Product.productType.PRODUCT_A, Product.productType.PRODUCT_B},
															{Product.productType.PRODUCT_A_PROCESSED, Product.productType.PRODUCT_B_PROCESSED},
															{Product.productType.PRODUCT_C}};
	
	// __________________________________________________________________________________ _____________________________________
	public Machine(Image image, int xPos, int yPos, int orientation, DurationFactors durationFactorIndex) {
		super(image, xPos, yPos, 0);
		this.durationFactor = durationFactors[durationFactorIndex.ordinal()];
		this.machineType = durationFactorIndex;
	}

	// _______________________________________________________________________________________________________________________
	public void actionPerformed() {
		TimerTask process = new TimerTask() {
			public void run() {
				if(machineType == DurationFactors.MACHINE_A|| machineType == DurationFactors.MACHINE_B) {
					product[0].process();
					product[1].process();
				}else if(machineType == DurationFactors.MACHINE_C) {
					product[0].process();
				}
				// start event
			}
		};
		if(assignedEmployees > 0)
		workingduration.schedule(process, calculateduration());
	}
	
	private boolean checkAvailableProducts() {
		boolean toReturn = false;
		switch(machineType) {
		
		case MACHINE_A:
			if(product[1].getType() == Product.productType.PRODUCT_A)
			break;
		
		case MACHINE_B:
			toReturn = product[0].getType() == Product.productType.PRODUCT_A_PROCESSED && product[1].getType() == Product.productType.PRODUCT_B_PROCESSED || product[0].getType() == Product.productType.PRODUCT_B_PROCESSED && product[1].getType() == Product.productType.PRODUCT_A_PROCESSED;
			break;
			
		case MACHINE_C:
			toReturn = product[0].getType() == Product.productType.PRODUCT_C;
			break;
		}
		return toReturn;
	}

	private int calculateduration() {
		int duration;
		duration = durationFactor * standardDuration
				+ randomNumber(durationDifferenceRange[0], durationDifferenceRange[1]);
		for (int i = 0; i < assignedEmployees; i++) {
			duration *= employee[i].getEfficiencyLvl();
		}
		return duration;
	}

	private int randomNumber(int min, int max) {
		int random;
		random = min + (int) (Math.random() * ((max - min) + 1));
		return random;
	}

	// _______________________________________________________________________________________________________________________
	public void setProcessableProduct(Product.productType processableProduct) {
		this.processableProduct = processableProduct;
	}
	
	public Employee[] getEmployee() {
		return employee;
	}

	public void setEmployee(Employee[] employee) {
		this.employee = employee;
	}

	public void addEmployee(Employee newEmployee) {
		outerloop: if (assignedEmployees < 3) {
			if (newEmployee.getAvailability()) {
				for (int i = 0; i < assignedEmployees; i++) {
					if (newEmployee == employee[i]) {
						break outerloop; // Fehler: Der Mitarbeiter ist bereits dieser Maschine zugewiesen
					}
				}
				assignedEmployees++;
				newEmployee.setAvailability(false);
				employee[assignedEmployees] = newEmployee;
			} else {
				// Fehler: Der Mitarbeiter ist nicht frei
			}
		} else {
			// Fehler: Maschine bereits besetzt
		}
	}

	public void removeEmployee(Employee toRemoveEmployee) {
		outerloop: if (assignedEmployees > 0) {
			if (!toRemoveEmployee.getAvailability()) {
				for (int i = 0; i < assignedEmployees; i++) {
					if (employee[i] == toRemoveEmployee) {
						for (int j = i + 1; j < assignedEmployees; j++) {
							employee[j - 1] = employee[j];
						}
						employee[assignedEmployees] = null;
						assignedEmployees--;
						toRemoveEmployee.setAvailability(true);
						break outerloop;
					}
				}
				// Fehler: Der Mitarbeiter ist dieser Maschine nicht zugewiesen
			} else {
				// Fehler: Der Mitarbeiter ist keine Maschine zugewiesen
			}
		} else {
			// Fehler: Die Maschine ist nicht besetzt
		}
	}

}
