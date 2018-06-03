package com.samseng.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.VehicleLog;

@Repository
public interface VehicleLogJpaRepository extends JpaRepository<VehicleLog, Integer>{

}
