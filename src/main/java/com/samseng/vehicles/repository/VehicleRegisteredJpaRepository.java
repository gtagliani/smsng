package com.samseng.vehicles.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.samseng.vehicles.model.VehicleRegistered;

public interface VehicleRegisteredJpaRepository extends JpaRepository<VehicleRegistered, Integer>{

	List<VehicleRegistered> findAllByVehicleIdOrderByDateTimestampDesc(Integer id);
	
	@Query("select r from VehicleRegistered r, VehicleLog v where v.lastLogRegistered = 1 and v.vehicleStates.id =:state and v.vehicleRegistered = r and r.sector.id = :sector order by v.dateTimestamp asc")
	List<VehicleRegistered> findAllBySectorAndState(@Param("sector") int sector,@Param("state") int state);
}

