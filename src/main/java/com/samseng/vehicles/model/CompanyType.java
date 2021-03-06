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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * CompanyType generated by hbm2java
 */
@Entity
@Table(name = "CompanyType", schema = "dbo", catalog = "smsngvcls")
public class CompanyType extends LogicDelete implements java.io.Serializable {

	private Integer id;
	private String description;
	private short deleted;
	
	@JsonBackReference
	private Set<Company> companies = new HashSet<Company>(0);

	public CompanyType() {
	}

	public CompanyType(String description, short deleted) {
		this.description = description;
		this.deleted = deleted;
	}

	public CompanyType(String description, short deleted, Set<Company> companies) {
		this.description = description;
		this.deleted = deleted;
		this.companies = companies;
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

	@Column(name = "Description", nullable = false,unique = true, length = 50)
	@NotBlank(message = "{companyType.description.blank}")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "deleted", nullable = false)
	public short getDeleted() {
		return this.deleted;
	}

	public void setDeleted(short deleted) {
		this.deleted = deleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companyType")
	public Set<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

}
