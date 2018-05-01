package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.Company;
import com.samseng.vehicles.model.Driver;



@Repository
public interface DriverJpaRepository extends LogicDeleteJpaRepository<Driver, Integer> {

	List<Driver> findByCompanyAndDeleted(Company companyID, Short i);
	
}
