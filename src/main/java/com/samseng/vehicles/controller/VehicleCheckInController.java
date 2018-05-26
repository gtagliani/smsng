package com.samseng.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	Boolean mainForm(VehicleRegistered vehicleIn) {
		return true;
	}
	
	@GetMapping("vehiclecheckin/test")
	@ResponseBody
	VehicleRegistered test(VehicleRegistered vehicleIn) {
		return new VehicleRegistered();
	}

}
