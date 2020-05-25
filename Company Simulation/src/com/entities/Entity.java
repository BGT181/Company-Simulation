package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Entity {

	private Image image;
	private int xPos,yPos;
	private int orientation;
	private boolean isAvailable;
	
	public Entity(Image image, int xPos, int yPos, int orientation) {
		this.image = image;
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.setOrientation(orientation);
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public Image getImage() {
		return image;
	}
	
}
