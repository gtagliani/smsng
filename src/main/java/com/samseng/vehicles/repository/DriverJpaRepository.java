package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.CompanyType;



@Repository
public interface DriverJpaRepository extends LogicDeleteJpaRepository<CompanyType, Integer> {
	
	public List<CompanyType> findFirst50ByDescriptionLikeOrderByDescription(String filter);

}
