package com.samseng.vehicles.repository;

import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.CompanyType;



@Repository
public interface DriverJpaRepository extends LogicDeleteJpaRepository<CompanyType, Integer> {
	
}
