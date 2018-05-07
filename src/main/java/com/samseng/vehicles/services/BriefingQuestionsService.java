package com.samseng.vehicles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samseng.vehicles.model.Briefing;
import com.samseng.vehicles.model.BriefingQuestions;
import com.samseng.vehicles.repository.BriefingJpaRepository;
import com.samseng.vehicles.repository.BriefingQuestionsJpaRepository;

@Service
public class BriefingQuestionsService extends LogicDeleteAbstractService <BriefingQuestions,Integer>{
	
	@Autowired
	BriefingQuestionsJpaRepository repository;
	
	@Autowired
	BriefingJpaRepository briefingRepository;
	
	public List <BriefingQuestions> findByBriefingID(Integer id){
		Briefing b = briefingRepository.findOne(id);
		return repository.findByBriefingAndDeleted(b,(short)0);
	}
}
