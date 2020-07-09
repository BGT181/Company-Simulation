package com.gamelogic;

import java.util.ArrayList;

import com.entities.*;
import com.entities.Employee.ImageType;
import com.entities.Product.productType;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementTask.Position;


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
	
	private Truck truckEntrence;
	private Truck truckExit;
	private MachineA machineA;
	private MachineB machineB;
	private MachineC machineC;
	
	private Storage storage = new Storage( 120, 230, null); 
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	
	
	public Company(boolean check) {
		if(check) {
			setupCompany();
			setupMachines();
		}
	}
	
	
	public void process() {
		
	}
	
	public void setupCompany() {
		hireEmployee(0, ImageType.EMPLOYEE_A);
		employees.get(0).getMovementManager().setMovementTask(Position.MACHINE_C, Position.TRUCK_ENTRANCE);
		hireEmployee(1, ImageType.EMPLOYEE_B);
		employees.get(1).getMovementManager().setMovementTask(Position.TRUCK_ENTRANCE, Position.TRUCK_EXIT);
		
		
		
		Product product = new Product(imageProvider.getImage(Imagefor.PRODUCT_A), 100, 100, productType.PRODUCT_A);
		Product producta = new Product(imageProvider.getImage(Imagefor.PRODUCT_B), 100, 100, productType.PRODUCT_B);
		Product productb = new Product(imageProvider.getImage(Imagefor.PRODUCT_B), 100, 100, productType.PRODUCT_B);
		storage.storeProduct(product);
		storage.storeProduct(producta);
		storage.storeProduct(productb);
		
		
		truckEntrence = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 75);
		truckEntrence.orderProducts(productType.PRODUCT_A, 3);
	}
	
	public void setupMachines() {
		machineA = new MachineA(null, 625, 80);
		machineB = new MachineB(null, 600, 275);
		machineC = new MachineC(null, 625, 520);
	}
	
	public void hireEmployee(int val, ImageType imageType) {
		String name = "E"+val;
		employees.add(new Employee(imageType, Position.STORAGE, name));

	}

	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Employee> getArrayListEmployee() {
		return this.employees;
	}
	
	public Employee getEmployee(int index) {
		return employees.get(index);
	}


	public Storage getStorage() {
		return storage;
	}


	public Truck getTruckEntrence() {
		return truckEntrence;
	}


	public void setTruckEntrence(Truck truckEntrence) {
		this.truckEntrence = truckEntrence;
	}


	public MachineA getMachineA() {
		return machineA;
	}


	public void setMachineA(MachineA machineA) {
		this.machineA = machineA;
	}


	public MachineB getMachineB() {
		return machineB;
	}


	public void setMachineB(MachineB machineB) {
		this.machineB = machineB;
	}


	public MachineC getMachineC() {
		return machineC;
	}


	public void setMachineC(MachineC machineC) {
		this.machineC = machineC;
	}


	public Truck getTruckExit() {
		return truckExit;
	}


	public void setTruckExit(Truck truckExit) {
		this.truckExit = truckExit;
	}
	
}
