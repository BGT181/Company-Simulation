package com.event;

import com.entities.Employee;
import com.entities.Product.productType;
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
			case 0: employee.getMovementManager().setDestionation(Position.STORAGE);break;
			case 1:	if(employee.getCompany().getStorage().checkForProductType(productType.PRODUCT_A)>=0) {
						employee.getCompany().getStorage().pickUpItem(productType.PRODUCT_A, employee);
					} else {
						if(employee.getCompany().getStorage().checkForProductType(productType.PRODUCT_B)>=0) {
							employee.getCompany().getStorage().pickUpItem(productType.PRODUCT_B, employee);
						}
					} break;
			case 2: employee.getMovementManager().setDestionation(Position.MACHINE_A); break;
			case 3: employee.getCompany().getMachineA().loadMachine(employee); break;
			case 4: employee.removeAssignedEvent(); break;
		}
	}
	private void Machine_A_Unload() {					//Dest:Machine_A -> Unload(Aa/Bb) -> Dest:Storage -> sort(Aa/Bb) 
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.MACHINE_A);break;
			case 1:	employee.getCompany().getMachineA().unloadMachine(employee); break;
			case 2: employee.getMovementManager().setDestionation(Position.STORAGE); break;
			case 3: employee.getCompany().getStorage().storeProduct(employee.getCarryProduct(), employee); break;
			case 4: employee.removeAssignedEvent(); break;
		}
	}
	private void Machine_A_Request_Staff() {			//Dest:Machine_A -> Dest: Machine_A_SlotX
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.MACHINE_A);break;
			case 1:	employee.getCompany().getMachineA().AddDedicatedStaff(employee);; break;
			case 2: employee.removeAssignedEvent(); break;
		}
	}
	private void Machine_B_Refill_A() {					//Dest:Storage -> Pickup(A) -> Dest:Machine_B
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.STORAGE);break;
			case 1:	employee.getCompany().getStorage().pickUpItem(productType.PRODUCT_A_PROCESSED, employee); break;
			case 2: employee.getMovementManager().setDestionation(Position.MACHINE_B); break;
			case 3: employee.getCompany().getMachineB().loadMachine(employee); break;
			case 4: employee.removeAssignedEvent(); break;
		}	
	}
	private void Machine_B_Refill_B() {					//Dest:Storage -> Pickup(B) -> Dest:Machine_B
		switch(employee.getAssignedEvent().getEventStep()) {
		case 0: employee.getMovementManager().setDestionation(Position.STORAGE);break;
		case 1:	employee.getCompany().getStorage().pickUpItem(productType.PRODUCT_B_PROCESSED, employee); break;
		case 2: employee.getMovementManager().setDestionation(Position.MACHINE_B); break;
		case 3: employee.getCompany().getMachineB().loadMachine(employee); break;
		case 4: employee.removeAssignedEvent(); break;
	}		
	}
	private void Machine_B_Request_Staff() {			//Dest:Machine_B -> Dest: Machine_B_SlotX
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.MACHINE_B);break;
			case 1:	employee.getCompany().getMachineB().AddDedicatedStaff(employee);; break;
			case 2: employee.removeAssignedEvent(); break;
		}
	}
	private void Machine_B_Unload() {					//Dest:Machine_B -> Unload(Cc) -> Dest:Storage -> sort(Cc)
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.MACHINE_B);break;
			case 1:	employee.getCompany().getMachineB().unloadMachine(employee); break;
			case 2: employee.getMovementManager().setDestionation(Position.STORAGE); break;
			case 3: employee.getCompany().getStorage().storeProduct(employee.getCarryProduct(), employee); break;
			case 4: employee.removeAssignedEvent(); break;
		}
	}
	private void Machine_C_Refill() {					//Dest:Storage -> Pickup(Cc) -> Dest:Machine_C
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.STORAGE);break;
			case 1:	employee.getCompany().getStorage().pickUpItem(productType.PRODUCT_C, employee); break;
			case 2: employee.getMovementManager().setDestionation(Position.MACHINE_C); break;
			case 3: employee.getCompany().getMachineC().loadMachine(employee); break;
			case 4: employee.removeAssignedEvent(); break;
		}
	}	
	private void Machine_C_Request_Staff() {			//Dest:Machine_C -> Dest: Machine_C_SlotX
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.MACHINE_C);break;
			case 1:	employee.getCompany().getMachineC().AddDedicatedStaff(employee);; break;
			case 2: employee.removeAssignedEvent(); break;
		}	
	}
	private void Machine_C_Unload() {					//Dest:Machine_C -> Unload(C) -> Dest:Storage -> sort(C) 
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.MACHINE_C);break;
			case 1:	employee.getCompany().getMachineC().unloadMachine(employee); break;
			case 2: employee.getMovementManager().setDestionation(Position.STORAGE); break;
			case 3: employee.getCompany().getStorage().storeProduct(employee.getCarryProduct(), employee); break;
			case 4: employee.removeAssignedEvent(); break;
		}		
	}
	private void Truck_Entrance_Unload() {				//Dest:Truck_Entrence -> Unload(A/B) -> Dest:Storage -> sort(A/B)
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.TRUCK_ENTRANCE);break;
			case 1:	employee.getCompany().getTruckEntrence().unloadTruck(employee); break;
			case 2: employee.getMovementManager().setDestionation(Position.STORAGE); break;
			case 3: employee.getCompany().getStorage().storeProduct(employee.storeProduct(),employee); break;
			case 4: employee.removeAssignedEvent(); break;
		}
	}
	private void Truck_Exit_Load() {					//Dest:Storage -> Pickup(C) -> Dest:Truck_Exit -> Unload(C)
		switch(employee.getAssignedEvent().getEventStep()) {
			case 0: employee.getMovementManager().setDestionation(Position.STORAGE);break;
			case 1:	employee.getCompany().getStorage().pickUpItem(productType.PRODUCT_C_CERTIFIED, employee); break;
			case 2: employee.getMovementManager().setDestionation(Position.TRUCK_EXIT); break;
			case 3: employee.getCompany().getTruckExit().loadTruck(employee); break;
			case 4: employee.removeAssignedEvent();
		}
	}
		
	

}
