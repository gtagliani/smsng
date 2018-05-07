package com.samseng.vehicles.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.Briefing;
import com.samseng.vehicles.model.BriefingQuestions;
import com.samseng.vehicles.model.CompanyType;



@Repository
public interface BriefingQuestionsJpaRepository extends LogicDeleteJpaRepository<BriefingQuestions, Integer> {

	List<BriefingQuestions> findByBriefingAndDeleted(Briefing b, short s);
	
}
