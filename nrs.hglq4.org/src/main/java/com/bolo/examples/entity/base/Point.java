package com.bolo.examples.entity.base;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Point entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "point")
public class Point implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer poiid;
	private String poiaccountName;
	private Integer poivalue;
	private Integer poiaction;
	private String poidescription;
	private Timestamp poicreated;
	private Timestamp poiupdated;
	private Integer poiobjectId;
	private Set<Account> accounts = new HashSet<Account>(0);

	// Constructors

	/** default constructor */
	public Point() {
	}

	/** minimal constructor */
	public Point(Integer poiid) {
		this.poiid = poiid;
	}

	/** full constructor */
	public Point(Integer poiid, String poiaccountName, Integer poivalue,
			Integer poiaction, String poidescription, Timestamp poicreated,
			Timestamp poiupdated, Integer poiobjectId, Set<Account> accounts) {
		this.poiid = poiid;
		this.poiaccountName = poiaccountName;
		this.poivalue = poivalue;
		this.poiaction = poiaction;
		this.poidescription = poidescription;
		this.poicreated = poicreated;
		this.poiupdated = poiupdated;
		this.poiobjectId = poiobjectId;
		this.accounts = accounts;
	}

	// Property accessors
	@Id
	@Column(name = "POIID", unique = true, nullable = false)
	public Integer getPoiid() {
		return this.poiid;
	}

	public void setPoiid(Integer poiid) {
		this.poiid = poiid;
	}

	@Column(name = "POIAccountName", length = 40)
	public String getPoiaccountName() {
		return this.poiaccountName;
	}

	public void setPoiaccountName(String poiaccountName) {
		this.poiaccountName = poiaccountName;
	}

	@Column(name = "POIValue")
	public Integer getPoivalue() {
		return this.poivalue;
	}

	public void setPoivalue(Integer poivalue) {
		this.poivalue = poivalue;
	}

	@Column(name = "POIAction")
	public Integer getPoiaction() {
		return this.poiaction;
	}

	public void setPoiaction(Integer poiaction) {
		this.poiaction = poiaction;
	}

	@Column(name = "POIDescription")
	public String getPoidescription() {
		return this.poidescription;
	}

	public void setPoidescription(String poidescription) {
		this.poidescription = poidescription;
	}

	@Column(name = "POICreated", length = 19)
	public Timestamp getPoicreated() {
		return this.poicreated;
	}

	public void setPoicreated(Timestamp poicreated) {
		this.poicreated = poicreated;
	}

	@Column(name = "POIUpdated", length = 19)
	public Timestamp getPoiupdated() {
		return this.poiupdated;
	}

	public void setPoiupdated(Timestamp poiupdated) {
		this.poiupdated = poiupdated;
	}

	@Column(name = "POIObjectID")
	public Integer getPoiobjectId() {
		return this.poiobjectId;
	}

	public void setPoiobjectId(Integer poiobjectId) {
		this.poiobjectId = poiobjectId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "point")
	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}