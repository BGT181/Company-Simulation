package com.framemanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FrameComponents {

	private ContentPanel contentPanel;
	
	public FrameComponents(ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
	}
	
	JButton buttonDashboard = new JButton("Dashboard");
	JButton buttonManagement = new JButton("Management"); 
	JButton buttonEmployees = new JButton("Employees");
	
	public void addComponents() {
		addButton(buttonDashboard,  800, 0);
		addButton(buttonManagement, 931, 0);
		addButton(buttonEmployees, 1062, 0);
	}
	
	
	private void addButton(JButton button, int x, int y) {
		button.setBounds(x, y, 130, 50);
		contentPanel.add(button);
	}
	/*
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==this.buttonDashboard) {
			System.out.println("Dasbutton pressed");
		} if (event.getSource()==this.buttonManagement) {
			System.out.println("Managementbutton pressed");
		}
	}
	*/
}
