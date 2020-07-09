package com.event;

import java.util.ArrayList;

import com.entities.Employee;
import com.gamelogic.MovementTask.Position;

public class CEventListenerController {

	private CEventListener eventListener;
	private CEventListenerList eventListenerList;
	
	
	public CEventListenerController() {
		eventListener = new CEventListener();
		eventListenerList = new CEventListenerList();
	}
	
	
	
	
	
	public void orderMovement(Employee employee, Position destionation) {
	/*
	 * TODO
	 * Wenn Employee frei ist
	 * Wenn Employee an einer Position ist (also Arrived ist)
	 * Dann setze ihn eine neue Destination
	 * 
	 * 	
	 */
	}
}
