package com.samseng.vehicles.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.dto.DTOVehicleCheckin;
import com.samseng.vehicles.dto.DTOVehicleCheckin.Response;
import com.samseng.vehicles.model.VehicleRegistered;
import com.samseng.vehicles.model.VehicleRegisteredCheckList;
import com.samseng.vehicles.repository.SectorJpaRepository;
import com.samseng.vehicles.repository.VehicleJpaRepository;

@Service
public class VehicleCheckinService {
	
	@Autowired
	private VehicleService newVehicle;
	
	@Autowired
	private SectorService sectorService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private BriefingQuestionsService briefingService;
	
	@Autowired
	private VehicleLogService vehicleLogService;
	
	@Autowired
	private VehicleStatesService vehicleStatesService;

	@Transactional
	public boolean registerVehicle(DTOVehicleCheckin vehicleData) {
		
		Date current = new Date();
		
		VehicleRegistered vh = new VehicleRegistered();
		vh.setVehicle(vehicleService.findOne(vehicleData.getVehicle().getId()));
		vh.setSector(sectorService.findOne(vehicleData.getSector().getId()));
		vh.setDateTimestamp(current);
		
		for (Response r : vehicleData.getResponsesList()) {
			
			VehicleRegisteredCheckList vr = new VehicleRegisteredCheckList();
			vr.setVehicleRegistered(vh);
			vr.setBriefingQuestions(briefingService.findOne(r.getId()));
			vr.setPassed(r.getResponse());
			vr.setObservations(r.getDescription());
			
			vh.getVehicleRegisteredCheckLists().add(vr);
		}
		
		vehicleLogService.addLog(vh, vehicleStatesService.getState(VehicleStatesService.States.WAITING));
		
		
		return false;
	}
}
