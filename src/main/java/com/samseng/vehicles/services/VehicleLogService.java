package com.samseng.vehicles.services;

import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.model.VehicleLog;
import com.samseng.vehicles.model.VehicleRegistered;
import com.samseng.vehicles.model.VehicleStates;
import com.samseng.vehicles.repository.VehicleLogJpaRepository;



@Service
public class VehicleLogService {

	@Autowired
	VehicleLogJpaRepository logRepository;
	
	@Autowired
	VehicleStatesService vehicleStatesService;
	
	@Autowired
	VehicleRegisteredService vehicleRegisteredService;
	
	VehicleLog addLog(VehicleRegistered vr, VehicleStates s, Date timestamp) {
		VehicleLog ret =new VehicleLog();
		ret.setVehicleStates(s);
		ret.setVehicleRegistered(vr);
		ret.setDateTimestamp(timestamp);
		ret.setLastLogRegistered((short)1);
		
		logRepository.saveAndFlush(ret);
		return ret;
	}
	
	VehicleLog addLog(VehicleRegistered vr, VehicleStates s) {
		
		return addLog(vr,s,new Date());
	}
	
	boolean existsVehicleRegistered(Vehicle vehicle) {
		
		VehicleRegistered vehicleRegistered = vehicleRegisteredService.getLastTimeVehicleWasRegistered(vehicle);
		
		if (vehicleRegistered == null)
			return false;
		
		 boolean aux = logRepository
				.findByVehicleRegisteredIdAndLastLogRegisteredAndVehicleStatesIdNotIn(vehicleRegistered.getId(),(short)1,vehicleStatesService.getFinalStatesAsInteger())
				.isEmpty();
		
		return !aux;
	}
}
