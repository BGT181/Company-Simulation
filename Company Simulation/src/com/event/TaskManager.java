package com.event;

import com.entities.Employee;
import com.gamelogic.MovementTask.Position;

public class TaskManager {

	private Employee employee;
	
	public TaskManager(Employee employee) {
		this.employee = employee;
	}
	
	public void fetchTask() {
		if(employee.getAssignedEvent()!=null) {
			switch(employee.getAssignedEvent().getCurrentEvent()) {
				case MACHINE_A_REFILL: 			Machine_A_Refill(); 		break;	
				case MACHINE_A_UNLOAD:			Machine_A_Unload(); 		break;
				case MACHINE_A_REQUEST_STAFF:	Machine_A_Request_Staff(); 	break;
				case MACHINE_B_REFILL_A:		Machine_B_Refill_A(); 		break;
				case MACHINE_B_REFILL_B:		Machine_B_Refill_B(); 		break;
				case MACHINE_B_REQUEST_STAFF:	Machine_B_Request_Staff(); 	break;
				case MACHINE_B_UNLOAD:			Machine_B_Unload(); 		break;
				case MACHINE_C_REFILL:			Machine_C_Refill(); 		break;
				case MACHINE_C_REQUEST_STAFF:	Machine_C_Request_Staff(); 	break;
				case MACHINE_C_UNLOAD:			Machine_C_Unload(); 		break;
				case TRUCK_ENTRANCE_UNLOAD:		Truck_Entrance_Unload(); 	break;
				case TRUCK_EXIT_LOAD:			Truck_Exit_Load(); 			break;
			}
		}
	}
	
	private void Machine_A_Refill() {					//Dest:Storage -> Pickup(A/B) -> Dest:Machine_A
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.STORAGE); break;
			//case 1: employee.setCarryProduct(employee.getCompany().getStorage().pickUpItem(productType.PRODUCT_A,employee)); break;
			//case 2: movementManager.setDestionation(Position.MACHINE_A); break;
			case 3: break;
		}
	}
	private void Machine_A_Unload() {					//Dest:Machine_A -> Unload(Aa/Bb) -> Dest:Storage -> sort(Aa/Bb) 
		
	}
	private void Machine_A_Request_Staff() {			//Dest:Machine_A -> Dest: Machine_A_SlotX
		
	}
	private void Machine_B_Refill_A() {					//Dest:Storage -> Pickup(A) -> Dest:Machine_B
		
	}
	private void Machine_B_Refill_B() {					//Dest:Storage -> Pickup(B) -> Dest:Machine_B
		
	}
	private void Machine_B_Request_Staff() {			//Dest:Machine_B -> Dest: Machine_B_SlotX
		
	}
	private void Machine_B_Unload() {					//Dest:Machine_B -> Unload(Cc) -> Dest:Storage -> sort(Cc)
		
	}
	private void Machine_C_Refill() {					//Dest:Storage -> Pickup(Cc) -> Dest:Machine_C
		
	}	
	private void Machine_C_Request_Staff() {			//Dest:Machine_C -> Dest: Machine_C_SlotX
		
	}
	private void Machine_C_Unload() {					//Dest:Machine_C -> Unload(C) -> Dest:Storage -> sort(C) 
		
	}
	private void Truck_Entrance_Unload() {				//Dest:Truck_Entrence -> Unload(A/B) -> Dest:Storage -> sort(A/B)
		
	}
	private void Truck_Exit_Load() {					//Dest:Storage -> Pickup(C) -> Dest:Truck_Exit -> Unload(C)
		
	}

	
}
