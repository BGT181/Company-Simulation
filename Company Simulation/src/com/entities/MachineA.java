package com.entities;

import java.awt.Image;

import com.gamelogic.ImageProvider.Imagefor;

public class MachineA extends Machine{

	public MachineA(Image image, int xPos, int yPos) {
		super(null, xPos, yPos);
		super.setImage(super.imageProvider.getImage(Imagefor.MACHINE_A));
	}


}
