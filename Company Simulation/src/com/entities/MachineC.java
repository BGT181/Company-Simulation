package com.entities;

import java.awt.Image;

import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;

public class MachineC extends Machine{

	public MachineC(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_C));
		// TODO Auto-generated constructor stub
	}


}
