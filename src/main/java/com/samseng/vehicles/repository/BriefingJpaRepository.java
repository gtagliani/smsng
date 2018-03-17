package com.samseng.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samseng.vehicles.model.Briefing;



@Repository
public interface BriefingJpaRepository extends LogicDeleteJpaRepository<Briefing, Integer> {
	
	public List<Briefing> findFirst50ByShortDescriptionLikeOrderByShortDescription(String filter);

}
