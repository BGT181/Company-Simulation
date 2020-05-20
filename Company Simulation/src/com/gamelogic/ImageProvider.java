package com.gamelogic;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageProvider {

	/**
	 * This is an Image-Provider for this application.
	 * It consists out of a an Array with every Image the program features.
	 * They are stored in a fitting Array and they can be accessed by the getImage-Method and the depending Enum.
	 */
	
	private Image[] imageBuffer = new Image[15];
	
	public enum Imagefor {
		BUILDING,			//#0
		MACHINE_A, 			//#1
		MACHINE_B,			//#2
		MACHINE_C,			//#3
		STORAGE, 			//#4
		TRUCK,				//#5
		EMPLOYEE_A,			//#6
		EMPLOYEE_B,			//#7
		EMPLOYEE_C,			//#8
		PRODUCT_A, 			//#9
		PRODUCT_A_PROCESSED,//#10
		PRODUCT_B,  		//#11
		PRODUCT_B_PROCESSED,//#12
		PRODUCT_C,			//#13
		PRODUCT_C_CERTIFIED //#14
	}
	
	public ImageProvider() {
		loadImages();
	}
	
	/**
	 * Some Images still need to be added when they're available.
	 */
	
	private void loadImages() {
		imageBuffer[0] = new ImageIcon("src/images/building.png").getImage();
		imageBuffer[5] = new ImageIcon("src/images/truck.png").getImage();
	}
	
	public Image getImage(Imagefor image) {
		return imageBuffer[image.ordinal()];
	}
	
}
