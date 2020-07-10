package com.event;

import java.util.ArrayList;

import com.entities.Employee;

public class CEventListenerController {

	private CEventListener eventListener;
	private ArrayList<Employee> eventListenerList;
	
	public CEventListenerController(ArrayList<Employee> employees) {
		eventListener = new CEventListener();
		eventListenerList = employees;
	}
	
	public void checkForMatches() {
		for(CEvent event : eventListener.getEventListener()) {
			for (int i = 0; i < eventListenerList.size(); i++) {
				if(checkEmployee(event,eventListenerList.get(i))) {
					eventListenerList.get(i).setAssignedEvent(event);
					eventListener.getEventListener().remove(event);
				}
			}
		}
	}
	
	private boolean checkEmployee(CEvent event, Employee employee) {
		if(employee.getAvailability() && employee.isArrived()) {
			switch (event.getCurrentEvent()) {
			case MACHINE_A_REQUEST_STAFF:	if(employee.getQualification(1)) {	return true;	}	break;
			case MACHINE_B_REQUEST_STAFF: 	if(employee.getQualification(2)) { 	return true;	} 	break;
			case MACHINE_C_REQUEST_STAFF:	if(employee.getQualification(3)) { 	return true;	} 	break;
			default: 						if(employee.getQualification(0)) { 	return true;	}	break; 
			}
		}
		return false;
	}
	
	public void cEventOccurred(CEvent cEvent) {
		eventListener.cEventOccurred(cEvent);
	}
	
	public void removeCEvent(CEvent cEvent) {
		eventListener.removeCEvent(cEvent);
	}
}
