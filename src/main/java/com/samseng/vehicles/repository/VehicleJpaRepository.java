package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.Vehicle;


@Repository
public interface VehicleJpaRepository extends LogicDeleteJpaRepository<Vehicle, Integer> {

	List<Vehicle> findByVehicleIdAndDeleted(String vehicleId,Short deleted);
	
	

}
