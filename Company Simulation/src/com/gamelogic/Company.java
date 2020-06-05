package com.gamelogic;

import java.util.ArrayList;

import com.entities.*;
import com.entities.Machine.MachineType;
import com.entities.Product.productType;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.Task.Tasks;


public class Company {

	/**
	 * Master-Class. All Objects will be stored here.
	 * Time: One Session is 1 hour = 60 minutes.
	 * In this time one year will happen. That results to following rules:
	 *  12 months ingame = 1 Hour realtime 
	 * 	1 month ingame = 5 minutes realtime
	 * 	1 month ingame = 30 days ingame
	 * 	1 day ingame = 10 seconds realtime
	 * 	1 year ingame = 3600 seconds realtime = 3600000 ms realtime
	 * 
	 */
	
	private double revenue;
	private double cash;
	private double ebit;
	private int productssold;
	private double runningcosts;
	
	private ImageProvider imageProvider = new ImageProvider();
	
	private Storage storage = new Storage(imageProvider.getImage(Imagefor.STORAGE), 130, 225, null); 
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private Machine[] machines = new Machine[3];
	public static ArrayList<Tasks> tasklist = new ArrayList<Tasks>();
	
	
	public Company(boolean check) {
		if(check) {
			setupCompany();
		}
	}
	
	
	public void process() {
		
	}
	
	public void checkEmployeesTasks() {
		for (int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getTask() == null) {
				//employees.get(i).setTask(mostImportantTask(employees.get(i)));
				tasklist.remove(mostImportantTask(employees.get(i)));
			}
		}	
	}
	
	public Tasks mostImportantTask(Employee employee) {
		Tasks toReturnTask = null;
		if(!employee.getQualification(0)) {
			if(employee.getQualification(1) && tasklist.contains(Tasks.PROCESS_MACHINE_A)) {
				toReturnTask = Tasks.PROCESS_MACHINE_A;
			} else if(employee.getQualification(2) && tasklist.contains(Tasks.PROCESS_MACHINE_B)) {
				toReturnTask = Tasks.PROCESS_MACHINE_B;
			} else if(employee.getQualification(3) && tasklist.contains(Tasks.PROCESS_MACHINE_C)) {
				toReturnTask = Tasks.PROCESS_MACHINE_C;
			}
		} else {
			if(tasklist.contains(Tasks.GET_PRODUCT_A_TO_MACHINE_A) && storage.testProductAvailability(productType.PRODUCT_A)) {
				toReturnTask = Tasks.GET_PRODUCT_A_TO_MACHINE_A;
			} else if(tasklist.contains(Tasks.GET_PRODUCT_B_TO_MACHINE_A) && storage.testProductAvailability(productType.PRODUCT_B)) {
				toReturnTask = Tasks.GET_PRODUCT_B_TO_MACHINE_A;
			} //weitere tausende else if methoden
			
		}
		
		return toReturnTask;
	}
	
	public void checkIfMachineNeedEmployee() {
		for (int i = 0; i < machines.length; i++) {
			if(!machines[i].isInputPossible() && !machines[i].isOutputPossible()) {
				switch (machines[i].getMachineType()) {
				case MACHINE_A:
					tasklist.add(Tasks.PROCESS_MACHINE_A);
					break;

				case MACHINE_B:
					tasklist.add(Tasks.PROCESS_MACHINE_B);
					break;
					
				case MACHINE_C:
					tasklist.add(Tasks.PROCESS_MACHINE_C);
					break;
				}
			}
		}
	}
	
	public void setupCompany() {
		hireEmployee(0, Imagefor.EMPLOYEE_A);
		hireEmployee(1, Imagefor.EMPLOYEE_B);
		hireEmployee(2, Imagefor.EMPLOYEE_C);
		setupMachines();
	}
	
	public void setupMachines() {
		machines[0] = new Machine(imageProvider.getImage(Imagefor.MACHINE_A), 625, 80, 0, MachineType.MACHINE_A);
		machines[1] = new Machine(imageProvider.getImage(Imagefor.MACHINE_B), 600, 275, 0, MachineType.MACHINE_B);
		machines[2] = new Machine(imageProvider.getImage(Imagefor.MACHINE_C), 625, 520, 0, MachineType.MACHINE_C);
	}
	
	public void hireEmployee(int val, Imagefor image) {
		String name = "E"+val;
		employees.add(new Employee(imageProvider.getImage(image), 0, 0, 0, name));
	}
	
	public void print() {
		System.out.println("Company");
	}

	public void addTask(Tasks task) {
		tasklist.add(task);
	}
	
	public ArrayList<Employee> getArrayListEmployee() {
		return this.employees;
	}
	
	public Employee getEmployee(int index) {
		return employees.get(index);
	}

	public Machine[] getMachines() {
		return machines;
	}
	
}
