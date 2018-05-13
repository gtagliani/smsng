package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.CompanyType;
import com.samseng.vehicles.model.Sector;



@Repository
public interface SectorJpaRepository extends LogicDeleteJpaRepository<Sector, Integer> {
	
}
