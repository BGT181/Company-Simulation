package com.gamelogic;

import java.util.Vector;

public class MovementTask {

	public enum Move  {
		TRUCK_ENTRANCE_TO_STORAGE,	//#0
		TRUCK_ENTRANCE_TO_MACHINE_A,//#1
		STORAGE_TO_MACHINE_A,		//#2
		MACHINE_A_TO_STORAGE,		//#3
		STORAGE_TO_MACHINE_B,		//#4
		MACHINE_B_TO_STORAGE,		//#5
		STORAGE_TO_MACHINE_C,		//#6
		MACHINE_C_TO_STORAGE,		//#7
		STORAGE_TO_TRUCK_EXIT,		//#8
		MACHINE_C_TO_TRUCK_EXIT,	//#9
		MACHINE_A_TO_MACHINE_B,		//#10
		MACHINE_B_TO_MACHINE_C		//#11
	}
	
	Vector TRUCK_ENTRANCE = new Vector(2);
	Vector CHECKPOINT_A = new Vector(2);
	Vector MACHINE_A = new Vector(2);
	Vector STORAGE = new Vector(2);
	Vector CHECKPOINT_B = new Vector(2);
	Vector MACHINE_B = new Vector(2);
	Vector TRUCK_EXIT = new Vector(2);
	Vector CHECKPOINT_C = new Vector(2);
	Vector MACHINE_C = new Vector(2);
	Vector STOP = new Vector(1);
	
	private Move movementTask;
	private Vector[][] taskOrder = new Vector[12][5];
	private int currentIndex;
	
	public MovementTask(Move move) {
		this.setMovementTask(move);
		currentIndex = 0;
		loadCoordinates();
	}
	
	public Vector getVector(int index) { //Returns the vector of the index. The current movementTask is important.
			return taskOrder[movementTask.ordinal()][index];
	}
	
	public Move getMovementTask() {	//Getter for the movementTask-variable.
		return movementTask;
	}

	public int getCurrentIndex() { //Getter for the current Index.
		return currentIndex;
	}
	
	public void increaseCurrentIndex() {	//Increases the currentIndex by one.
		this.currentIndex++;
	}
	
	public void setCurrentIndexTo(int index) {	//Sets the currentIndex to the given value.
		this.currentIndex = index;
	}
	
	public void resetCurrentIndex() { 	//Sets the value of currentIndex to 0.
		this.currentIndex=0;
	}
	
	public void setMovementTask(Move movementTask) {	//Setter for the movementTask-variable.
		this.movementTask = movementTask;
		
	}
	
