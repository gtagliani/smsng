package com.samseng.vehicles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.select2.dto.Child;
import com.samseng.select2.dto.Result;
import com.samseng.select2.dto.Select2RootStructure;
import com.samseng.vehicles.model.Company;
import com.samseng.vehicles.model.CompanyType;
import com.samseng.vehicles.model.Driver;
import com.samseng.vehicles.model.Sector;
import com.samseng.vehicles.repository.SectorJpaRepository;

@Service
public class SectorService extends LogicDeleteAbstractService <Sector,Integer>{

	@Autowired
	SectorJpaRepository sectorRepository;
	
	public Select2RootStructure getSectors() {
		Select2RootStructure select2Structure = new Select2RootStructure();
		Result r = new Result();
		r.setText("Sectors´s List");
		select2Structure.getResults().add(r);
		
		List <Sector> sectors = sectorRepository.findByDeleted((short)0);		
		sectors
			.stream()
			.forEach(s -> 
				{Child aux = new Child(); 
				aux.setText(s.getDescription());
				aux.setId(s.getId());
				r.getChildren().add(aux);
				} 
			);
		
		return select2Structure;
		
	}
	
}
