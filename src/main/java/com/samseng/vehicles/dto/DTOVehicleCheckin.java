package com.samseng.vehicles.dto;

import java.util.HashSet;
import java.util.Set;

import com.samseng.vehicles.model.Driver;
import com.samseng.vehicles.model.Sector;
import com.samseng.vehicles.model.Vehicle;

public class DTOVehicleCheckin {
	private Integer id;
	private Sector sector;
	private Vehicle vehicle;
	private Set<Driver> drivers = new HashSet<Driver>(0);
	private Set<Response> responses = new HashSet<Response>(0);
	
	
	public Set<Response> getResponses() {
		return responses;
	}

	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Sector getSector() {
		return sector;
	}




	public void setSector(Sector sector) {
		this.sector = sector;
	}




	public Vehicle getVehicle() {
		return vehicle;
	}




	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}




	public Set<Driver> getDrivers() {
		return drivers;
	}




	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}




	public static class Response {
		Integer id;
		Short response;
		String description;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Short getResponse() {
			return response;
		}
		public void setResponse(Short response) {
			this.response = response;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}

}


