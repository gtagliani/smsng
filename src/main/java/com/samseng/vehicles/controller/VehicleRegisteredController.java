package com.samseng.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samseng.vehicles.dto.WaitingForDTO;
import com.samseng.vehicles.services.VehicleRegisteredService;

@Controller
public class VehicleRegisteredController {
	
	@Autowired
	VehicleRegisteredService vehicleRegisteredLogService;
	
	@GetMapping("/vehicleregistered/waitingFor/{id}")
	@ResponseBody
	public List<WaitingForDTO> waitingFor(@PathVariable("id") Integer sector) {
		return vehicleRegisteredLogService.getVehiclesWaitingForSector(sector);
	}

}
