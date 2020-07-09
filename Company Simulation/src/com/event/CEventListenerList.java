package com.event;

import java.util.ArrayList;

import com.entities.Employee;

public class CEventListenerList {

	private ArrayList<Employee> listenerList = new ArrayList<Employee>();
	
	public void addListener(Employee employee) {
		listenerList.add(employee);
	}
	
	public void removeListener(Employee employee) {
		listenerList.remove(employee);
	}
	
	public ArrayList<Employee> getListenerList() {
		return listenerList;
	}
}
