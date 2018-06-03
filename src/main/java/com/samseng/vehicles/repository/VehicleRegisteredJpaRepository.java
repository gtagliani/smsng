package com.samseng.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samseng.vehicles.model.VehicleRegistered;

public interface VehicleRegisteredJpaRepository extends JpaRepository<VehicleRegistered, Integer>{

}
