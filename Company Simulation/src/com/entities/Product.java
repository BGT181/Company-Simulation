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
	
	public Product(Image image, int xPos, int yPos, productType type) {
		super(image, xPos, yPos, 0);
		this.type = type;
	}
	
	public void setType(productType type) {
		this.type = type;
		Imagefor image = null;
		
		switch (type) {
			case PRODUCT_A: 			image = Imagefor.PRODUCT_A;				break;
			case PRODUCT_A_PROCESSED:	image = Imagefor.PRODUCT_A_PROCESSED;	break;
			case PRODUCT_B:				image = Imagefor.PRODUCT_B;				break;
			case PRODUCT_B_PROCESSED:	image = Imagefor.PRODUCT_B_PROCESSED;	break;
			case PRODUCT_C:				image = Imagefor.PRODUCT_C;				break;
			case PRODUCT_C_CERTIFIED: 	image = Imagefor.PRODUCT_C_CERTIFIED;	break;
		}
		
		setImage(images.getImage(image));
	}
	
	public productType getType() {
		return type;
	}
}
