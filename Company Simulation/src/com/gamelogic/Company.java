package com.gamelogic;

import java.util.ArrayList;

import com.entities.*;
import com.entities.Employee.ImageType;
import com.entities.Machine.MachineType;
import com.entities.Product.productType;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementTask.Position;
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
	
	private Truck truckEntrence;
	private Truck truckExit;
	
	private Storage storage = new Storage( 120, 230, null); 
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
		hireEmployee(0, ImageType.EMPLOYEE_A);
		employees.get(0).getMovementManager().getMovementTask().setDestination(Position.CHECKPOINT_A);

		setupMachines();
		
		Product product = new Product(imageProvider.getImage(Imagefor.PRODUCT_A), 100, 100, productType.PRODUCT_A);
		Product producta = new Product(imageProvider.getImage(Imagefor.PRODUCT_B), 100, 100, productType.PRODUCT_B);
		Product productb = new Product(imageProvider.getImage(Imagefor.PRODUCT_B), 100, 100, productType.PRODUCT_B);
		storage.storeProduct(product);
		storage.storeProduct(producta);
		storage.storeProduct(productb);
		
		
		
		
		truckEntrence = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 75, null);
		truckEntrence.orderProducts(productType.PRODUCT_A, 3);
	}
	
	public void setupMachines() {
		machines[0] = new Machine(imageProvider.getImage(Imagefor.MACHINE_A), 625, 80, 0, MachineType.MACHINE_A);
		machines[1] = new Machine(imageProvider.getImage(Imagefor.MACHINE_B), 600, 275, 0, MachineType.MACHINE_B);
		machines[2] = new Machine(imageProvider.getImage(Imagefor.MACHINE_C), 625, 520, 0, MachineType.MACHINE_C);
	}
	
	public void hireEmployee(int val, ImageType imageType) {
		String name = "E"+val;
		employees.add(new Employee(imageType, Position.TRUCK_ENTRANCE, name));

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


	public Storage getStorage() {
		return storage;
	}


	public Truck getTruckEntrence() {
		return truckEntrence;
	}


	public void setTruckEntrence(Truck truckEntrence) {
		this.truckEntrence = truckEntrence;
	}
	
}
