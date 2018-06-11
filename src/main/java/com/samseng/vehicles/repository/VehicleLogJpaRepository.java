package com.samseng.vehicles.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.model.VehicleLog;
import com.samseng.vehicles.model.VehicleStates;

@Repository
public interface VehicleLogJpaRepository extends JpaRepository<VehicleLog, Integer>{
	List<Vehicle> findByVehicleRegisteredIdAndLastLogRegisteredAndVehicleStatesIdNotIn(Integer vehicle,Short flag,Set<Integer> states);
}
