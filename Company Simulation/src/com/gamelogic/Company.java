package com.gamelogic;

import java.util.ArrayList;

import com.entities.*;
import com.entities.Employee.ImageType;
import com.entities.Product.productType;
import com.event.CEvent;
import com.event.CEvent.Event;
import com.event.CEventListenerController;
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
	
	private Truck truckEntrence;
	private Truck truckExit;
	private MachineA machineA;
	private MachineB machineB;
	private MachineC machineC;
	
	private Storage storage = new Storage( 120, 230, null); 
	private ArrayList<Employee> employees = new ArrayList<Employee>();


	private ImageProvider imageProvider = new ImageProvider();
	private CEventListenerController ELC = new CEventListenerController(employees);
	
	public Company(boolean check) {
		if(check) {
			setupMachines();
			
			setupProducts();
			setupTrucks();
			setupEmployees();
		}
	}
	
	public void setupMachines() {
		machineA = new MachineA(null, 625, 80,this);
		machineB = new MachineB(null, 600, 275,this);
		machineC = new MachineC(null, 625, 520,this);
	}
	
	public void hireEmployee(int val, ImageType imageType, Position position) {
		String name = "E"+val;
		Employee employee = new Employee(imageType, position, name, this);
		employees.add(employee);
	}

	public void setupEmployees() {
		hireEmployee(0, ImageType.EMPLOYEE_A,Position.TRUCK_ENTRANCE);
		hireEmployee(1, ImageType.EMPLOYEE_B, Position.TRUCK_EXIT);
		hireEmployee(2, ImageType.EMPLOYEE_C, Position.TRUCK_ENTRANCE);
		hireEmployee(3, ImageType.EMPLOYEE_C, Position.MACHINE_A_SLOT1);
		hireEmployee(4, ImageType.EMPLOYEE_A, Position.MACHINE_A_SLOT2);
		hireEmployee(5, ImageType.EMPLOYEE_B, Position.MACHINE_A_SLOT3);
		hireEmployee(6, ImageType.EMPLOYEE_C, Position.MACHINE_A_SLOT4);
		hireEmployee(7, ImageType.EMPLOYEE_A, Position.MACHINE_B_SLOT1);
		hireEmployee(8, ImageType.EMPLOYEE_B, Position.MACHINE_B_SLOT2);
		hireEmployee(9, ImageType.EMPLOYEE_C, Position.MACHINE_B_SLOT3);
		hireEmployee(10, ImageType.EMPLOYEE_C, Position.MACHINE_B_SLOT4);
		hireEmployee(11, ImageType.EMPLOYEE_B, Position.MACHINE_B_SLOT5);
		hireEmployee(12, ImageType.EMPLOYEE_A, Position.MACHINE_B_SLOT6);
		hireEmployee(13, ImageType.EMPLOYEE_B, Position.MACHINE_C_SLOT1);
		hireEmployee(14, ImageType.EMPLOYEE_C, Position.MACHINE_C_SLOT2);
		
		employees.get(2).setAssignedEvent(new CEvent(Event.MACHINE_C_UNLOAD));
		employees.get(7).setAssignedEvent(new CEvent(Event.MACHINE_C_REFILL));
		

	}
	
	public void setupProducts() {
		Product product = new Product(imageProvider.getImage(Imagefor.PRODUCT_A), 100, 100, productType.PRODUCT_A);
		Product producta = new Product(imageProvider.getImage(Imagefor.PRODUCT_B), 100, 100, productType.PRODUCT_B);
		Product productb = new Product(imageProvider.getImage(Imagefor.PRODUCT_C), 100, 100, productType.PRODUCT_C);
		storage.storeProduct(product,null);
		storage.storeProduct(producta,null);
		storage.storeProduct(productb,null);
	}
	
	public void setupTrucks() {
		truckEntrence = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 75);
		truckEntrence.orderProducts(productType.PRODUCT_A_PROCESSED, 2);
		truckExit = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 575);
		truckExit.soldProduct(1);
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
	
	public CEventListenerController getELC() {
		return ELC;
	}
	
	
	
}
