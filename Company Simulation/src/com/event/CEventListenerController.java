package com.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import com.entities.Employee;

public class CEventListenerController implements ActionListener{

	private CEventListener eventListener;
	private ArrayList<Employee> eventListenerList;
	Timer refreshTimer = new Timer(3000,this);
	
	public CEventListenerController(ArrayList<Employee> employees) {
		eventListener = new CEventListener();
		eventListenerList = employees;
		refreshTimer.start();
	}
	public void actionPerformed(ActionEvent ev){
		if(ev.getSource()==refreshTimer){
			checkForMatches();
			//printEvents();
			
		}
	}
	public void checkForMatches() {
		for (int i = 0; i < eventListener.getEventListener().size(); i++) {
			for (int j = 0; j < eventListenerList.size(); j++) {
				if(checkEmployee(eventListener.getEventListener().get(i),eventListenerList.get(j))) {
					eventListenerList.get(j).setAssignedEvent(eventListener.getEventListener().get(i));
					eventListener.getEventListener().remove(eventListener.getEventListener().get(i));
					break;
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
	
	public void printEvents() {
		for (int i = 0; i < eventListener.getEventListener().size(); i++) {
			if(eventListener.getEventListener().get(i)!=null) {
				System.out.print(eventListener.getEventListener().get(i).getCurrentEvent()+", ");
			}
		}
		System.out.println("");
	}
}
