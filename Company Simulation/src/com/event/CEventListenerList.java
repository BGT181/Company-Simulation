package com.event;

import java.util.ArrayList;

import com.entities.Entity;

public class CEventListenerList {

	private ArrayList<Entity> listenerList = new ArrayList();
	
	public void addListener(Entity entity) {
		listenerList.add(entity);
	}
}
