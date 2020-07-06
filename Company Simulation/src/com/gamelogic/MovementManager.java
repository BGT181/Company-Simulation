package com.gamelogic;

import com.entities.Employee;
import com.gamelogic.MovementTask.Position;

public class MovementManager {
	
	private Employee employee;
	private MovementTask movementTask;
	private ImageProvider ip = new ImageProvider();
	private int step;
	
	private int dirX;
	private int dirY;
	private int orientation;
	
	public MovementManager(Employee employee) {
		this.employee = employee;
	}
	
	public void updatePosition() {
		if(!employee.isArrived()){
		
			employee.setxPos(employee.getxPos()+dirX);
			employee.setyPos(employee.getyPos()+dirY);
			fetchDirection();
		}
		
	}

	private void fetchDirection() {
		int oldDirX = dirX;
		int oldDirY = dirY;
		
		switch(step ) {
		
		case 1: //Go to the next Checkpoint 
			if(employee.getxPos()==movementTask.getXofPosition(Position.CHECKPOINT_A)) {
				step++;
				dirX = 0;
			} else {
				if(employee.getxPos()>movementTask.getXofPosition(Position.CHECKPOINT_A)) {
					dirX = -1;
				} else {
					dirX = 1;
				}
			}
			break;
		
		case 2:	//Alternate y until it reaches the y-level of the destination
			if(employee.getyPos()==movementTask.getYofPosition(movementTask.getDestination())) {
				step++;
				dirY = 0;
			} else {
				if(employee.getyPos()>movementTask.getXofPosition(movementTask.getDestination())) {
					dirX = 1;
				} else {
					dirX = -1;
				}
			}
			
			break;
			
		case 3:	//Alternate x until it reaches the x-level of the destination
			if(employee.getxPos()==movementTask.getXofPosition(movementTask.getDestination())) {
				step = 0;
				employee.setArrived(true);
			} else {
				if(employee.getxPos()>movementTask.getXofPosition(movementTask.getDestination())) {
					dirX = -1;
				} else {
					dirX = 1;
				}
			}
			break;	
		}
		
		if((dirX!=oldDirX)||(dirY!=oldDirY)) {
			employee.changeImage(dirX, dirY);
		}	
	}

	public MovementTask getMovementTask() {
		return this.movementTask;
	}


}

