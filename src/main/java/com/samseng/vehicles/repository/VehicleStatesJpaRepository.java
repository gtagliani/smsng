package com.samseng.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samseng.vehicles.model.VehicleStates;



public interface VehicleStatesJpaRepository extends JpaRepository<VehicleStates, Integer> {

}
