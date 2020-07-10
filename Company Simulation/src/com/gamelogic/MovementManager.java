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
	
	public MovementManager(Employee employee) {
		this.employee = employee;
		step = 1;
		movementTask = new MovementTask();
	}
	
	public void updatePosition() {
		if(movementTask.getDestination()!=null) {
				if(!employee.isArrived()){
					employee.setxPos(employee.getxPos()+dirX);
					employee.setyPos(employee.getyPos()+dirY);
					if(employee.getCarryProduct()!=null) {
						employee.getCarryProduct().setxPos(employee.getxPos());
						employee.getCarryProduct().setyPos(employee.getyPos());
					}
					fetchDirection();
				}
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
				if(employee.getyPos()>movementTask.getYofPosition(movementTask.getDestination())) {
					dirY = -1;
				} else {
					dirY = 1;
				}
			}
			
			break;
			
		case 3:	//Alternate x until it reaches the x-level of the destination
			if(employee.getxPos()==movementTask.getXofPosition(movementTask.getDestination())) {
				step = 0;
				employee.setArrived(true);
				if(employee.getAssignedEvent()!=null) {
					employee.getAssignedEvent().increaseEventStep();
				}
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

	public Employee getEmployee() {
		return employee;
	}
	
	public void setMovementTask(Position start, Position destination) {
		movementTask.setMovementTask(start, destination);
		employee.setPosition(start);
	}

	public void setDestionation(Position position) {
		movementTask.setDestination(position);
	}

}

