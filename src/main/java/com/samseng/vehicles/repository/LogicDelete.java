package com.samseng.vehicles.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogicDelete<T>{
	
	public List<T> findByDeleted(Short deleted);

}
