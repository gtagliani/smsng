package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samseng.vehicles.model.VehicleRegistered;

public interface VehicleRegisteredJpaRepository extends JpaRepository<VehicleRegistered, Integer>{

	List<VehicleRegistered> findAllByVehicleIdOrderByDateTimestampDesc(Integer id);
}

