package com.framemanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class ContentPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906000336360409527L;
	ImageProvider ip = new ImageProvider();
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		setSize(1200, 720);
        Graphics2D g2d = (Graphics2D) g;
        setLayout(null);
        //g2d.rotate(Math.toRadians(45));
        
        g2d.drawImage(ip.getImage(Imagefor.BUILDING), 0,0,null);
        g2d.drawImage(ip.getImage(Imagefor.TRUCK),80,75,null);
        
        FrameComponents fc = new FrameComponents(this);
        fc.addComponents();
        
	}
}
