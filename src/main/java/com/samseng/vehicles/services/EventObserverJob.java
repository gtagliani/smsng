package com.samseng.vehicles.services;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.sse.EventInfo;

@Service
public class EventObserverJob {
	static Logger log = Logger.getLogger(EventObserverJob.class.getName());
	public final ApplicationEventPublisher eventPublisher;

	public EventObserverJob(ApplicationEventPublisher eventPublisher) {
	  this.eventPublisher = eventPublisher;
	}

	public enum NotifyTypes {
		
		success,
		info,
		warning,
		danger;
		
	}
	
	public void notify(NotifyTypes type, String message) {
		
		notify( new EventInfo(type.toString(), message));
		
	}
	
	public void notify(EventInfo event) {
		
		log.info("Notifying: " + event.getEventType() + " message: " + event.getEventText());
		this.eventPublisher.publishEvent(event);
		
	}

}
