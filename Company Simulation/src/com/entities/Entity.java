package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Entity {

	private Image image;
	private int xPos,yPos;
	private Dimension orientation;
	private boolean isMoveable;
	
	public Entity(Image image, int xPos, int yPos, Dimension orientation) {
		this.image = image;
		this.xPos = xPos;
		this.yPos = yPos;
		this.orientation = orientation;
	}
	
}
