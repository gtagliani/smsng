package com.samseng.vehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samseng.vehicles.model.VehicleRegisteredCheckList;
import com.samseng.vehicles.model.VehicleRegisteredCheckListId;

public interface VehicleRegisteredCheckListJpaRepository  extends JpaRepository<VehicleRegisteredCheckList, VehicleRegisteredCheckListId>{

}
