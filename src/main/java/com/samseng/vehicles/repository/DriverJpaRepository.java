package com.samseng.vehicles.repository;

import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.Driver;



@Repository
public interface DriverJpaRepository extends LogicDeleteJpaRepository<Driver, Integer> {
	
}
