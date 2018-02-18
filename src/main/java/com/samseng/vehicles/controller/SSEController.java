package com.samseng.vehicles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.samseng.vehicles.sse.EventInfo;
import com.samseng.vehicles.sse.MemoryInfo;

//https://golb.hplar.ch/2017/03/Server-Sent-Events-with-Spring.html

@Controller
public class SSEController {

  static Logger log = Logger.getLogger(SSEController.class.getName());
  
  private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();
  private final CopyOnWriteArrayList<SseEmitter> clients = new CopyOnWriteArrayList<>();
  
  @GetMapping("/events")
  public SseEmitter events() {
	  
	  log.info("Sse Welcomme Client!");
	  SseEmitter client = new SseEmitter();
	    this.clients.add(client);

	    client.onCompletion(() -> this.clients.remove(client));
	    client.onTimeout(() -> this.clients.remove(client));

	    return client;
	    
  }
  
  @EventListener
  public void onEventInfo(EventInfo eventInfo) {
	  log.info("Sse NOtification!");
    List<SseEmitter> deadClients = new ArrayList<>();
    this.clients.forEach(client -> {
      try {
        client.send(eventInfo);
      }
      catch (Exception e) {
        deadClients.add(client);
      }
    });

    this.emitters.removeAll(deadClients);
  }

  @GetMapping("/memory")
  public SseEmitter handle() {

	log.info("Bienvenido. Gracias por escuchar.!");
	  
    SseEmitter emitter = new SseEmitter();
    this.emitters.add(emitter);

    emitter.onCompletion(() -> this.emitters.remove(emitter));
    emitter.onTimeout(() -> this.emitters.remove(emitter));

    return emitter;
  }

  @EventListener
  public void onMemoryInfo(MemoryInfo memoryInfo) {
    List<SseEmitter> deadEmitters = new ArrayList<>();
    this.emitters.forEach(emitter -> {
      try {
        emitter.send(memoryInfo);
      }
      catch (Exception e) {
        deadEmitters.add(emitter);
      }
    });

    this.emitters.removeAll(deadEmitters);
  }
}
