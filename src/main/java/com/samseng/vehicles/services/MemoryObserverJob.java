package com.samseng.vehicles.services;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.controller.SSEController;
import com.samseng.vehicles.sse.MemoryInfo;

@Service
public class MemoryObserverJob {
	
  static Logger log = Logger.getLogger(MemoryObserverJob.class.getName());

  public final ApplicationEventPublisher eventPublisher;

  public MemoryObserverJob(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  //@Scheduled(fixedRate = 1000)
  public void doSomething() {
	  
	  log.info("start Sending something"); 
    MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
    MemoryUsage heap = memBean.getHeapMemoryUsage();
    MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();
    

    MemoryInfo mi = new MemoryInfo(heap.getUsed(), nonHeap.getUsed());
    
    log.info("Sending something");
    this.eventPublisher.publishEvent(mi);
    
  }
}

