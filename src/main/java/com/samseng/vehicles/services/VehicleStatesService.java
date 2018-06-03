package com.samseng.vehicles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.model.VehicleStates;
import com.samseng.vehicles.repository.VehicleLogJpaRepository;
import com.samseng.vehicles.repository.VehicleStatesJpaRepository;


@Service
public class VehicleStatesService {
	
	@Autowired
	VehicleStatesJpaRepository statesRepository;
		
	public static enum States {
		WAITING(1),			// -- INITIAL --
		AUTHORIZED(2), 		//from 1
		UNAUTHORIZED(3),	//from 1 -- FINAL ---
		IN_PLANT(4),		//from 2
		OUT_PLANT(5);		//from 4 -- FINAL ---
		
		Integer id;
		States(Integer val){
			this.id = val;
		}
	}

	public VehicleStates getState(States s) {
		return statesRepository.findOne(s.id);
		
	}
}
