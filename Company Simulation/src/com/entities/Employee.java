package com.entities;

import com.entities.Product.productType;
import com.event.CEvent;
import com.event.TaskManager;
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
	private boolean isArrived = true;
	private Product carryProduct;
	private ImageType imageType;
	private CEvent assignedEvent;
	private TaskManager taskManager;
	
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
		taskManager = new TaskManager(this);
		changeImage(movementManager.getMovementTask().getDirXofPosition(position), movementManager.getMovementTask().getDirYofPosition(position));
	}
	
	//Interfaces
	public MovementManager getMovementManager() {
		return movementManager;
	}
	public CEvent getAssignedEvent() {
		return assignedEvent;
	}
	public void setAssignedEvent(CEvent assignedEvent) {
		setAvailability(false);
		this.assignedEvent = assignedEvent;
		taskManager.fetchTask();
	}
	public void removeAssignedEvent() {
		setAvailability(true);
		assignedEvent = null;
	}
	public Product getCarryProduct() {
		return carryProduct;
	}
	public void setCarryProduct(Product carryProduct) {
		this.carryProduct = carryProduct;
	}
	public void increaseEventStep() {
		if(assignedEvent!=null) {
			assignedEvent.increaseEventStep();
			taskManager.fetchTask();
		}
	}

	public Product storeProduct() {
		Product product = carryProduct;
		carryProduct = null;
		return product; 
	}
	
	//Position / Optic
	public void setPosition(Position position) {
		super.setxPos(movementManager.getMovementTask().getXofPosition(position));
		super.setyPos(movementManager.getMovementTask().getYofPosition(position));
		changeImage(movementManager.getMovementTask().getDirXofPosition(position), movementManager.getMovementTask().getDirYofPosition(position));
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
	
	//Game-Logik
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
	public boolean getQualification(int x) {
		return qualification[x];
	}
	public void setQualification(int qualificationNum) {
		this.qualification[qualificationNum] ^= true;
	}
	public String getName() {
		return name;
	}
	public Company getCompany() {
		return company;
	}
	public boolean reachedPosition(Position position) {
		return movementManager.reachedPosition(position);
	}
	
	

	



	

	
}
