package com.samseng.vehicles.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samseng.vehicles.dto.DTOVehicleCheckin;
import com.samseng.vehicles.editors.VehicleCheckinEditor;
import com.samseng.vehicles.model.Driver;
import com.samseng.vehicles.model.Vehicle;
import com.samseng.vehicles.model.VehicleRegistered;
import com.samseng.vehicles.services.DriverService;
import com.samseng.vehicles.services.EventObserverJob;
import com.samseng.vehicles.services.VehicleCheckinService;
import com.samseng.vehicles.services.VehicleService;
import com.samseng.vehicles.sse.EventInfo;

@Controller
public class VehicleCheckInController {
	
	static Logger log = Logger.getLogger(VehicleCheckInController.class.getName());
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	EventObserverJob eventService;
	
	@Autowired
	VehicleCheckinService checkinService;
	
	@GetMapping("vehiclecheckin/isvehicleregistered/{vehicleId}")
	@ResponseBody
	Boolean isVehicleRegistered(@PathVariable("vehicleId") String vehicleId) {
		return !vehicleService.findByVehicleIdAndNotDeleted(vehicleId).isEmpty();
	}
	
	
	@GetMapping("vehiclecheckin")
	String mainForm() {
		return "vehiclecheckin";
	}
	
	@GetMapping("vehiclecheckin/getvehicle/{vehicleId}")
	@ResponseBody
	List<Vehicle> getVehicle(@PathVariable("vehicleId") String vehicleId) {
		List<Vehicle> aux = vehicleService.findByVehicleIdAndNotDeleted(vehicleId);
		
		return aux;
	}
	
//	@InitBinder()
//    public void initBinder(WebDataBinder binder) {
//	  log.info("initBinder!!");
//      binder.registerCustomEditor(DTOVehicleCheckin.class,"vehicleIn", new VehicleCheckinEditor());
//    }
	
//	@RequestMapping(value = "vehiclecheckin/save", method = RequestMethod.POST)
//	@ResponseBody
//	Boolean mainForm(@ModelAttribute("vehicleIn") DTOVehicleCheckin vehicleIn,
//            BindingResult result) {
//		Object o = result.getPropertyEditorRegistry();
//		java.util.Map<java.lang.String,java.lang.Object> m = result.getModel();
//		for (String k: m.keySet()) {
//			log.info("K:" + k + " V: " + m.get(k));
//		}
//		Object ooo = result.getRawFieldValue("responses");
//		return true;
//	}
	
	@RequestMapping(value = "vehiclecheckin/save", method = RequestMethod.POST)
	@ResponseBody
	String mainForm( DTOVehicleCheckin vehicleIn) {
		
		String ret = checkinService.registerVehicle(vehicleIn);
		
		if (ret == null) {
			
			EventInfo ei = new EventInfo(EventObserverJob.NotifyTypes.info.toString(), "El vehiculo con chapa " +vehicleIn.getVehicle().getVehicleId() + " se ha presentado al ingreso de planta.");
			eventService.notify(ei);
			ret = "true";
		}
		
		return ret;
	}
	
	
	@GetMapping("vehiclecheckin/test")
	@ResponseBody
	DTOVehicleCheckin test(VehicleRegistered vehicleIn) {
		DTOVehicleCheckin t =  new DTOVehicleCheckin();
		
		Driver d = new Driver();
		d.setId(1001);
		
		Driver d2 = new Driver();
		d2.setId(1001);
		
		t.getDrivers().add(d);
		t.getDrivers().add(d2);
		
		DTOVehicleCheckin.Response r1 = new DTOVehicleCheckin.Response();
		r1.setId(1);
		r1.setDescription("d1");
		r1.setResponse((short)0);
		
		DTOVehicleCheckin.Response r2 = new DTOVehicleCheckin.Response();
		r2.setId(2);
		r2.setDescription("d2");
		r2.setResponse((short)2);
		
		Set<DTOVehicleCheckin.Response> responses = new HashSet<DTOVehicleCheckin.Response>();
		t.setResponses("Nothing at all");
		
		responses.add(r1);
		responses.add(r2);
		
		return t;
	}

}
