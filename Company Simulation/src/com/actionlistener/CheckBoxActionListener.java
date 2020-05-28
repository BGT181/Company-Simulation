package com.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.entities.Employee;

public class CheckBoxActionListener implements ActionListener{

	JCheckBox checkBox1;
	JCheckBox checkBox2;
	JCheckBox checkBox3;
	JCheckBox checkBox4;
	Employee employee;
	
	public CheckBoxActionListener(Employee employee, JCheckBox checkBox1, JCheckBox checkBox2, JCheckBox checkBox3, JCheckBox checkBox4) {
		this.checkBox1 = checkBox1;
		this.checkBox2 = checkBox2;
		this.checkBox3 = checkBox3;
		this.checkBox4 = checkBox4;
		this.employee = employee;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("triggered1");
		if(event.getSource()==this.checkBox1) {
			System.out.println("triggered");
			employee.setQualification(0);
		}
		if(event.getSource()==this.checkBox2) {
			employee.setQualification(1);
		}
		if(event.getSource()==this.checkBox3) {
			employee.setQualification(2);
		}
		if(event.getSource()==this.checkBox4) {
			employee.setQualification(3);
		}
		
	}
	
	
}
