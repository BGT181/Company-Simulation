package com.entities;

import com.entities.Product.productType;
import com.event.CEvent;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.ImageProvider.Imagefor;
import com.gamelogic.MovementManager;
import com.gamelogic.MovementTask.Position;

public class Employee extends Entity {

	public enum Qualification {
		LOGISTICS, 		// #0
		PREPROCESSING, 	// #1
		PROCESSING, 	// #2
		QUALITYCHECK 	// #3
	}
	
	public enum ImageType {
		EMPLOYEE_A,
		EMPLOYEE_B,
		EMPLOYEE_C
	}

	private String name;
	private double loan = 3000;
	private double efficiencyLvl = 1;
	private boolean isAvailable = true;
	private boolean isArrived = false;
	private Product carryProduct;
	private ImageType imageType;
	private CEvent assignedEvent;
	
	private Company company;
	private MovementManager movementManager = new MovementManager(this);
	private ImageProvider ip = new ImageProvider();
	private boolean[] qualification = new boolean[4];
	
	public Employee(ImageType imageType, Position position, String name, Company company) {
		super(null, 1, 1 ,0);		
		setPosition(position);
		this.name = name;
		this.imageType = imageType;
		this.company = company;
		changeImage(movementManager.getMovementTask().getDirXofPosition(position), movementManager.getMovementTask().getDirYofPosition(position));
	}
	
	public void fetchTask() {
		if(assignedEvent!=null) {
			switch(assignedEvent.getCurrentEvent()) {
				case MACHINE_A_REFILL: 			switch(assignedEvent.getEventStep()) {
														case 0: movementManager.setDestionation(Position.STORAGE); break;
														case 1: setCarryProduct(company.getStorage().pickUpItem(productType.PRODUCT_A,this)); break;
														case 2: movementManager.setDestionation(Position.MACHINE_A); break;
														case 3: break;
												}
					//Dest:Storage -> Pickup(A/B) -> Dest:Machine_A
				case MACHINE_A_UNLOAD:			//Dest:Machine_A -> Unload(Aa/Bb) -> Dest:Storage -> sort(Aa/Bb) 
				case MACHINE_A_REQUEST_STAFF:	//Dest:Machine_A -> Dest: Machine_A_SlotX
				case MACHINE_B_REFILL_A:		//Dest:Storage -> Pickup(A) -> Dest:Machine_B
				case MACHINE_B_REFILL_B:		//Dest:Storage -> Pickup(B) -> Dest:Machine_B
				case MACHINE_B_REQUEST_STAFF:	//Dest:Machine_B -> Dest: Machine_B_SlotX
				case MACHINE_B_UNLOAD:			//Dest:Machine_B -> Unload(Cc) -> Dest:Storage -> sort(Cc) 
				case MACHINE_C_REFILL:			//Dest:Storage -> Pickup(Cc) -> Dest:Machine_C
				case MACHINE_C_REQUEST_STAFF:	//Dest:Machine_C -> Dest: Machine_C_SlotX
				case MACHINE_C_UNLOAD:			//Dest:Machine_C -> Unload(C) -> Dest:Storage -> sort(C) 
				case TRUCK_ENTRANCE_UNLOAD:		//Dest:Truck_Entrence -> Unload(A/B) -> Dest:Storage -> sort(A/B)
				case TRUCK_EXIT_LOAD:			//Dest:Storage -> Pickup(C) -> Dest:Truck_Exit -> Unload(C)
			}
		}
	}
	
	public void changeImage(int dirX, int dirY) {
		if(imageType == ImageType.EMPLOYEE_A) {
			switch(dirX) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_A_RIGHT));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_A_LEFT));	break;
			}
			switch(dirY) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_A_DOWN));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_A_UP));		break;
			}
		}
		
		if(imageType == ImageType.EMPLOYEE_B) {
			switch(dirX) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_B_RIGHT));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_B_LEFT));	break;
			}
			switch(dirY) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_B_DOWN));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_B_UP));		break;
			}
		}
		
		if(imageType == ImageType.EMPLOYEE_C) {
			switch(dirX) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_C_RIGHT));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_C_LEFT));	break;
			}
			switch(dirY) {
			case 1:		setImage(ip.getImage(Imagefor.EMPLOYEE_C_DOWN));	break;
			case -1:	setImage(ip.getImage(Imagefor.EMPLOYEE_C_UP));		break;
			}
		}	
	}
	public void increaseLoan(double increasementLoan) {
		this.loan = loan * increasementLoan;
	}
	public double getLoan() {
		return this.loan;
	}
	public void increaseEfficiencyLvl(double increasementEfficiency) {
		this.efficiencyLvl = efficiencyLvl * increasementEfficiency;
	}
	public double getEfficiencyLvl() {
		return this.efficiencyLvl;
	}
	public void setAvailability(boolean availability) {
		this.isAvailable = availability;
	}
	public boolean getAvailability() {
		return isAvailable;
	}
	public boolean isArrived() {
		return isArrived;
	}
	public void setArrived(boolean isArrived) {
		this.isArrived = isArrived;
	}
	public void setPosition(Position position) {
		super.setxPos(movementManager.getMovementTask().getXofPosition(position));
		super.setyPos(movementManager.getMovementTask().getYofPosition(position));
	}
	public boolean getQualification(int x) {
		return qualification[x];
	}
	public void setQualification(int qualificationNum) {
		this.qualification[qualificationNum] ^= true;
	}
	public String getName() {
		return name;
	}
	public MovementManager getMovementManager() {
		return movementManager;
	}

	public CEvent getAssignedEvent() {
		return assignedEvent;
	}

	public void setAssignedEvent(CEvent assignedEvent) {
		this.assignedEvent = assignedEvent;
	}

	public Product getCarryProduct() {
		return carryProduct;
	}

	public void setCarryProduct(Product carryProduct) {
		this.carryProduct = carryProduct;
	}
}
