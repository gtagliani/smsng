package com.samseng.vehicles.model;
// Generated 23/01/2018 19:32:51 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "Users", schema = "dbo", catalog = "smsngvcls")
public class Users implements java.io.Serializable {

	private String username;
	private String password2;
	private Set<Sector> sectors = new HashSet<Sector>(0);
	private Set<Authorities> authoritieses = new HashSet<Authorities>(0);

	public Users() {
	}

	public Users(String username, String password2) {
		this.username = username;
		this.password2 = password2;
	}

	public Users(String username, String password2, Set<Sector> sectors, Set<Authorities> authoritieses) {
		this.username = username;
		this.password2 = password2;
		this.sectors = sectors;
		this.authoritieses = authoritieses;
	}

	@Id

	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password_2", nullable = false, length = 50)
	public String getPassword2() {
		return this.password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Approver", schema = "dbo", catalog = "smsngvcls", joinColumns = {
			@JoinColumn(name = "UsersUsername", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "SectorId", nullable = false, updatable = false) })
	public Set<Sector> getSectors() {
		return this.sectors;
	}

	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(Set<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

}
