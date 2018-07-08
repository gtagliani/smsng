package com.samseng.vehicles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.model.VehicleRegisteredCheckList;
import com.samseng.vehicles.model.VehicleRegisteredCheckListId;
import com.samseng.vehicles.repository.VehicleRegisteredCheckListJpaRepository;

@Service
public class VehicleRegisteredCheckListService {
	
	@Autowired
	VehicleRegisteredCheckListJpaRepository vehicleRegisteredCheckListService;
	
	
	public void save(VehicleRegisteredCheckList entity){
		
		VehicleRegisteredCheckListId id = 
				new VehicleRegisteredCheckListId(entity.getVehicleRegistered().getId(),
						entity.getBriefingQuestions().getId());
		entity.setId(id);
		
		vehicleRegisteredCheckListService.save(entity);
	}

}
