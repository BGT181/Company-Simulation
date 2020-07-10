package com.entities;

import java.awt.Image;

import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;

public class MachineB extends Machine{

	public MachineB(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_B));
	}

	

}
