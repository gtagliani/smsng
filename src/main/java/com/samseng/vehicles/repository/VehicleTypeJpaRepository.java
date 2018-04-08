package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.VehicleType;



@Repository
public interface VehicleTypeJpaRepository extends LogicDeleteJpaRepository<VehicleType, Integer> {
	
	public List<VehicleType> findFirst50ByDescriptionLikeOrderByDescription(String filter);

}
