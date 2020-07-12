package com.gamelogic;

import java.util.ArrayList;
import java.util.Random;

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
	private double cash = 50000;
	private double ebit;
	private int productssold;
	private int priceC = 2995;
	private int priceA = 250;
	private int priceB = 500;
	private int monthlyLoans;
	
	
	private Truck truckEntrence;
	private Truck truckExit;
	private MachineA machineA;
	private MachineB machineB;
	private MachineC machineC;
	
	private Storage storage = new Storage( 120, 230, null); 
	private ArrayList<Employee> employees = new ArrayList<Employee>();


	private ImageProvider imageProvider = new ImageProvider();
	private CEventListenerController ELC = new CEventListenerController(employees);
	private Market market = new Market(this);
	
	public Company(boolean check) {
		if(check) {
			setupMachines();
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
		employees.add(employee);
		refreshMonthlyLoan();
	}
	public void hireEmployee(Position position) {
		String name = "E"+employees.size();
		
		ImageType imagetype;
		Random rand = new Random();
		switch(rand.nextInt(2)) {
			case 0: imagetype = ImageType.EMPLOYEE_A; break;
			case 1: imagetype = ImageType.EMPLOYEE_B; break;
			case 2: imagetype = ImageType.EMPLOYEE_C; break;
			default: imagetype = ImageType.EMPLOYEE_C; break;
		}
		Employee employee = new Employee(imagetype, position, name, this);
		employees.add(employee);
		refreshMonthlyLoan();
	}

	public void setupEmployees() {
		hireEmployee(Position.CHECKPOINT_B);
		hireEmployee(Position.CHECKPOINT_B);
		hireEmployee(Position.CHECKPOINT_B);
		hireEmployee(Position.CHECKPOINT_B);
		hireEmployee(Position.CHECKPOINT_B);
		hireEmployee(Position.CHECKPOINT_B);
		hireEmployee(Position.CHECKPOINT_B);
		hireEmployee(Position.CHECKPOINT_B);
	}
	
	public void setupTrucks() {
		truckEntrence = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 75,this);
		truckExit = new Truck(imageProvider.getImage(Imagefor.TRUCK), -250, 575,this);
	}
	
	public void increaseLoans(int x) {
		for (Employee employee : employees) {
			Double sp = (double)x/100; 
			employee.increaseLoan(sp);
			sp=(double) 0;
		}
		refreshMonthlyLoan();
	}

	public void refreshMonthlyLoan() {
		monthlyLoans = 0;
		for (Employee employee : employees) {
			monthlyLoans += employee.getLoan();
		}
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

	public double getEbit() {
		return ebit;
	}

	public void setEbit(double ebit) {
		this.ebit += ebit;
	}

	public int getProductssold() {
		return productssold;
	}

	public void setProductssold(int productssold) {
		this.productssold += productssold;
	}

	public int getPriceC() {
		return priceC;
	}

	public void setPriceC(int priceC) {
		this.priceC = priceC;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue += revenue;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash += (cash*0.95);
	}

	public int getPriceB() {
		return priceB;
	}

	public void setPriceB(int priceB) {
		this.priceB = priceB;
	}

	public Market getMarket() {
		return market;
	}

	public int getMonthlyLoans() {
		return monthlyLoans;
	}

	public void setMonthlyLoans(int monthlyLoans) {
		this.monthlyLoans = monthlyLoans;
	}
	
	
	
}
