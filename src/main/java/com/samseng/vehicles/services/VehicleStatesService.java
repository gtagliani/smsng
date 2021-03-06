package com.samseng.vehicles.services;

import java.util.HashSet;
import java.util.Set;

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
	
	public Set<VehicleStates> getFinalStates()
	{
		Set<VehicleStates> terminalStates = new HashSet <VehicleStates>(); 
		terminalStates.add(getState(States.UNAUTHORIZED));
		terminalStates.add(getState(States.OUT_PLANT));
		
		return terminalStates;
	}
	
	public Set<Integer> getFinalStatesAsInteger()
	{
		Set<Integer> terminalStates = new HashSet <Integer>(); 
		terminalStates.add(States.UNAUTHORIZED.id);
		terminalStates.add(States.OUT_PLANT.id);
		
		return terminalStates;
	}
	
}
