package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Maschine extends Entity{
	
	private final Image i_maschine1 = new Image(), i_maschine2 = new Image(), i_maschine3 = new Image();
	private final Dimension d_maschine1 = new Dimension(), d_maschine2 = new Dimension(), d_maschine3 = new Dimension();
	private final int[][] position_maschine = {{/*xPos, yPos*/},
											   {/*xPos, yPos*/}};
	
	private String typ;
	private int xPos, yPos, level = 1;
	private static int array_count_1 = 0, array_count_2 = 5, array_count_3 = 10;//Beispiele
	
	public Maschine(String typ) {
		this.typ = typ;
		
		switch(typ) {
		case "maschiene1":
			xPos = position_maschine[array_count_1][0];
			yPos = position_maschine[array_count_1][1];
			super.dimension = d_maschine1;
			super.image = i_maschine1;
			array_count_1++;
			break;
			
		case "maschiene2":
			xPos = position_maschine[array_count_2][0];
			yPos = position_maschine[array_count_2][1];
			super.dimension = d_maschine2;
			super.image = i_maschine2;
			array_count_2++;
			break;
			
		case "maschiene3":
			xPos = position_maschine[array_count_3][0];
			yPos = position_maschine[array_count_3][1];
			super.dimension = d_maschine3;
			super.image = i_maschine3;
			array_count_3++;
			break;
		}
	}

	public void levelup() {
		level++;
	}
}
