package com.samseng.vehicles.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.controller.CompanyTypeController;
import com.samseng.vehicles.dto.DTOVehicleCheckin;
import com.samseng.vehicles.dto.DTOVehicleCheckin.Response;
import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.model.VehicleRegistered;
import com.samseng.vehicles.model.VehicleRegisteredCheckList;
import com.samseng.vehicles.repository.SectorJpaRepository;
import com.samseng.vehicles.repository.VehicleJpaRepository;
import com.samseng.vehicles.sse.EventInfo;

@Service
public class VehicleCheckinService {
	
	static Logger log = Logger.getLogger(VehicleCheckinService.class.getName());
	
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
	
	@Autowired
	private VehicleRegisteredService vehicleRegisteredService;
	
	@Autowired
	private VehicleRegisteredCheckListService vehicleRegisteredCheckListService;
	
	@Autowired
	EventObserverJob eventService;

	@Transactional
	public String registerVehicle(DTOVehicleCheckin vehicleData) {
		
		try {
		Date current = new Date();
		Vehicle vehicle = vehicleService.findOne(vehicleData.getVehicle().getId());
		
		if (vehicleLogService.existsVehicleRegistered(vehicle))
			return "El vehiculo ya se encuentra registrado.";
		
		
		VehicleRegistered vh = new VehicleRegistered();
		vh.setVehicle(vehicle);
		vh.setSector(sectorService.findOne(vehicleData.getSector().getId()));
		vh.setDateTimestamp(current);
		
		vh.setDrivers(vehicleData.getDrivers());
		
		vehicleRegisteredService.save(vh);
		
		for (Response r : vehicleData.getResponsesList()) {
			
			VehicleRegisteredCheckList vr = new VehicleRegisteredCheckList();
			vr.setVehicleRegistered(vh);
			vr.setBriefingQuestions(briefingService.findOne(r.getId()));
			vr.setPassed(r.getResponse());
			vr.setObservations(r.getDescription());
			
			vehicleRegisteredCheckListService.save(vr);
			
			vh.getVehicleRegisteredCheckLists().add(vr);
			
		}
		
		vehicleLogService.addLog(vh, vehicleStatesService.getState(VehicleStatesService.States.WAITING));
		

		
		return null;
		
		} catch (Exception e) {
			log.error(e);
			return  e.getMessage();
			
		}
		
		
	}
}
