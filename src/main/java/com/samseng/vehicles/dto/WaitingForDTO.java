package com.samseng.vehicles.dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.samseng.vehicles.dto.WaitingForDTO.ResponsesInfo;

public class WaitingForDTO {
	
	Integer vehicleRegisteredId;
	String date;
	String company;
	String vehicleId;
	String vehicleType;
	String sector;
	String state;
	
	List <ResponsesInfo> responses;
	
	
	public WaitingForDTO(Integer id,String date, String company, String vehicleId, String vehicleType, String sector, String state,List <ResponsesInfo> responses) {
		super();
		this.vehicleRegisteredId = id;
		this.date = date;
		this.company = company;
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.sector = sector;
		this.state = state;
		if (responses == null) {
			this.responses = new LinkedList<ResponsesInfo>();
		} else
			this.responses = responses;
	}
	
	public Integer getId() {
		return this.vehicleRegisteredId;
	}
	
	public String getDate() {
		return date;
	}
	public String getCompany() {
		return company;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public String getSector() {
		return sector;
	}
	public String getState() {
		return state;
	}
	
	public List <ResponsesInfo> getRsponses(){
		return responses;
	}
	
	public static class ResponsesInfo {
		String question;
		Boolean positive;
		String response;
		
		
		public ResponsesInfo(String question, Boolean positive, String response) {
			super();
			this.question = question;
			this.positive = positive;
			this.response = response;
		}
		
		public String getQuestion() {
			return question;
		}
		public Boolean getPositive() {
			return positive;
		}
		public String getResponse() {
			return response;
		}
		
		
		
	}
	

}

