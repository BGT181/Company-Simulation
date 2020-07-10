package com.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.entities.Product.productType;
import com.event.CEvent;
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
	
	
	protected Employee[] dedicatedStaff;
	protected int standardTaskPoints;
	protected int taskPoints;
	protected int varTaskPoints;
	protected boolean isWorking;
	protected boolean isWaiting;
	protected double efficiency;
	protected ImageProvider imageProvider = new ImageProvider();
	protected Company company;
	
	public Machine(Image image, int xPos, int yPos, Company company) {
		super(image, xPos, yPos, 0);
	}
	
	public void process() {
		
	}
	
	public void AddDedicatedStaff(Employee employee) {
		
	}
	
	public void removeDedicatedStaff(Employee employee) {
		
	}
	
	public void drawImage(Graphics2D g2d) {
		g2d.drawImage(super.getImage(), super.getxPos(),super.getyPos(),null);
	}
	
	public void loadMachine(Employee employee) {
		
	}
	
	public void unloadMachine(Employee empolyee) {
	
	}
	
	protected void throwEvent(CEvent event) {
		company.getELC().cEventOccurred(event);
	}
	
	protected void calculateTaskPoints() {
		taskPoints = standardTaskPoints + getRandomInt();
	}
	
	protected int getRandomInt() {
		Random ran = new Random();
		return ran.nextInt(20)*10;
	}
	
	protected void calculateEfficiency() {
		for (int i = 0; i < dedicatedStaff.length; i++) {
			if(dedicatedStaff[i]!=null) {
				efficiency += dedicatedStaff[i].getEfficiencyLvl();
			}
		}
		if(efficiency<=0) {
			efficiency = 0.1;
		}
	}
	
	
	protected boolean isProzessFinished() {
		if(varTaskPoints>=taskPoints) {
			return true;
		} else {
			return false;
		}
	}
	
}
