package com.samseng.vehicles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.model.VehicleRegistered;

import com.samseng.vehicles.repository.VehicleRegisteredJpaRepository;

@Service
public class VehicleRegisteredService {

	@Autowired
	VehicleRegisteredJpaRepository repository;
	
	public void save (VehicleRegistered vehicle) {
		repository.saveAndFlush(vehicle);
	}
	
	public VehicleRegistered getLastTimeVehicleWasRegistered(Vehicle vehicle){
		
		java.util.List<VehicleRegistered> aux = repository.findAllByVehicleIdOrderByDateTimestampDesc(vehicle.getId());
		if (aux.isEmpty()){
			return null;
		}
		
		return aux.get(0);
	}
}
