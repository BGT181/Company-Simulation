package com.gamelogic;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageProvider {

	/**
	 * This is an Image-Provider for this application.
	 * It consists out of a an Array with every Image the program features.
	 * They are stored in a fitting Array and they can be accessed by the getImage-Method and the depending Enum.
	 */
	
	private Image[] imageBuffer = new Image[24];
	
	public enum Imagefor {
		BUILDING,			//#0 -
		MACHINE_A, 			//#1 -
		MACHINE_B,			//#2 -
		MACHINE_C,			//#3 -
		STORAGE, 			//#4 -
		TRUCK,				//#5 -
		EMPLOYEE_A_UP,		//#6 -
		EMPLOYEE_A_RIGHT,	//#7 -
		EMPLOYEE_A_DOWN,	//#8 -
		EMPLOYEE_A_LEFT,	//#9 -
		EMPLOYEE_B_UP,		//#10 -
		EMPLOYEE_B_RIGHT,	//#11 -
		EMPLOYEE_B_DOWN,	//#12 -
		EMPLOYEE_B_LEFT,	//#13 -
		EMPLOYEE_C_UP,		//#14 -
		EMPLOYEE_C_RIGHT,	//#15 -
		EMPLOYEE_C_DOWN,	//#16 -
		EMPLOYEE_C_LEFT,	//#17 -
		PRODUCT_A, 			//#18 -
		PRODUCT_A_PROCESSED,//#19 -
		PRODUCT_B,  		//#20 -
		PRODUCT_B_PROCESSED,//#21 -
		PRODUCT_C,			//#22 -
		PRODUCT_C_CERTIFIED //#23 -
	}
	
	public ImageProvider() {
		loadImages();
	}
	
	private void loadImages() {
		imageBuffer[0] = new ImageIcon("src/images/building.png").getImage();
		imageBuffer[1] = new ImageIcon("src/images/machine_a.png").getImage();
		imageBuffer[2] = new ImageIcon("src/images/machine_b.png").getImage();
		imageBuffer[3] = new ImageIcon("src/images/machine_c.png").getImage();
		imageBuffer[4] = new ImageIcon("src/images/storage.png").getImage();
		imageBuffer[5] = new ImageIcon("src/images/truck.png").getImage();
		imageBuffer[6] = new ImageIcon("src/images/employee_a_up.png").getImage();
		imageBuffer[7] = new ImageIcon("src/images/employee_a_right.png").getImage();
		imageBuffer[8] = new ImageIcon("src/images/employee_a_down.png").getImage();
		imageBuffer[9] = new ImageIcon("src/images/employee_a_left.png").getImage();
		imageBuffer[10] = new ImageIcon("src/images/employee_b_up.png").getImage();
		imageBuffer[11] = new ImageIcon("src/images/employee_b_right.png").getImage();
		imageBuffer[12] = new ImageIcon("src/images/employee_b_down.png").getImage();
		imageBuffer[13] = new ImageIcon("src/images/employee_b_left.png").getImage();
		imageBuffer[14] = new ImageIcon("src/images/employee_c_up.png").getImage();
		imageBuffer[15] = new ImageIcon("src/images/employee_c_right.png").getImage();
		imageBuffer[16] = new ImageIcon("src/images/employee_c_down.png").getImage();
		imageBuffer[17] = new ImageIcon("src/images/employee_c_left.png").getImage();
		imageBuffer[18] = new ImageIcon("src/images/product_a.png").getImage();
		imageBuffer[19] = new ImageIcon("src/images/product_a_processed.png").getImage();
		imageBuffer[20] = new ImageIcon("src/images/product_b.png").getImage();
		imageBuffer[21] = new ImageIcon("src/images/product_b_processed.png").getImage();
		imageBuffer[22] = new ImageIcon("src/images/product_c.png").getImage();
		imageBuffer[23] = new ImageIcon("src/images/product_c_certified.png").getImage();
	}
	
	public Image getImage(Imagefor image) {
		return imageBuffer[image.ordinal()];
	}
	
}
