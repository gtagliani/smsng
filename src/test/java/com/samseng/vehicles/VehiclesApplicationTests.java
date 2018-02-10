package com.samseng.vehicles;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.samseng.vehicles.model.VehicleStates;
import com.samseng.vehicles.repository.VehicleStatesJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration
public class VehiclesApplicationTests {
	
	@Autowired
	VehicleStatesJpaRepository vehicleStatesRepo;

//	@Test
//	public void contextLoads() {
//		
//	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void saveVehicleState(){
		VehicleStates vs = new VehicleStates();
		
		vs.setState("hello!");
		
		vehicleStatesRepo.saveAndFlush(vs);
		
	
	}

}
