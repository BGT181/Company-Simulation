package com.gamelogic;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageProvider {

	private Image[] imageBuffer = new Image[15];
	
	public enum Imagefor {
		BUILDING,	//#0
		MACHINE_A, 	//#1
		MACHINE_B,	//#2
		MACHINE_C,	//#3
		STORAGE, 	//#4
		TRUCK,		//#5
		EMPLOYEE_A,	//#6
		EMPLOYEE_B,	//#7
		EMPLOYEE_C,	//#8
		PRODUCT_A, 	//#9
		PRODUCT_A_PROCESSED, //#10
		PRODUCT_B,  //#11
		PRODUCT_B_PROCESSED, //#12
		PRODUCT_C,	//#13
		PRODUCT_C_CERTIFIED //#14
	}
	
	public ImageProvider() {
		loadImages();
	}
	
	private void loadImages() {
		imageBuffer[0] = new ImageIcon("src/images/building.png").getImage();
		imageBuffer[5] = new ImageIcon("src/images/LKW.png").getImage();
		/*
		Image image0 = new ImageIcon("src/images/building.png").getImage();
		Image image1 = new ImageIcon("src/images/building.png").getImage();#
		*/
	}
	
	public Image getImage(Imagefor image) {
		return imageBuffer[image.ordinal()];
	}
	
}
