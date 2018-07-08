package com.samseng.vehicles.dto;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.samseng.vehicles.model.Driver;
import com.samseng.vehicles.model.Sector;
import com.samseng.vehicles.model.Vehicle;

public class DTOVehicleCheckin {
	private Integer id;
	private Sector sector;
	private Vehicle vehicle;
	private Set<Driver> drivers = new HashSet<Driver>(0);
	private List<Response> responsesList = new LinkedList<Response>();
	private String responses;
	
	
	
	public void setResponses(String responses) {
		this.responses = responses;
		
		processResponses();
		
	}

	private void processResponses() {
		
		for (String response: this.responses.split(";")) {
			String [] fields =response.split(",");
			
			Response r = new Response();
			r.setId(Integer.valueOf(fields[0]));
			r.setResponse(Short.valueOf(fields[1]));
			if (fields.length == 3) {
				r.setDescription(fields[2]);
			} else {
				r.setDescription("");
			}
			this.responsesList.add(r);
			
		}
		
	}

	public List<Response> getResponsesList() {
		return responsesList;
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


