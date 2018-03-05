package com.samseng.vehicles.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.samseng.vehicles.model.LogicDelete;
import com.samseng.vehicles.repository.LogicDeleteJpaRepository;



public abstract class  LogicDeleteAbstractService <T extends LogicDelete ,ID extends Serializable> {
	
	@Autowired
    private LogicDeleteJpaRepository<T, ID> repository;
	
	public List<T> findAllNotDeleted(){ 
        return repository.findByDeleted((short) 0);
        
    }
	
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
    
    public void toggleDelete(ID id) {
        T aux = repository.getOne(id);
        
        aux.setDeleted((short)(aux.getDeleted()>0?0:1));
        save(aux);
    }
    
}
