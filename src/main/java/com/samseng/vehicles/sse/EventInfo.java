package com.samseng.vehicles.sse;

public class EventInfo {
	
	final private String eventType;
	final private String eventText;
	
	public EventInfo(String eventType, String eventText) {
		super();
		this.eventType = eventType;
		this.eventText = eventText;
	}

	public String getEventType() {
		return eventType;
	}

	public String getEventText() {
		return eventText;
	}
	
}
