package com.entities;

import java.awt.Dimension;
import java.awt.Image;

import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;

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

	private ImageProvider images = new ImageProvider();
	
	// _______________________________________________________________________________________________________________________
	public Product(Image image, int xPos, int yPos, productType type) {
		super(image, xPos, yPos, 0);
		this.type = type;
	}

	// _______________________________________________________________________________________________________________________
	public void process() {
		switch (type) {
		case PRODUCT_A:
			type = productType.PRODUCT_A_PROCESSED;
			super.setImage(images.getImage(Imagefor.PRODUCT_A_PROCESSED));
			break;

		case PRODUCT_B:
			type = productType.PRODUCT_B_PROCESSED;
			super.setImage(images.getImage(Imagefor.PRODUCT_B_PROCESSED));
			break;
		
		case PRODUCT_C:
		 	type = productType.PRODUCT_C_CERTIFIED;
		 	super.setImage(images.getImage(Imagefor.PRODUCT_C_CERTIFIED));
		 	break;
			
		case PRODUCT_B_PROCESSED:
			type = productType.PRODUCT_C;
			super.setImage(images.getImage(Imagefor.PRODUCT_C));
			break;
		}
	}

	// _______________________________________________________________________________________________________________________
	public void setPosition(int xPos, int yPos, int orientation) {
		super.setxPos(xPos);
		super.setyPos(yPos);
		super.setOrientation(orientation);
	}
	
	public void setType(productType type) {
		this.type = type;
	}

	public productType getType() {
		return type;
	}
}
