package com.gamelogic;

import java.util.ArrayList;

import com.entities.*;
import com.entities.Machine.MachineType;
import com.entities.Product.productType;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementTask.Move;
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
	
	public void setupCompany() {
		hireEmployee(0, Imagefor.EMPLOYEE_A);
		hireEmployee(1, Imagefor.EMPLOYEE_B);
		employees.get(1).getMovementManager().setMovementTask(Move.STORAGE_TO_TRUCK_EXIT);
		//hireEmployee(2, Imagefor.EMPLOYEE_C);
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
