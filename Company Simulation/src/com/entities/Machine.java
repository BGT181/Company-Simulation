package com.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.Timer;

import com.entities.Product.productType;
import com.event.CEvent;
import com.gamelogic.*;


public class Machine extends Entity implements ActionListener{

	
	/*
	 * TaskPoints are the value that need to be reached to make a product.
	 * 
	 * taskPoints(forTask) = standardTaskPoints + randomTaskPoints
	 * time(for Task) = taskPoints - efficiency (Faktor per Tick)
	 * 
	 *  
	 *  
	 */
	
	protected Timer timer = new Timer(1000,this);
	protected Employee[] dedicatedStaff;
	protected double standardTaskPoints;
	protected double taskPoints;
	protected double varTaskPoints;
	protected boolean isRequested;
	protected boolean isWorking;
	protected double efficiency;
	protected ImageProvider imageProvider = new ImageProvider();
	protected Company company;
	
	public Machine(Image image, int xPos, int yPos, Company company) {
		super(image, xPos, yPos, 0);
		timer.start();
	}
	
	
	public void actionPerformed(ActionEvent ev){
		if(ev.getSource()==timer){
			process();
		}
	}
	
	public void process() {
		
	}
	
	public void AddDedicatedStaff(Employee employee) {
		for (int i = 0; i < dedicatedStaff.length; i++) {
			if(dedicatedStaff[i]==null) {
				dedicatedStaff[i] = employee;
			}
		}
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
	
	protected void calculateTaskPoints(int x) {
		taskPoints = (standardTaskPoints + getRandomInt())*x;
	}
	
	protected int getRandomInt() {
		Random ran = new Random();
		return ran.nextInt(20);
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
