package com.gamelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.entities.Employee;

public class Market implements ActionListener{

	Timer employeePayment = new Timer(10000, this);
	Timer marketRequest = new Timer(300000, this);
	private Company company;
	private double payments;
	
	public Market(Company company) {
		employeePayment.start();
		marketRequest.start();
		this.company = company;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==employeePayment) {
			for (Employee employee : company.getArrayListEmployee()) {
				payments += employee.getLoan();
			}
			company.setEbit(-payments);
			company.setCash(-payments);
			System.out.println(company.getCash());
			payments = 0;
		}
		
	}
	
	
}
