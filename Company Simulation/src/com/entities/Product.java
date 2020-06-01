package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Product extends Entity {

	private productType type;

	public enum productType {
		PRODUCT_A,
		PRODUCT_A_PROCESSED,
		PRODUCT_B, 
		PRODUCT_B_PROCESSED,
		PRODUCT_C, 
		PRODUCT_C_CERTIFIED
	}

	private boolean recyclingStatus = false;

	// _______________________________________________________________________________________________________________________
	public Product(Image image, int xPos, int yPos, productType type) {
		super(image, xPos, yPos, 0);
		this.type = type;
	}

	// _______________________________________________________________________________________________________________________
	public void deleteProduct() {
		this.type = null;
		super.setImage(null);
		super.setxPos(0);
		super.setyPos(0);
		recyclingStatus = true;
	}

	public void recycle(Image image, int xPos, int yPos, productType type) {
		super.setImage(image);
		super.setxPos(xPos);
		super.setyPos(yPos);
		this.type = type;
		recyclingStatus = false;
	}

	public void process() {
		switch (type) {
		case PRODUCT_A:
			type = productType.PRODUCT_A_PROCESSED;
//			super.setImage();
			break;

		case PRODUCT_B:
			type = productType.PRODUCT_B_PROCESSED;
			break;
		
		case PRODUCT_C:
		 	type = productType.PRODUCT_C_CERTIFIED;
			break;
			
		case PRODUCT_A_PROCESSED:
			type = productType.PRODUCT_C;
			break;
			
		case PRODUCT_B_PROCESSED:
			deleteProduct();
			break;
		}
	}

	// _______________________________________________________________________________________________________________________
	public void setType(productType type) {
		this.type = type;
	}

	public productType getType() {
		return type;
	}
}
