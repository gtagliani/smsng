package com.samseng.vehicles.model;
// Generated 23/01/2018 19:32:51 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * BriefingQuestions generated by hbm2java
 */
@Entity
@Table(name = "BriefingQuestions", schema = "dbo", catalog = "smsngvcls")
public class BriefingQuestions extends LogicDelete implements java.io.Serializable {

	private Integer id;
	private Briefing briefing;
	private String question;
	private short deleted;
	@JsonBackReference private Set<VehicleRegisteredCheckList> vehicleRegisteredCheckLists = new HashSet<VehicleRegisteredCheckList>(0);

	public BriefingQuestions() {
	}

	public BriefingQuestions(Briefing briefing, String question, short deleted) {
		this.briefing = briefing;
		this.question = question;
		this.deleted = deleted;
	}

	public BriefingQuestions(Briefing briefing, String question, short deleted,
			Set<VehicleRegisteredCheckList> vehicleRegisteredCheckLists) {
		this.briefing = briefing;
		this.question = question;
		this.deleted = deleted;
		this.vehicleRegisteredCheckLists = vehicleRegisteredCheckLists;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BriefingsId", nullable = false)
	public Briefing getBriefing() {
		return this.briefing;
	}

	public void setBriefing(Briefing briefing) {
		this.briefing = briefing;
	}

	@Column(name = "question", nullable = false, length = 150)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "deleted", nullable = false)
	public short getDeleted() {
		return this.deleted;
	}

	public void setDeleted(short deleted) {
		this.deleted = deleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "briefingQuestions")
	public Set<VehicleRegisteredCheckList> getVehicleRegisteredCheckLists() {
		return this.vehicleRegisteredCheckLists;
	}

	public void setVehicleRegisteredCheckLists(Set<VehicleRegisteredCheckList> vehicleRegisteredCheckLists) {
		this.vehicleRegisteredCheckLists = vehicleRegisteredCheckLists;
	}

}
