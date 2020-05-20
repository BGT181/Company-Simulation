package com.framemanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonActionListener implements ActionListener {
	
	JButton jb;
	
	public ButtonActionListener(JButton jb) {
		super();
		this.jb = jb;
	}
	
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getSource().getClass());
		if(event.getSource()==this.jb) {
			System.out.println("Dasbutton pressed");
		}
	}
}
