package com.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import com.entities.Product.productType;
import com.event.CEvent;
import com.event.CEvent.Event;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class Truck extends Entity{

	private boolean isArrived = true;
	private boolean isFinished = false;
	private ImageProvider ip = new ImageProvider();
	private int amount;
	private Imagefor img = null;
	private productType productType = null;
	private int i;
	private Company company;
	
	private int xStart = -250;
	private int xEnd = 80;
	
	public Truck(Image image, int xPos, int yPos, Company company) {
		super(image, xPos, yPos, 0);
		this.company = company;
	}

	public boolean orderProducts(productType type, int amount) {		
		this.amount = amount; 
		this.productType = type;
		
		if(type==productType.PRODUCT_A) {
			img = Imagefor.PRODUCT_A;
		}
		if(type==productType.PRODUCT_B) {
			img = Imagefor.PRODUCT_B;
		}
		if(type==productType.PRODUCT_A_PROCESSED) {
			img = Imagefor.PRODUCT_A_PROCESSED;
		}
		
		for (int i = 0; i < amount; i++) {
			company.getELC().cEventOccurred(new CEvent(Event.TRUCK_ENTRANCE_UNLOAD));
		}
		
		isArrived = false;
		return true;
	}
	
	public void moveToDestination() {
		if(!isArrived) {
			if(isFinished) {
				
				if(super.getxPos()==xStart) {
					isArrived = true;
					isFinished = false;
				} else {
					super.setxPos(super.getxPos()-2);
				}
				
			} else {
				if(!isFinished) {
					if(super.getxPos()==xEnd) {
						isArrived = true;
						
					} else {
						super.setxPos(super.getxPos()+2);
					}
				}
			}
		}
	}
	
	public void unloadTruck(Employee employee) {
		if(amount>0) {
			employee.setCarryProduct(new Product(ip.getImage(img),100,80,productType));
			employee.increaseEventStep();
			amount--;
			
			
			if(amount==0) {
				isArrived = false;
				isFinished = true;
				amount = 0;
				productType = null;
				img = null;
			}
		} else {
			if(amount==0) {
				isArrived = false;
				isFinished = true;
				amount = 0;
				productType = null;
				img = null;
			}
		}
	}
	
	
	public boolean soldProduct(int amount) {
		this.amount = amount;
		isArrived = false;
		for (int i = 0; i < amount; i++) {
			company.getELC().cEventOccurred(new CEvent(Event.TRUCK_EXIT_LOAD));
		}
		return true;
	}
	
	public void loadTruck(Employee employee) {
		if(amount>i) {
			employee.setCarryProduct(null);
			i++;
			company.getMarket().setOrder(-1);
			employee.increaseEventStep();
			if(amount == i) {
				isArrived = false;
				isFinished = true;
				i = 0;
				amount = 0;
				productType = null;
				img = null;
			}
		}
	}
	
	public boolean isArrived() {
		return isArrived;
	}

	public void setArrived(boolean isArrived) {
		this.isArrived = isArrived;
	}
	
	public boolean isFinish() {
		return isFinished;
	}
}


