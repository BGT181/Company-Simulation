package com.gamelogic;

import com.entities.Employee;
import com.gamelogic.Task.MovementTasks;

public class MovementManager {

	enum Milestone {
		TRUCK_ENTRANCE, CHECKPOINT_A,	MASCHINE_A,	//#0 #1 #2
		STORAGE, 		CHECKPOINT_B, 	MACHINE_B,	//#3 #4 #5
		TRUCK_EXIT, 	CHECKPOINT_C, 	MACHINE_C 	//#6 #7 #8
	}
	
	private Employee employee;
	private MovementTasks task;
	private int xPos;
	private int yPos;
	private int orientation;
	private int[][] coordinates = new int[9][2]; 
	
	public MovementManager(Employee employee) {
		this.employee = employee;
		this.task = employee.getTask().getMovementTasks();
		this.xPos = employee.getxPos();
		this.yPos = employee.getyPos();
		this.orientation = employee.getOrientation();
		
		loadCoordinates();
	}
	
	public void updatePosition() {
		fetchTasks();										//Fetches the new Task of the Employee's Task
		calculatePosition();								//Calculates the new Position 
															//Changes states of the employee e.g. Avadiable
		employee.setPosition(xPos, yPos, orientation);		//Updates the attributes of the employee
	}
	
	private void addToArray(Milestone milestone, int x, int y) {
		coordinates[milestone.ordinal()][0] = x;
		coordinates[milestone.ordinal()][1] = x;
	}
	
	private void loadCoordinates() {
		addToArray(Milestone.TRUCK_ENTRANCE	, 280, 120);
		addToArray(Milestone.CHECKPOINT_A	, 450, 120);
		addToArray(Milestone.MASCHINE_A		, 625, 120);
		addToArray(Milestone.STORAGE		, 200, 375);
		addToArray(Milestone.CHECKPOINT_B	, 450, 375);
		addToArray(Milestone.MACHINE_B		, 600, 375);
		addToArray(Milestone.TRUCK_EXIT		, 280, 575);
		addToArray(Milestone.CHECKPOINT_C	, 450, 575);
		addToArray(Milestone.MACHINE_C		, 625, 575);
	}
	
	private void fetchTasks() {
		this.task = employee.getTask().getMovementTasks();
	}
	
	private void calculatePosition() {
		/*
		 * Getting the Task
		 * Check the Milestones he needs to get next
		 * Setting new xPos, yPos
		 * Setting the Orientation
		 */
	}
	
	
	/*
	 *	TRUCK_ENTRANCE -> STORAGE 	via CHECKPOINT_A, CHECKPOINT_B
	 * 	TRUCK_ENTRANCE -> MACHINE_A	via CHECKPOINT_A
	 * 	STORAGE <-> MACHINE_A		via CHECKPOINT_B, CHECKPOINT_A
	 *  STORAGE <-> MACHINE_B		via CHECKPOINT_B
	 * 	STORAGE <-> MACHINE_C		via CHECKPOINT_B, CHECKPOINT_C
	 * 	STORAGE -> TRUCK_EXIT		via CHECKPOINT_B, CHECKPOINT_C
	 * 	MACHINE_C -> TRUCK_EXIT		via CHECKPOINT_C
	 * 	MACHINE_A -> MACHINE_B		via CHECKPOINT_A, CHECKPOINT_B
	 *  MACHINE_B -> MACHINE_C		via CHECKPOINT_B, CHECKPOINT_C
	 *  
	 */ 
}

