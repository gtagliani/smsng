package com.samseng.vehicles.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract class  AbstractService <T,ID extends Serializable> {
	
	@Autowired
    private JpaRepository<T, ID> repository;
	
	public List<T> findAll() {
        return repository.findAll();
    }
     
    public  T findOne(ID id) {
        return repository.findOne(id);
    }
     
    public T save(T obj) {
        return repository.saveAndFlush(obj);
    }
     
    public void delete(ID id) {
        repository.delete(id);
    }
    
}
