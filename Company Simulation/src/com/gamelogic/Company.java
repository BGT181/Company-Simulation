package com.gamelogic;

import java.util.ArrayList;

import com.entities.*;


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
	
	private ArrayList<Storage> storages = new ArrayList<Storage>(); //TODO zu Array abändern
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public Company() {
		hireEmployee();
		hireEmployee();
		hireEmployee();
	}
	
	public void hireEmployee() {
		employees.add(new Employee(null, 0, 0, 0));
	}
	
	public ArrayList<Employee> getArrayListEmployee() {
		return this.employees;
	}
	
	public Employee getEmployee(int index) {
		return employees.get(index);
	}

	public void print() {
		System.out.println("Company");
	}
}
