package com.samseng.vehicles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.repository.VehicleJpaRepository;

@Service
public class VehicleService extends LogicDeleteAbstractService  <Vehicle,Integer>{
	
	@Autowired
	VehicleJpaRepository repository;
	
	public List<Vehicle> findByVehicleIdAndNotDeleted(String vehicleId){
		return repository.findByVehicleIdAndDeleted(vehicleId,(short) 0);
	}
	
}
