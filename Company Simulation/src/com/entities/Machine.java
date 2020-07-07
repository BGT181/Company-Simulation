package com.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.entities.Product.productType;
import com.gamelogic.*;


public class Machine extends Entity {

	public enum MachineType {
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
	private Product[] product = new Product[3];
	private int numberOfProducts = 0;
	private Product processedProduct;
	private boolean inputPossible = true;
	private boolean outputPossible = false;
	private Timer workingduration = new Timer();
	private productType processableProduct = productType.PRODUCT_A;
	private MachineType machineType;
	private ArrayList<productType> neededProduct = new ArrayList<productType>();
	private Company company = new Company(false);

	
	public Machine(Image image, int xPos, int yPos, int orientation, MachineType machineType) {
		super(image, xPos, yPos, 0);
		this.durationFactor = durationFactors[machineType.ordinal()];
		this.machineType = machineType;
	}

	// _______________________________________________________________________________________________________________________
	public void process() {
		TimerTask process = new TimerTask() {
			public void run() {
				if (machineType == MachineType.MACHINE_A || machineType == MachineType.MACHINE_C) {
					
					processedProduct = product[0];
					product[0] = null;
				} else if (machineType == MachineType.MACHINE_B) {
					for (int i = 0; i < product.length; i++) {
						if (product[i].getType() == productType.PRODUCT_B_PROCESSED) {
							
							processedProduct = product[i];
						} else {
							product[i] = null;
						}
					}
				}
				numberOfProducts = 0;
				inputPossible = true;
				outputPossible = true;
				updateNeededProducts();
				addNeededProductsToTasklist();
				switch (machineType) {
				case MACHINE_A:
					company.addTask(Task.Tasks.GET_PRODUCT_FROM_MACHINE_A);
					break;

				case MACHINE_B:
					company.addTask(Task.Tasks.GET_PRODUCT_FROM_MACHINE_B);
					break;

				case MACHINE_C:
					company.addTask(Task.Tasks.GET_PRODUCT_FROM_MACHINE_C);
					break;

				}
				
			}
		};
		workingduration.schedule(process, calculateduration());
	}

	public boolean checkIfReadyToProcess() {
		if(!inputPossible && !outputPossible && assignedEmployees > 0) {
			return true;
		} else {
			return false;
		}
	}

	private int calculateduration() {
		int duration;
		duration = durationFactor * standardDuration
				+ randomNumber(durationDifferenceRange[0], durationDifferenceRange[1]);
		for (int i = 0; i < assignedEmployees; i++) {
			duration -= employee[i].getEfficiencyLvl() * 2;
		}
		return duration;
	}

	private int randomNumber(int min, int max) {
		int random;
		random = min + (int) (Math.random() * ((max - min) + 1));
		return random;
	}

	private void updateNeededProducts() {
		switch (machineType) {
		case MACHINE_A:
			neededProduct.add(processableProduct);
			break;

		case MACHINE_B:
			neededProduct.add(productType.PRODUCT_A_PROCESSED);
			neededProduct.add(productType.PRODUCT_A_PROCESSED);
			neededProduct.add(productType.PRODUCT_B_PROCESSED);
			break;

		case MACHINE_C:
			neededProduct.add(productType.PRODUCT_C);
			break;
		}
	}

	public void addNeededProductsToTasklist() {
		switch (machineType) {
		case MACHINE_A:
			if(processableProduct == productType.PRODUCT_A) {
				company.addTask(Task.Tasks.GET_PRODUCT_A_TO_MACHINE_A);
			}else if(processableProduct == productType.PRODUCT_B) {
				company.addTask(Task.Tasks.GET_PRODUCT_B_TO_MACHINE_A);
			}
			break;

		case MACHINE_B:
			company.addTask(Task.Tasks.GET_PRODUCT_A_PROCESSED_TO_MACHINE_B);
			company.addTask(Task.Tasks.GET_PRODUCT_A_PROCESSED_TO_MACHINE_B);
			company.addTask(Task.Tasks.GET_PRODUCT_B_PROCESSED_TO_MACHINE_B);
			break;

		case MACHINE_C:
			company.addTask(Task.Tasks.GET_PRODUCT_C_TO_MACHINE_C);
			break;

		}
	}

	// _______________________________________________________________________________________________________________________
	public void setProcessableProduct(productType processableProduct) {
		this.processableProduct = processableProduct;
		updateNeededProducts();
	}

	public int getAssignedEmployees() {
		return assignedEmployees;
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

	public void addProduct(Product toAddProduct) {
		outerloop: for (int i = 0; i < product.length; i++) {
			if (product[i] == null) {
				product[i] = toAddProduct;
				break outerloop;
			}
		}
		numberOfProducts++;
		if (machineType == MachineType.MACHINE_B) {
			inputPossible = numberOfProducts < product.length;
		} else {
			inputPossible = false;
		}
		neededProduct.remove(toAddProduct.getType());
	}

	public Product getProcessedProduct() {
		return processedProduct;
	}

	public Product getProcessedProductFromMachine() {
		Product toReturnProduct = processedProduct;
		processedProduct = null;
		return toReturnProduct;
	}

	public boolean isInputPossible() {
		return inputPossible;
	}

	public boolean isOutputPossible() {
		return outputPossible;
	}

	public MachineType getMachineType() {
		return machineType;
	}
	
}
