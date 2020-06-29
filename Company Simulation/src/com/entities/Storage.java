package com.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;


import com.entities.Product.productType;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

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

	public void storeProduct(Product product) {
		if(isStorageAvailable()) {
			storedProducts[findSpace()] = product;
			product.setxPos(0);
			product.setyPos(0);
		}
	}
	
	public int checkForProductType(productType productType) {
		for (int i = 0; i < storedProducts.length; i++) {
			if(storedProducts[i].getType()==productType) {
				return i;	
			}
		}
		return -1;
	}
	
	public boolean isStorageAvailable() {
		if(numberOfStoredProducts<=20) {
			return false;
		} else {
			return true;
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
	
	
	
	
}
