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
			updatePosition(product, findSpace());
			storedProducts[findSpace()] = product;
			numberOfStoredProducts++;
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
	
	public void updatePosition(Product product, int i) {
		if((i>=0)&&(i<=4)) {
			product.setxPos(super.getxPos());
		} else { 
			if((i>=5)&&(i<=9)) {
				product.setxPos(super.getxPos()+offset);
			} else {
				if((i>=10)&&(i<=14)) {
					product.setxPos(super.getxPos()+(2*offset));
				} else {
					if((i>=15)&&(i<=19)) {
						product.setxPos(super.getxPos()+(3*offset));
					}
				}
				
			}
		}
		
		if((i == 0)||(i==5) || (i==10) || (i==15)) {
			product.setyPos(super.getyPos());
		} else {
			if((i == 1)||(i==6) || (i==11) || (i==16)) {
				product.setyPos(super.getyPos()+36);
			} else {
				if((i == 2)||(i==7) || (i==12) || (i==17)) {
					product.setyPos(super.getyPos()+(2*36));
				} else {
					if((i == 3)||(i==8) || (i==13) || (i==18)) {
						product.setyPos(super.getyPos()+(3*36));
					} else {
						if((i == 4)||(i==9) || (i==14) || (i==19)) {
							product.setyPos(super.getyPos()+(4*36));
						}
					}
				}
			}
		}
	}
	
	
}
