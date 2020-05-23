package com.framemanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.actionlistener.ButtonActionListener;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class ContentPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906000336360409527L;
	ImageProvider ip = new ImageProvider();
	Timer timer = new Timer(5000, this);
	
	//Logic for the Menu. An Enum to provide the values for the specific Design
	public enum optionPanel { DASHBOARD, MANAGEMENT, EMPLOYEE }
	private optionPanel currentOptionPanel = optionPanel.DASHBOARD;
	
	//Control-Button Logic - Init Buttons and creating the ActionListener
	JButton buttonDashboard = new JButton("Dashboard");
	JButton buttonManagement = new JButton("Management"); 
	JButton buttonEmployees = new JButton("Employees");
	ButtonActionListener buttonActionListener = new ButtonActionListener(this, buttonDashboard, buttonManagement, buttonEmployees);
	
	
	public ContentPanel() {
		super();
		timer.start();
		setLayout(null);
		setSize(1200,720);
		
		addButton(buttonDashboard, 800, 0);
		addButton(buttonManagement, 931, 0);
		addButton(buttonEmployees, 1062, 0);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //g2d.rotate(Math.toRadians(45));
        
    	System.out.println(currentOptionPanel);
    		
        g2d.drawImage(ip.getImage(Imagefor.BUILDING), 0,0,null);
        g2d.drawImage(ip.getImage(Imagefor.TRUCK), 80,75,null);
       
	}
	
	private void addButton(JButton button, int x, int y) {
		button.setBounds(x, y, 130, 50);
		button.addActionListener(buttonActionListener);
		this.add(button);
	}

	public optionPanel getCurrentOptionPanel() {
		return currentOptionPanel;
	}

	public void setCurrentOptionPanel(optionPanel currentOptionPanel) {
		this.currentOptionPanel = currentOptionPanel;
	}
	
	public void actionPerformed(ActionEvent ev){
	    if(ev.getSource()==timer){
	    	System.out.println(ev.getSource());
	      repaint();
	    }
	}
	
}
