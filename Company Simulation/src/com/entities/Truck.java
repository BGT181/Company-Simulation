package com.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import com.entities.Product.productType;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

public class Truck extends Entity{

	private boolean isArrived = true;
	private boolean isFinished = false;
	private Product[] container;
	private ImageProvider ip = new ImageProvider();
	private int amount;
	
	private int xStart = -250;
	private int xEnd = 80;
	
	public Truck(Image image, int xPos, int yPos) {
		super(image, xPos, yPos, 0);
	}

	public void orderProducts(productType type, int amount) {
		container = new Product[amount];
		
		Imagefor img = null;
		if(type==productType.PRODUCT_A) {
			img = Imagefor.PRODUCT_A;
		}
		if(type==productType.PRODUCT_B) {
			img = Imagefor.PRODUCT_B;
		}
		
		for (int i = 0; i < container.length; i++) {
			container[i] = new Product(ip.getImage(img), 0, 0, type);
		}
		
		isArrived = false;
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
	
	
	
	/*
	 * 	orderProducts() //isArrived = false
	 *  ->
	 * 	moveToDesination() //direction depends
	 * 	->
	 * 	isArrived = true;
	 * 	->
	 * 	Call Events to clear the Truck;
	 * 	->
	 * 	exportProduct //!= null
	 * 	->
	 * 	container[i] = null; 
	 * 	->
	 * 	isArrived = false; 
	 * 	isFinished = true; 
	 * 	->
	 * 	moveToDesition //depends on isFinished
	 * 	-> 
	 *	 //Clear for next Order
	 * 	isFinished = false; //isArrived = true;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * importSoldProducts() // isArrived = false;
	 * -> 
	 * moveToDestination()
	 * -> 
	 * isArrived = true;
	 * ->
	 * loadTruck() // i++
	 * -> 
	 * i = orderAmount
	 * ->
	 * isFinished = true;
	 * isArrived = false;
	 * ->
	 * moveToDestination()
	 * ->
	 * isFinished = false //Cleared for next Task
	 * isArrived = true;
	 * 
	 */
	
	
	
	

	public boolean isArrived() {
		return isArrived;
	}

	public void setArrived(boolean isArrived) {
		this.isArrived = isArrived;
	}
}


