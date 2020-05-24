package com.gamelogic;

import java.util.ArrayList;

import com.entities.*;


public class Company {

	private double revenue;
	private double cash;
	private double ebit;
	private int productssold;
	private double runningcosts;
	
	private ArrayList<Storage> storages = new ArrayList<Storage>();
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	
	public Company() {
		
	}
	
	public void print() {
		System.out.println("Company");
	}
}
