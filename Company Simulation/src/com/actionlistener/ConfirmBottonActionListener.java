package com.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.entities.Employee.ImageType;
import com.entities.Product.productType;
import com.framemanagement.ContentPanel;
import com.gamelogic.MovementTask.Position;

public class ConfirmBottonActionListener implements ActionListener{

	private JButton confirmButton;
	private ContentPanel contentPanel;
	
	private int amountA;
	private int amountB;
	private int priceC;
	private int increaseLoans;
	private int hireEmployee;
	
	public ConfirmBottonActionListener(JButton confirmButton, ContentPanel contentPanel) {
		super();
		this.confirmButton = confirmButton;
		this.contentPanel = contentPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.confirmButton) {
			readValues();
			process();
		}
	}

	private void readValues() {
		amountA = getValue(5);
		amountB = getValue(6);
		priceC = getValue(7);
		increaseLoans = getValue(8);
		hireEmployee = getValue(9);
	}
	
	private int getValue(int index) {
		JTextField TFamountA = (JTextField) this.contentPanel.getMenuManagement().get(index);
		double value;
			try {
				value = Double.parseDouble(TFamountA.getText());
			} catch (Exception e) {
				value = 0.0;
			}
		return (int) value;
	}

	
	private void process() {
		if((amountA>0)&&(amountA<15)&&(!contentPanel.getCompany().getTruckEntrence().isFinish())&&(contentPanel.getCompany().getTruckEntrence().isArrived())){
			contentPanel.getCompany().getTruckEntrence().orderProducts(productType.PRODUCT_A, amountA);
			amountA = 0;
		}
		
		if((amountB>0)&&(amountB<15)&&(!contentPanel.getCompany().getTruckEntrence().isFinish())&&(contentPanel.getCompany().getTruckEntrence().isArrived())){
			contentPanel.getCompany().getTruckEntrence().orderProducts(productType.PRODUCT_B, amountB);
			amountB = 0;
		}
		
		if((increaseLoans>0)&&(increaseLoans<20)) {
			contentPanel.getCompany().increaseLoans(increaseLoans);
			increaseLoans = 0;
		}
		
		
		if((hireEmployee>0)&&(hireEmployee<=5)&&((hireEmployee+contentPanel.getCompany().getArrayListEmployee().size())<=20)) {
			for (int i = 0; i < hireEmployee; i++) {
				contentPanel.getCompany().hireEmployee(Position.CHECKPOINT_B);
			}
		}
		
		
	}
}
