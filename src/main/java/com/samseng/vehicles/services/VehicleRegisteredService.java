package com.samseng.vehicles.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.dto.WaitingForDTO;
import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.model.VehicleLog;
import com.samseng.vehicles.model.VehicleRegistered;

import com.samseng.vehicles.repository.VehicleRegisteredJpaRepository;

@Service
public class VehicleRegisteredService {

	@Autowired
	VehicleRegisteredJpaRepository repository;
	
	@Autowired
	VehicleStatesService statesService;
	
	public void save (VehicleRegistered vehicle) {
		repository.saveAndFlush(vehicle);
	}
	
	public VehicleRegistered getLastTimeVehicleWasRegistered(Vehicle vehicle){
		
		java.util.List<VehicleRegistered> aux = repository.findAllByVehicleIdOrderByDateTimestampDesc(vehicle.getId());
		if (aux.isEmpty()){
			return null;
		}
		
		return aux.get(0);
	}
	
	public List<WaitingForDTO> getVehiclesWaitingForSector(Integer sector) {
		List<WaitingForDTO> ret = new LinkedList();
		repository.findAllBySectorAndState(sector.intValue(),VehicleStatesService.States.WAITING.id.intValue()).forEach(val -> 
		{
			String state = "???";
			Set<VehicleLog> vl = val.getVehicleLogs();
			for (VehicleLog v : vl)
			{
				if (v.getLastLogRegistered() == 1)
					state = v.getVehicleStates().getState();
			};
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			WaitingForDTO aux = new WaitingForDTO(val.getId(),
					sdf.format(val.getDateTimestamp()),
					val.getVehicle().getCompany().getName(),
					val.getVehicle().getVehicleId(),
					val.getVehicle().getVehicleType().getDescription(),
					val.getSector().getDescription(),
					state,null
					//val.getVehicleLogs().get().getVehicleStates().getState()
					);
			
			ret.add(aux);
			
			val.getVehicleRegisteredCheckLists().forEach(v->{
				
				String q = v.getBriefingQuestions().getQuestion();
				String r = v.getObservations();
				Boolean p = v.getPassed()==(short)1? true : false;
				
				WaitingForDTO.ResponsesInfo ri = new WaitingForDTO.ResponsesInfo(q,p,r);
				aux.getRsponses().add(ri);
			});
			
		});
		
		return ret;
	}
}
