package com.actionlistener;

import java.util.EventObject;

public class CompanyAction extends EventObject {
	
	public enum Action {
		MACHINE_A_REQUEST_REFILL,	       
		MACHINE_A_REQUEST_UNLOAD,
		MACHINE_A_REQUEST_STAFF,
		
		MACHINE_B_REQUEST_REFILL_A,
		MACHINE_B_REQUEST_REFILL_B,
		MACHINE_B_REQUEST_UNLOAD,
		MACHINE_B_REQUEST_STAFF,
		
		MACHINE_C_REQUEST_REFILL,
		MACHINE_C_REQUEST_UNLOAD,
		MACHINE_C_REQUEST_STAFF,
		
		TRUCK_ENTRANCE_UNLOAD,
		TRUCK_EXIT_LOAD,
	}
	
	public CompanyAction(Object object, Action action) {
		super(object);
	}	
}
