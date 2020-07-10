package com.entities;

import java.awt.Image;

import com.gamelogic.Company;
import com.gamelogic.ImageProvider.Imagefor;

public class MachineA extends Machine{

	public MachineA(Image image, int xPos, int yPos, Company company) {
		super(null, xPos, yPos, company);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_A));
	}


}
