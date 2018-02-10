package com.samseng.vehicles.model;
// Generated 23/01/2018 19:32:51 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vehicle generated by hbm2java
 */
@Entity
@Table(name = "Vehicle", schema = "dbo", catalog = "smsngvcls")
public class Vehicle implements java.io.Serializable {

	private int id;
	private Company company;
	private VehicleType vehicleType;
	private String vehicleId;
	private String trailerId;
	private Short needAutorization;
	private short permissionDenegated;
	private Set<VehicleRegistered> vehicleRegistereds = new HashSet<VehicleRegistered>(0);

	public Vehicle() {
	}

	public Vehicle(int id, Company company, VehicleType vehicleType, String vehicleId, short permissionDenegated) {
		this.id = id;
		this.company = company;
		this.vehicleType = vehicleType;
		this.vehicleId = vehicleId;
		this.permissionDenegated = permissionDenegated;
	}

	public Vehicle(int id, Company company, VehicleType vehicleType, String vehicleId, String trailerId,
			Short needAutorization, short permissionDenegated, Set<VehicleRegistered> vehicleRegistereds) {
		this.id = id;
		this.company = company;
		this.vehicleType = vehicleType;
		this.vehicleId = vehicleId;
		this.trailerId = trailerId;
		this.needAutorization = needAutorization;
		this.permissionDenegated = permissionDenegated;
		this.vehicleRegistereds = vehicleRegistereds;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CompanyId", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VehicleTypeId", nullable = false)
	public VehicleType getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Column(name = "vehicleId", nullable = false, length = 15)
	public String getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "trailerId", length = 15)
	public String getTrailerId() {
		return this.trailerId;
	}

	public void setTrailerId(String trailerId) {
		this.trailerId = trailerId;
	}

	@Column(name = "needAutorization")
	public Short getNeedAutorization() {
		return this.needAutorization;
	}

	public void setNeedAutorization(Short needAutorization) {
		this.needAutorization = needAutorization;
	}

	@Column(name = "permissionDenegated", nullable = false)
	public short getPermissionDenegated() {
		return this.permissionDenegated;
	}

	public void setPermissionDenegated(short permissionDenegated) {
		this.permissionDenegated = permissionDenegated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
	public Set<VehicleRegistered> getVehicleRegistereds() {
		return this.vehicleRegistereds;
	}

	public void setVehicleRegistereds(Set<VehicleRegistered> vehicleRegistereds) {
		this.vehicleRegistereds = vehicleRegistereds;
	}

}
