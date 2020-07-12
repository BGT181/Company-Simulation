package com.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;


import com.entities.Product.productType;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementTask.Position;

public class Storage extends Entity {

	ImageProvider imageProvider = new ImageProvider();
	
	private Product[] storedProducts = new Product[20];
	private int numberOfStoredProducts = 0;
	private boolean storageAvailable = true;
	private int offset = 85;

	public Storage(int xPos, int yPos, Dimension orientation) {
		super(null, xPos, yPos, 0);
		
	}

	public void drawImage(Graphics2D g2d) {
		g2d.drawImage(imageProvider.getImage(Imagefor.STORAGE), super.getxPos(), super.getyPos(), null);
		g2d.drawImage(imageProvider.getImage(Imagefor.STORAGE), super.getxPos(), (super.getyPos()+offset), null);
		g2d.drawImage(imageProvider.getImage(Imagefor.STORAGE), super.getxPos(), (super.getyPos()+2*offset), null);
		g2d.drawImage(imageProvider.getImage(Imagefor.STORAGE), super.getxPos(), (super.getyPos()+3*offset), null);
	}

	public void storeProduct(Product product, Employee employee) {
		if(isStorageAvailable()) {
			updatePosition(product, findSpace());
			storedProducts[findSpace()] = product;
			numberOfStoredProducts++;
			if(employee!=null) {
				employee.setCarryProduct(null);
				employee.increaseEventStep();
			}	
		}
	}
	
	public int checkForProductType(productType productType) {
		for (int i = 0; i < storedProducts.length; i++) {
			if(storedProducts[i]!=null) {
				if(storedProducts[i].getType()==productType) {
					return i;	
				}
			}
		}
		return -1;
	}
	
	public boolean isStorageAvailable() {
		if(numberOfStoredProducts<20) {
			return true;
		} else {
			return false;
		}
	}
	
	public int findSpace() {
		for (int i = 0; i < storedProducts.length; i++) {
			if(storedProducts[i] == null) {
				return i;
			}
		}
		return 0;
	}
	
	public Product[] getProducts() {
		return storedProducts;
	}
	
	public void updatePosition(Product product, int i) {
		if((i>=0)&&(i<=4)) {
			product.setyPos((super.getyPos()+5));
		} else { 
			if((i>=5)&&(i<=9)) {
				product.setyPos(super.getyPos()+offset+5);
			} else {
				if((i>=10)&&(i<=14)) {
					product.setyPos(super.getyPos()+(2*offset)+5);
				} else {
					if((i>=15)&&(i<=19)) {
						product.setyPos(super.getyPos()+(3*offset)+5);
					}
				}
				
			}
		}
		
		if((i == 0)||(i==5) || (i==10) || (i==15)) {
			product.setxPos((super.getxPos()+5));
		} else {
			if((i == 1)||(i==6) || (i==11) || (i==16)) {
				product.setxPos(super.getxPos()+42);
			} else {
				if((i == 2)||(i==7) || (i==12) || (i==17)) {
					product.setxPos(super.getxPos()+(2*37)+5);
					
				} else {
					if((i == 3)||(i==8) || (i==13) || (i==18)) {
						product.setxPos(super.getxPos()+(3*37)+5);
						
					} else {
						if((i == 4)||(i==9) || (i==14) || (i==19)) {
							
							product.setxPos(super.getxPos()+(4*37)+5);
						}
					}
				}
			}
		}
	}
	
	public int getAmount() {
		return numberOfStoredProducts;
	}
	
	public Product pickUpItem(productType productType, Employee employee) {
		int i = checkForProductType(productType);
			if(employee.reachedPosition(Position.STORAGE)) {
				Product product = storedProducts[i];
		
					if(i>=0) {
						numberOfStoredProducts--;
						storedProducts[i] = null;
						employee.increaseEventStep();
						employee.setCarryProduct(product);
					}
			}
		return null;
	}
	
	
	
	}
