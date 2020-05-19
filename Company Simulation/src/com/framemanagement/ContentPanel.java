package com.framemanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ContentPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906000336360409527L;

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setSize(1200, 720);
        Graphics2D g2d = (Graphics2D) g;
 
        //g2d.rotate(Math.toRadians(45));
        
        Image image = new ImageIcon("src/images/building.png").getImage();
        Dimension d = new Dimension();
        d.width = image.getWidth(null);
        d.height = image.getHeight(null);
        this.setPreferredSize(d);
        g2d.drawImage(image, 0, 0, null);
        
        
        
        Image image2 = new ImageIcon("src/images/LKW.png").getImage();
        Dimension d2 = new Dimension();
        d.width = image2.getWidth(null);
        d.height = image2.getHeight(null);
        this.setPreferredSize(d2);
        g2d.drawImage(image2, 80, 75, null);
        
        
	}
}
