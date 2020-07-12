package com.gamelogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.entities.Employee;
import com.entities.Product.productType;

public class Market implements ActionListener{

	Timer employeePayment = new Timer(900000, this);
	Timer marketRequest = new Timer(60000, this);
	private Company company;
	private double payments;
	private int normalPrice = 3000;
	private int faktor = 50;
	
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
			System.out.println("registered");
			System.out.println(company.getStorage().amountOfProduct(productType.PRODUCT_C_CERTIFIED));
			if(company.getPriceC()<=normalPrice) {
				if(company.getStorage().amountOfProduct(productType.PRODUCT_C_CERTIFIED)>0) {
					
					company.getTruckExit().soldProduct((company.getStorage().amountOfProduct(productType.PRODUCT_C_CERTIFIED)));
					company.setEbit(company.getPriceC()*company.getStorage().amountOfProduct(productType.PRODUCT_C_CERTIFIED));
					company.setCash(company.getPriceC()*company.getStorage().amountOfProduct(productType.PRODUCT_C_CERTIFIED));
				}	
			}
		}
	}
	
	
}
