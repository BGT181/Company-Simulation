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
	
	private int priceA = 200;
	
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
	
	public void hireEmployee(int val, ImageType imageType, Position position, int qualification) {
		String name = "E"+val;
		Employee employee = new Employee(imageType, position, name, this);
		employee.setQualification(qualification);
		employees.add(employee);
	}

	public void setupEmployees() {
		hireEmployee(0, ImageType.EMPLOYEE_A,Position.MACHINE_A,1);
		hireEmployee(1, ImageType.EMPLOYEE_B, Position.STORAGE,0);
		hireEmployee(2, ImageType.EMPLOYEE_C, Position.MACHINE_B,2);
		hireEmployee(3, ImageType.EMPLOYEE_C, Position.CHECKPOINT_B,0);
		hireEmployee(4, ImageType.EMPLOYEE_A, Position.CHECKPOINT_C, 3);
		hireEmployee(5, ImageType.EMPLOYEE_B, Position.CHECKPOINT_A,1);
		hireEmployee(6, ImageType.EMPLOYEE_A, Position.CHECKPOINT_A,2);
		hireEmployee(7, ImageType.EMPLOYEE_C, Position.CHECKPOINT_A,2);
		hireEmployee(8, ImageType.EMPLOYEE_B, Position.CHECKPOINT_A,2);
	}
	
	public void setupProducts() {
		Product product = new Product(imageProvider.getImage(Imagefor.PRODUCT_A), 120, 120, productType.PRODUCT_A);
		Product producta = new Product(imageProvider.getImage(Imagefor.PRODUCT_B), 120, 120, productType.PRODUCT_B);
		Product productb = new Product(imageProvider.getImage(Imagefor.PRODUCT_B), 120, 120, productType.PRODUCT_B);
		Product productc = new Product(imageProvider.getImage(Imagefor.PRODUCT_A), 120, 120, productType.PRODUCT_A);
		Product productd = new Product(imageProvider.getImage(Imagefor.PRODUCT_B_PROCESSED), 120, 120, productType.PRODUCT_B_PROCESSED);
		Product producte = new Product(imageProvider.getImage(Imagefor.PRODUCT_B_PROCESSED), 120, 120, productType.PRODUCT_B_PROCESSED);
		storage.storeProduct(product,null);
		storage.storeProduct(producta,null);
		storage.storeProduct(productb,null);
		storage.storeProduct(productc,null);
		storage.storeProduct(productd,null);
		storage.storeProduct(producte,null);
	}
	
	public void setupTrucks() {
		truckEntrence = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 75,this);
		truckEntrence.orderProducts(productType.PRODUCT_A, 3);
		truckExit = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 575,this);
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

	public int getPriceA() {
		return priceA;
	}

	public void setPriceA(int priceA) {
		this.priceA = priceA;
	}
	
	
	
}
