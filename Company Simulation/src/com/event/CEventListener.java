package com.event;

import java.util.ArrayList;

public class CEventListener {

	private ArrayList<CEvent> eventListener = new ArrayList<CEvent>();
	
	public void cEventOccurred(CEvent cEvent) {
		eventListener.add(cEvent);
	}
	
	public void removeCEvent(CEvent cevent) {
		eventListener.remove(cevent);
	}
	
	public ArrayList<CEvent> getEventListener() {
		return eventListener;
	}
	
}
