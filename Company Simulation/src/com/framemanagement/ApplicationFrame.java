package com.framemanagement;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ApplicationFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4449312693295027693L;

	public ApplicationFrame() {
		super("Company Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 740);
		
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) Math.round((dm.getWidth()/2)-500), (int) Math.round((dm.getHeight()/2)-350));
		
		setContentPane(new ContentPanel());
		
		this.setVisible(true);
	}
	
}
