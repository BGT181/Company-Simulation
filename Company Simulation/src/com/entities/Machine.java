package com.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.entities.Product.productType;
import com.gamelogic.*;


public class Machine extends Entity {

	
	/*
	 * TaskPoints are the value that need to be reached to make a product.
	 * 
	 * taskPoints(forTask) = standardTaskPoints + randomTaskPoints
	 * time(for Task) = taskPoints - efficiency (Faktor per Tick)
	 * 
	 *  
	 *  
	 */
	
	
	private Employee[] dedicatedStaff;
	public int standardTaskPoints;
	public int randomTaskPoints;
	public int taskPoints;
	public boolean isWorking;
	public double efficiency;
	public ImageProvider imageProvider = new ImageProvider();
	
	
	public Machine(Image image, int xPos, int yPos) {
		super(image, xPos, yPos, 0);
	}
	
	public int calculateTaskPoints() {
		return 0;
	}
	
	public void drawImage(Graphics2D g2d) {
		g2d.drawImage(super.getImage(), super.getxPos(),super.getyPos(),null);
	}
	
	
	
	
	
	
}
