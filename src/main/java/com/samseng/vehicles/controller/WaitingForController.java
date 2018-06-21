package com.samseng.vehicles.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.samseng.vehicles.dto.WaitingForDTO;
import com.samseng.vehicles.model.CompanyType;
import com.samseng.vehicles.model.Sector;
import com.samseng.vehicles.services.SectorService;
import com.samseng.vehicles.services.VehicleRegisteredService;

@Controller
public class WaitingForController {
	
	@Autowired
	VehicleRegisteredService vehicleRegisteredLogService;
	
	@Autowired
	SectorService sectorService;
	
	static Logger log = Logger.getLogger(WaitingForController.class.getName());

	final String ROOT_MAPPING = "/waitingfor/{sector}";
	final String ROOT_NAME = "waitingfor";
	private static final String ENTITY_RECORDS ="entityRecords";
	
	@GetMapping(ROOT_MAPPING)
    public String findAll(Model model, @PathVariable("sector")Integer sector) {
		log.info(" waitingfor type controller");
		Sector s = sectorService.findOne(sector);
		List<WaitingForDTO> aux = vehicleRegisteredLogService.getVehiclesWaitingForSector(sector);
		model.addAttribute(ENTITY_RECORDS, aux);
		model.addAttribute("rootName", ROOT_NAME);
		model.addAttribute("sector", sector);
		model.addAttribute("sectorName", s.getDescription());
		
		return ROOT_NAME;
	}
}
