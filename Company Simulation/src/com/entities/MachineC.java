package com.entities;

import java.awt.Image;

import com.gamelogic.ImageProvider.Imagefor;

public class MachineC extends Machine{

	public MachineC(Image image, int xPos, int yPos) {
		super(null, xPos, yPos);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_C));
		// TODO Auto-generated constructor stub
	}


}
