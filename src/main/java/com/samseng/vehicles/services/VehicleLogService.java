package com.samseng.vehicles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.model.VehicleLog;
import com.samseng.vehicles.model.VehicleRegistered;
import com.samseng.vehicles.model.VehicleStates;
import com.samseng.vehicles.repository.VehicleLogJpaRepository;



@Service
public class VehicleLogService {

	@Autowired
	VehicleLogJpaRepository vehicleRepository;
	
	VehicleLog addLog(VehicleRegistered vr, VehicleStates s) {
		
		return null;
	}
}
