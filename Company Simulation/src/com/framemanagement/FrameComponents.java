package com.framemanagement;

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
		addButton(buttonDashboard, 850, 0);
	}
	
	
	private void addButton(JButton button, int x, int y) {
		button.setBounds(x, y, 130, 50);
		contentPanel.add(button);
	}
}
