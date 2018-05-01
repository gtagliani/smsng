package com.samseng.vehicles.services;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.select2.dto.Child;
import com.samseng.select2.dto.Result;
import com.samseng.select2.dto.Select2RootStructure;
import com.samseng.vehicles.model.Company;
import com.samseng.vehicles.model.Driver;
import com.samseng.vehicles.repository.CompanyJpaRepository;
import com.samseng.vehicles.repository.DriverJpaRepository;

@Service
public class DriverService extends LogicDeleteAbstractService <Driver,Integer>{

	@Autowired
	DriverJpaRepository repository;
	
	@Autowired
	CompanyJpaRepository companyRepository;
	
	public Select2RootStructure getDrivers(Long companyID) {
		
		Select2RootStructure select2Structure = new Select2RootStructure();
		Result r = new Result();
		r.setText("Driver´s List");
		select2Structure.getResults().add(r);
		
		Company c = companyRepository.findOne(companyID.intValue());
		
		if (c==null) return select2Structure;
		
		List <Driver> drivers = repository.findByCompanyAndDeleted(c,(short)0);		
		drivers
			.stream()
			.forEach(s -> 
				{Child aux = new Child(); 
				aux.setText(s.getName() + " " + s.getDocumentNumber());
				aux.setId(s.getId());
				r.getChildren().add(aux);
				} 
			);
		
		return select2Structure;
		
		
	}
	
}
