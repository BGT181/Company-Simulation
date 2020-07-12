package com.gamelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.entities.Employee;
import com.entities.Product.productType;

public class Market implements ActionListener{

	Timer employeePayment = new Timer(900000, this);
	Timer marketRequest = new Timer(150000, this);
	private Company company;
	private double payments;
	private int normalPrice = 3000;
	private int faktor = 50;
	private int order = 0;
	
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
			payments = 0;
			company.setCash(-5000);
		}
		
		if(e.getSource()==marketRequest) {
			normalPrice -= faktor;
			if(company.getPriceC()<=normalPrice) {
				if((company.getStorage().amountOfProduct(productType.PRODUCT_C_CERTIFIED)-order)>0) {
					int amount = (company.getStorage().amountOfProduct(productType.PRODUCT_C_CERTIFIED)-order);
					company.getTruckExit().soldProduct(amount);
					company.setEbit(company.getPriceC()*amount);
					company.setCash(company.getPriceC()*amount);
					company.setRevenue(company.getPriceC()*amount);
					company.setProductssold(amount);
					setOrder(amount);
				}	
			}
		}
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order += order;
	}
	
	
}
