package com.bolo.examples.entity.base;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Form entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "form")
public class Form implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer forid;
	private String fortypeName;
	private String fortitle;
	private Timestamp forcreated;
	private Timestamp forupdated;
	private String forremark;

	// Constructors

	/** default constructor */
	public Form() {
	}

	/** minimal constructor */
	public Form(Integer forid) {
		this.forid = forid;
	}

	/** full constructor */
	public Form(Integer forid, String fortypeName, String fortitle,
			Timestamp forcreated, Timestamp forupdated, String forremark) {
		this.forid = forid;
		this.fortypeName = fortypeName;
		this.fortitle = fortitle;
		this.forcreated = forcreated;
		this.forupdated = forupdated;
		this.forremark = forremark;
	}

	// Property accessors
	@Id
	@Column(name = "FORID", unique = true, nullable = false)
	public Integer getForid() {
		return this.forid;
	}

	public void setForid(Integer forid) {
		this.forid = forid;
	}

	@Column(name = "FORTypeName")
	public String getFortypeName() {
		return this.fortypeName;
	}

	public void setFortypeName(String fortypeName) {
		this.fortypeName = fortypeName;
	}

	@Column(name = "FORTitle", length = 128)
	public String getFortitle() {
		return this.fortitle;
	}

	public void setFortitle(String fortitle) {
		this.fortitle = fortitle;
	}

	@Column(name = "FORCreated", length = 19)
	public Timestamp getForcreated() {
		return this.forcreated;
	}

	public void setForcreated(Timestamp forcreated) {
		this.forcreated = forcreated;
	}

	@Column(name = "FORUpdated", length = 19)
	public Timestamp getForupdated() {
		return this.forupdated;
	}

	public void setForupdated(Timestamp forupdated) {
		this.forupdated = forupdated;
	}

	@Column(name = "FORRemark")
	public String getForremark() {
		return this.forremark;
	}

	public void setForremark(String forremark) {
		this.forremark = forremark;
	}

}