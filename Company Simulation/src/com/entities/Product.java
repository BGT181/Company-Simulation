package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Product extends Entity{

	private product type;
	
	public enum product {
		A,
		B,
		C
	}
	
	public Product(Image image, int xPos, int yPos, product type) {
		super(image, xPos, yPos, 0);
		this.type = type;
	}

}
