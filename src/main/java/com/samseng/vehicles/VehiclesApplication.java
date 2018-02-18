package com.samseng.vehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//SSE Java Spring
//https://golb.hplar.ch/2017/03/Server-Sent-Events-with-Spring.html
//https://dzone.com/articles/spring-boot-server-sent-events-tutorial

@SpringBootApplication
@ComponentScan("com.samseng")
@EnableScheduling
public class VehiclesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesApplication.class, args);
	}
	
}
