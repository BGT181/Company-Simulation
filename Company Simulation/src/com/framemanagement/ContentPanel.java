package com.framemanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class ContentPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906000336360409527L;
	ImageProvider ip = new ImageProvider();
	Timer timer = new Timer(5000, this);
	public enum optionPanel { DASHBOARD, MANAGEMENT, EMPLOYEE }
	private optionPanel currentOptionPanel = optionPanel.DASHBOARD;
	
	public ContentPanel() {
		super();
		timer.start();
	}
	
	
	public void actionPerformed(ActionEvent ev){
	    if(ev.getSource()==timer){
	    	System.out.println(ev.getSource());
	      repaint();
	    }
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		setSize(1200, 720);
        Graphics2D g2d = (Graphics2D) g;
        setLayout(null);
        //g2d.rotate(Math.toRadians(45));
        System.out.println(currentOptionPanel);
        
        g2d.drawImage(ip.getImage(Imagefor.BUILDING), 0,0,null);
        g2d.drawImage(ip.getImage(Imagefor.TRUCK), 80,75,null);
        
        FrameComponents fc = new FrameComponents(this);
        fc.addComponents();
        System.out.println("Refreshed");
        
	}


	public optionPanel getCurrentOptionPanel() {
		return currentOptionPanel;
	}


	public void setCurrentOptionPanel(optionPanel currentOptionPanel) {
		this.currentOptionPanel = currentOptionPanel;
	}
	
}
