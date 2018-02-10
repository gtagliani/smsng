package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samseng.vehicles.model.CompanyType;



public interface CompanyTypeJpaRepository extends JpaRepository<CompanyType, Integer> {
	
	public List<CompanyType> findFirst50ByDescriptionLikeOrderByDescription(String filter);

}
