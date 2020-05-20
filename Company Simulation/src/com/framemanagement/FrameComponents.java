package com.framemanagement;

import javax.swing.JButton;

public class FrameComponents {

	private ContentPanel contentPanel;
	
	public FrameComponents(ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
	}
	
	
	public void addComponents() {
		JButton b1 = new JButton("Dashboard");
		b1.setBounds(100, 100, 100, 50);
		contentPanel.add(b1);
	}
}
