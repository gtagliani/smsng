package com.samseng.vehicles.repository;

import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.Company;

@Repository
public interface CompanyJpaRepository extends LogicDeleteJpaRepository<Company, Integer>{
	
}
