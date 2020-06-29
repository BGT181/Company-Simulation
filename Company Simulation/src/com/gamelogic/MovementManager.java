package com.gamelogic;

import com.entities.Employee;
import com.gamelogic.MovementTask.Move;

public class MovementManager {
	
	private Employee employee;
	private MovementTask movementTask;
	
	private int dirX;
	private int dirY;
	private int orientation;
	
	public MovementManager(Employee employee) {
		this.employee = employee;
		orientation = 0;
		movementTask = new MovementTask(Move.TRUCK_ENTRANCE_TO_STORAGE);
		employee.setxPos((int)movementTask.getVector(0).elementAt(0));
		employee.setyPos((int)movementTask.getVector(0).elementAt(1));
		movementTask.increaseCurrentIndex();
		calculateMovement();
		
	}
	
	private void calculateMovement() { //Calculates dirX and dirY
		//Caluculates dirX in respect of the movmentTasks current Index.
		if(employee.getxPos() > (int) movementTask.getVector(movementTask.getCurrentIndex()).elementAt(0)) {
			dirX = -1;
		} else {
			if(employee.getxPos() < (int) movementTask.getVector(movementTask.getCurrentIndex()).elementAt(0)) {
				dirX = 1;
			} else {
				dirX = 0;
			}
		}
		//Calucaltes dirY in respect of the movementTasks current Index.
		if(employee.getyPos() > (int) movementTask.getVector(movementTask.getCurrentIndex()).elementAt(1)) {
			dirY = -1;
		} else {
			if(employee.getyPos() < (int) movementTask.getVector(movementTask.getCurrentIndex()).elementAt(1)) {
				dirY = 1;
			} else {
				dirY=0;
				}
		}
		
		if((dirX==1)&&(dirY==0)) {
			orientation = 90;
		} 
		if((dirX==0)&&(dirY==1)) {
			orientation = 180;
		}
		if((dirX==-1)&&(dirY==0)) {
			orientation = 270;
		}
		if((dirX==0)&&(dirY==-1)) {
			orientation = 0;
		}
		employee.setOrientation(orientation);
	}
	
	public void setMovementTask(Move move) {
		movementTask.setMovementTask(move);
		employee.setxPos((int)movementTask.getVector(0).elementAt(0));
		employee.setyPos((int)movementTask.getVector(0).elementAt(1));
		calculateMovement();
	}
	
	public void updatePosition() {
		if(!employee.isArrived()) {
			employee.setxPos(employee.getxPos()+dirX);
			employee.setyPos(employee.getyPos()+dirY);
		
			if(isEqual(employee.getxPos(), employee.getyPos(), (int) movementTask.getVector(movementTask.getCurrentIndex()).elementAt(0), (int) movementTask.getVector(movementTask.getCurrentIndex()).elementAt(1))) {
				fetchNextIndex();
			} 
		}
	}
	
	private boolean isEqual(int ax, int ay, int bx, int by) {	//Checks if all x-coords and y-coords are equal.
		if((ax==bx)&&(ay==by)) {
			return true;
		} else {
			return false;
		}
	}

	private void fetchNextIndex() {
		if((int)movementTask.getVector(movementTask.getCurrentIndex()+1).elementAt(0)!=0) {
			movementTask.increaseCurrentIndex();
			calculateMovement();
		} else {
			employee.setArrived(true);
		}
	}
}

