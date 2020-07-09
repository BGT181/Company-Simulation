package com.event;

import com.entities.Entity;

public class CEvent {

	private Entity entity;
	private Event currentEvent;
	
	
	public enum Event {
		MACHINE_A_REFILL,
		MACHINE_A_UNLOAD,
		MACHINE_A_REQUEST_STAFF,
		
		MACHINE_B_REFILL_A,
		MACHINE_B_REFILL_B,
		MACHINE_B_UNLOAD,
		MACHINE_B_REQUEST_STAFF,
		
		MACHINE_C_REFILL,
		MACHINE_C_UNLOAD,
		MACHINE_C_REQUEST_STAFF,
		
		TRUCK_ENTRANCE_UNLOAD,
		TRUCK_EXIT_LOAD
	}
	
	public CEvent(Entity entity, Event currentEvent) {
		this.setEntity(entity);
		this.setCurrentEvent(currentEvent);
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Event getCurrentEvent() {
		return currentEvent;
	}

	public void setCurrentEvent(Event currentEvent) {
		this.currentEvent = currentEvent;
	}
	
	
}
