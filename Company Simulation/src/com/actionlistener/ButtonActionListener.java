package com.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.framemanagement.ContentPanel;
import com.framemanagement.ContentPanel.optionPanel;
import com.framemanagement.FrameComponents;

public class ButtonActionListener implements ActionListener {
	
	/**
	 * ActionListener-Child-Class for the buttons in the optionmenu
	 * First Constructor is for the navigate-buttons
	 * May a second Constructor will follow for other buttons
	 */
	
	JButton buttonDashboard;
	JButton buttonManagement;
	JButton buttonEmployee;
	private ContentPanel contentPanel;
	
	public ButtonActionListener(ContentPanel contentPanel, JButton buttonDashboard, JButton buttonManagement,JButton buttonEmployee) {
		super();
		this.buttonDashboard = buttonDashboard;
		this.buttonManagement = buttonManagement;
		this.buttonEmployee = buttonEmployee;
		this.contentPanel = contentPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==this.buttonDashboard) {
			contentPanel.setCurrentOptionPanel(optionPanel.DASHBOARD);
		}
		
		if(event.getSource()==this.buttonManagement) {
			contentPanel.setCurrentOptionPanel(optionPanel.MANAGEMENT);;
		}
		
		if(event.getSource()==this.buttonEmployee) {
			contentPanel.setCurrentOptionPanel(optionPanel.EMPLOYEE);;
		}
	}
}
