package com.gamelogic;

import java.util.Vector;

public class MovementTask {

	private Position start;
	private Position destination;
	
	//position [i][0] =	xPos
	//position [i][1] =	yPos
	//position [i][2] =	dirX
	//position [i][3] =	dirY
	private int[][] positions = new int[21][4];
	
	public enum Position  {
		TRUCK_ENTRANCE,		//#0
		STORAGE,			//#1
		TRUCK_EXIT,			//#2
		CHECKPOINT_A,		//#3
		CHECKPOINT_B,		//#4
		CHECKPOINT_C,		//#5
		MACHINE_A,			//#6
		MACHINE_B,			//#7
		MACHINE_C,			//#8
		
		MACHINE_A_SLOT1,	//#9
		MACHINE_A_SLOT2,	//#10
		MACHINE_A_SLOT3,	//#11
		MACHINE_A_SLOT4,	//#12
		MACHINE_B_SLOT1,	//#13
		MACHINE_B_SLOT2,	//#14
		MACHINE_B_SLOT3,	//#15
		MACHINE_B_SLOT4,	//#16
		MACHINE_B_SLOT5,	//#17
		MACHINE_B_SLOT6,	//#18
		MACHINE_C_SLOT1,	//#19
		MACHINE_C_SLOT2		//#20
	}
	
	public MovementTask() {
		setupPosition(Position.TRUCK_ENTRANCE, 230, 120, -1, 0);
		setupPosition(Position.STORAGE, 250, 350, -1, 0);
		setupPosition(Position.TRUCK_EXIT, 230, 600, -1, 0);
		setupPosition(Position.CHECKPOINT_A, 400, 120, 0, 0);
		setupPosition(Position.CHECKPOINT_B, 400, 350, 0, 0);
		setupPosition(Position.CHECKPOINT_C, 400, 600, 0, 0);
		setupPosition(Position.MACHINE_A, 650, 120, -1, 0);
		setupPosition(Position.MACHINE_B, 650, 350, -1, 0);
		setupPosition(Position.MACHINE_C, 650, 600, -1, 0);
		
		
		setupPosition(Position.MACHINE_A_SLOT1, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_A_SLOT2, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_A_SLOT3, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_A_SLOT4, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_B_SLOT1, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_B_SLOT2, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_B_SLOT3, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_B_SLOT4, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_B_SLOT5, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_B_SLOT6, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_C_SLOT1, 0, 0, 0, 0);
		setupPosition(Position.MACHINE_C_SLOT2, 0, 0, 0, 0);
	}
	
	public void setMovementTask(Position start, Position destination) {
		this.setStart(start);
		this.setDestination(destination);
	}
	
	public void clearMovementTask() {
		this.setStart(null);
		this.setDestination(null);
	}
	
	private void setupPosition(Position position, int xPos, int yPos, int dirX, int dirY) {
		positions[position.ordinal()][0]=xPos;
		positions[position.ordinal()][1]=yPos;
		positions[position.ordinal()][2]=dirX;
		positions[position.ordinal()][3]=dirY;
	}
	

	public Position getStart() {
		return start;
	}
	

	public void setStart(Position start) {
		this.start = start;
	}

	public Position getDestination() {
		return destination;
	}

	public void setDestination(Position destination) {
		this.destination = destination;
	}
	
	public int getXofPosition(Position position) {
		return positions[position.ordinal()][0];
	}
	
	public int getYofPosition(Position position) {
		return positions[position.ordinal()][1];
	}
	
}

