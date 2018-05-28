package com.samseng.vehicles.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samseng.vehicles.dto.DTOVehicleCheckin;
import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.model.VehicleRegistered;
import com.samseng.vehicles.services.DriverService;
import com.samseng.vehicles.services.VehicleService;

@Controller
public class VehicleCheckInController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	DriverService driverService;
	
	@GetMapping("vehiclecheckin/isvehicleregistered/{vehicleId}")
	@ResponseBody
	Boolean isVehicleRegistered(@PathVariable("vehicleId") String vehicleId) {
		return !vehicleService.findByVehicleIdAndNotDeleted(vehicleId).isEmpty();
	}
	
	
	@GetMapping("vehiclecheckin")
	String mainForm() {
		return "vehiclecheckin";
	}
	
	@GetMapping("vehiclecheckin/getvehicle/{vehicleId}")
	@ResponseBody
	List<Vehicle> getVehicle(@PathVariable("vehicleId") String vehicleId) {
		return vehicleService.findByVehicleIdAndNotDeleted(vehicleId);
	}
	
	@RequestMapping(value = "vehiclecheckin/save", method = RequestMethod.POST)
	@ResponseBody
	Boolean mainForm(DTOVehicleCheckin vehicleIn) {
		return true;
	}
	
	@GetMapping("vehiclecheckin/test")
	@ResponseBody
	DTOVehicleCheckin test(VehicleRegistered vehicleIn) {
		DTOVehicleCheckin t =  new DTOVehicleCheckin();
		DTOVehicleCheckin.Response r1 = new DTOVehicleCheckin.Response();
		r1.setId(1);
		r1.setDescription("d1");
		r1.setResponse((short)0);
		
		DTOVehicleCheckin.Response r2 = new DTOVehicleCheckin.Response();
		r2.setId(2);
		r2.setDescription("d2");
		r2.setResponse((short)2);
		
		Set<DTOVehicleCheckin.Response> responses = new HashSet<DTOVehicleCheckin.Response>();
		t.setResponses(responses);
		
		responses.add(r1);
		responses.add(r2);
		
		return t;
	}

}