	private void loadCoordinates() {		//Loads Values into the array taskOrder.
		TRUCK_ENTRANCE.add(0, 250);TRUCK_ENTRANCE.add(1, 120);
		CHECKPOINT_A.add(0, 450);CHECKPOINT_A.add(1, 120);
		MACHINE_A.add(0, 625);MACHINE_A.add(1, 120);
		STORAGE.add(0, 300);STORAGE.add(1, 375);
		CHECKPOINT_B.add(0, 450);CHECKPOINT_B.add(1, 375);
		MACHINE_B.add(0, 600);MACHINE_B.add(1, 375);
		TRUCK_EXIT.add(0, 250);TRUCK_EXIT.add(1, 575);
		CHECKPOINT_C.add(0, 450);CHECKPOINT_C.add(1, 575);
		MACHINE_B.add(0, 625);MACHINE_B.add(1, 575);
		STOP.add(0, 0);
		
		taskOrder[Move.TRUCK_ENTRANCE_TO_STORAGE.ordinal()][0] = TRUCK_ENTRANCE; 	//#0
		taskOrder[Move.TRUCK_ENTRANCE_TO_STORAGE.ordinal()][1] = CHECKPOINT_A;		//|
		taskOrder[Move.TRUCK_ENTRANCE_TO_STORAGE.ordinal()][2] = CHECKPOINT_B;		//|
		taskOrder[Move.TRUCK_ENTRANCE_TO_STORAGE.ordinal()][3] = STORAGE;			//|
		taskOrder[Move.TRUCK_ENTRANCE_TO_STORAGE.ordinal()][4] = STOP;				//|
		
		taskOrder[Move.TRUCK_ENTRANCE_TO_MACHINE_A.ordinal()][0] = TRUCK_ENTRANCE; 	//#1
		taskOrder[Move.TRUCK_ENTRANCE_TO_MACHINE_A.ordinal()][1] = CHECKPOINT_A;	//|
		taskOrder[Move.TRUCK_ENTRANCE_TO_MACHINE_A.ordinal()][2] = MACHINE_A;		//|
		taskOrder[Move.TRUCK_ENTRANCE_TO_MACHINE_A.ordinal()][3] = STOP;			//|
		
		taskOrder[Move.STORAGE_TO_MACHINE_A.ordinal()][0] = STORAGE;				//#2
		taskOrder[Move.STORAGE_TO_MACHINE_A.ordinal()][1] = CHECKPOINT_B;			//|
		taskOrder[Move.STORAGE_TO_MACHINE_A.ordinal()][2] = CHECKPOINT_A;			//|
		taskOrder[Move.STORAGE_TO_MACHINE_A.ordinal()][3] =	MACHINE_A;				//|
		taskOrder[Move.STORAGE_TO_MACHINE_A.ordinal()][4] =	STOP;					//|
		
		taskOrder[Move.MACHINE_A_TO_STORAGE.ordinal()][0] = MACHINE_A;				//#3
		taskOrder[Move.MACHINE_A_TO_STORAGE.ordinal()][1] = CHECKPOINT_A;			//|
		taskOrder[Move.MACHINE_A_TO_STORAGE.ordinal()][2] = CHECKPOINT_B;			//|
		taskOrder[Move.MACHINE_A_TO_STORAGE.ordinal()][3] =	STORAGE;				//|
		taskOrder[Move.MACHINE_A_TO_STORAGE.ordinal()][4] =	STOP;					//|
		
		taskOrder[Move.STORAGE_TO_MACHINE_B.ordinal()][0] = STORAGE;				//#4
		taskOrder[Move.STORAGE_TO_MACHINE_B.ordinal()][1] = CHECKPOINT_B;			//|
		taskOrder[Move.STORAGE_TO_MACHINE_B.ordinal()][2] = MACHINE_B;				//|
		taskOrder[Move.STORAGE_TO_MACHINE_B.ordinal()][3] = STOP;					//|
		
		taskOrder[Move.MACHINE_B_TO_STORAGE.ordinal()][0] = MACHINE_B;				//#5
		taskOrder[Move.MACHINE_B_TO_STORAGE.ordinal()][1] = CHECKPOINT_B;			//|
		taskOrder[Move.MACHINE_B_TO_STORAGE.ordinal()][2] = STORAGE;				//|
		taskOrder[Move.MACHINE_B_TO_STORAGE.ordinal()][3] = STOP;					//|
		
		taskOrder[Move.STORAGE_TO_MACHINE_C.ordinal()][0] = STORAGE;				//#6
		taskOrder[Move.STORAGE_TO_MACHINE_C.ordinal()][1] = CHECKPOINT_B;			//|
		taskOrder[Move.STORAGE_TO_MACHINE_C.ordinal()][2] = CHECKPOINT_C;			//|
		taskOrder[Move.STORAGE_TO_MACHINE_C.ordinal()][3] =	MACHINE_C;				//|
		taskOrder[Move.STORAGE_TO_MACHINE_C.ordinal()][4] =	STOP;					//|
		
		taskOrder[Move.MACHINE_C_TO_STORAGE.ordinal()][0] = MACHINE_C;				//#7
		taskOrder[Move.MACHINE_C_TO_STORAGE.ordinal()][1] = CHECKPOINT_C;			//|
		taskOrder[Move.MACHINE_C_TO_STORAGE.ordinal()][2] = CHECKPOINT_B;			//|
		taskOrder[Move.MACHINE_C_TO_STORAGE.ordinal()][3] =	STORAGE;				//|
		taskOrder[Move.MACHINE_C_TO_STORAGE.ordinal()][4] =	STOP;					//|
		
		taskOrder[Move.STORAGE_TO_TRUCK_EXIT.ordinal()][0] = STORAGE;				//#8
		taskOrder[Move.STORAGE_TO_TRUCK_EXIT.ordinal()][1] = CHECKPOINT_B;			//|
		taskOrder[Move.STORAGE_TO_TRUCK_EXIT.ordinal()][2] = CHECKPOINT_C;			//|
		taskOrder[Move.STORAGE_TO_TRUCK_EXIT.ordinal()][3] = TRUCK_EXIT;			//|
		taskOrder[Move.STORAGE_TO_TRUCK_EXIT.ordinal()][4] = STOP;					//|
		
		taskOrder[Move.MACHINE_C_TO_TRUCK_EXIT.ordinal()][0] = MACHINE_C;			//#9
		taskOrder[Move.MACHINE_C_TO_TRUCK_EXIT.ordinal()][1] = CHECKPOINT_C;		//|
		taskOrder[Move.MACHINE_C_TO_TRUCK_EXIT.ordinal()][2] = TRUCK_EXIT;			//|
		taskOrder[Move.MACHINE_C_TO_TRUCK_EXIT.ordinal()][3] = STOP;				//|
		
		taskOrder[Move.MACHINE_A_TO_MACHINE_B.ordinal()][0] = MACHINE_A;			//#10
		taskOrder[Move.MACHINE_A_TO_MACHINE_B.ordinal()][1] = CHECKPOINT_A;			//|
		taskOrder[Move.MACHINE_A_TO_MACHINE_B.ordinal()][2] = CHECKPOINT_B;			//|
		taskOrder[Move.MACHINE_A_TO_MACHINE_B.ordinal()][3] = MACHINE_B;			//|
		taskOrder[Move.MACHINE_A_TO_MACHINE_B.ordinal()][4] = STOP;					//|
		
		taskOrder[Move.MACHINE_B_TO_MACHINE_C.ordinal()][0] = MACHINE_B;			//#11
		taskOrder[Move.MACHINE_B_TO_MACHINE_C.ordinal()][1] = CHECKPOINT_B;			//|
		taskOrder[Move.MACHINE_B_TO_MACHINE_C.ordinal()][2] = CHECKPOINT_C;			//|
		taskOrder[Move.MACHINE_B_TO_MACHINE_C.ordinal()][3] = MACHINE_C;			//|
		taskOrder[Move.MACHINE_B_TO_MACHINE_C.ordinal()][4] = STOP;					//|
	}
}

