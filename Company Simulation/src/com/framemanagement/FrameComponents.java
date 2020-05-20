package com.framemanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.actionlistener.ButtonActionListener;

public class FrameComponents {

	private ContentPanel contentPanel;
	public enum optionPanel { DASHBOARD, MANAGEMENT, EMPLOYEE }
	private optionPanel currentOptionPanel = optionPanel.DASHBOARD;
	
	public FrameComponents(ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
	}
	
	JButton buttonDashboard = new JButton("Dashboard");
	JButton buttonManagement = new JButton("Management"); 
	JButton buttonEmployees = new JButton("Employees");
	ButtonActionListener buttonActionListener = new ButtonActionListener(this, buttonDashboard,buttonManagement,buttonEmployees);
	
	
	public void addComponents() {
		addButton(buttonDashboard,  800, 0);
		addButton(buttonManagement, 931, 0);
		addButton(buttonEmployees, 1062, 0);
		System.out.println(currentOptionPanel);
		
	}
	
	
	private void addButton(JButton button, int x, int y) {
		button.setBounds(x, y, 130, 50);
		button.addActionListener(buttonActionListener);
		contentPanel.add(button);
	}


	public optionPanel getCurrentOptionPanel() {
		return currentOptionPanel;
	}


	public void setCurrentOptionPanel(optionPanel currentOptionPanel) {
		this.currentOptionPanel = currentOptionPanel;
	}
	
}
