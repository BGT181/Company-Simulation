package com.gamelogic;

public class Task {

	private Task currentTask; 
	
	public enum Tasks{
		GET_PRODUCT_A_TO_MACHINE_A,
		GET_PRODUCT_B_TO_MACHINE_A,
		GET_PRODUCT_FROM_MACHINE_A,
		GET_PRODUCT_A_PROCESSED_TO_MACHINE_B,
		GET_PRODUCT_B_PROCESSED_TO_MACHINE_B,
		GET_PRODUCT_FROM_MACHINE_B,
		GET_PRODUCT_C_TO_MACHINE_C,
		GET_PRODUCT_FROM_MACHINE_C,
		GET_PRODUCTS_FROM_TRUCK,
		PROCESS_MACHINE_A,
		PROCESS_MACHINE_B,
		PROCESS_MACHINE_C
	}
	
	public Task() {
		
	}
	
	public Task getCurrentTask() {
		return currentTask;
	}
	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}
	
	
}
