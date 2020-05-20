package com.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.framemanagement.FrameComponents;
import com.framemanagement.FrameComponents.optionPanel;

public class ButtonActionListener implements ActionListener {
	
	/**
	 * ActionListener-Child-Class for the buttons in the optionmenu
	 * First Constructor is for the navigate-buttons
	 * May a second Constructor will follow for other buttons
	 */
	
	JButton buttonDashboard;
	JButton buttonManagement;
	JButton buttonEmployee;
	private FrameComponents frameComponents;
	
	public ButtonActionListener(FrameComponents frameComponents, JButton buttonDashboard, JButton buttonManagement,JButton buttonEmployee) {
		super();
		this.buttonDashboard = buttonDashboard;
		this.buttonManagement = buttonManagement;
		this.buttonEmployee = buttonEmployee;
		this.frameComponents = frameComponents;
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==this.buttonDashboard) {
			frameComponents.setCurrentOptionPanel(optionPanel.DASHBOARD);
		}
		
		if(event.getSource()==this.buttonManagement) {
			frameComponents.setCurrentOptionPanel(optionPanel.MANAGEMENT);
		}
		
		if(event.getSource()==this.buttonEmployee) {
			frameComponents.setCurrentOptionPanel(optionPanel.EMPLOYEE);
		}
	}
}
