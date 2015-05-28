package com.bolo.examples.entity.base;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class Role implements java.io.Serializable {

	// Fields

	private Integer rolid;
	private Account account;
	private Menu menu;
	private String roltitle;
	private String roldescription;
	private String rolstate;
	private Integer rolgroupRole;
	private Integer rolroleType;
	private Timestamp rolcreated;
	private Timestamp rolupdated;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(Integer rolid) {
		this.rolid = rolid;
	}

	/** full constructor */
	public Role(Integer rolid, Account account, Menu menu, String roltitle,
			String roldescription, String rolstate, Integer rolgroupRole,
			Integer rolroleType, Timestamp rolcreated, Timestamp rolupdated) {
		this.rolid = rolid;
		this.account = account;
		this.menu = menu;
		this.roltitle = roltitle;
		this.roldescription = roldescription;
		this.rolstate = rolstate;
		this.rolgroupRole = rolgroupRole;
		this.rolroleType = rolroleType;
		this.rolcreated = rolcreated;
		this.rolupdated = rolupdated;
	}

	// Property accessors
	@Id
	@Column(name = "ROLID", unique = true, nullable = false)
	public Integer getRolid() {
		return this.rolid;
	}

	public void setRolid(Integer rolid) {
		this.rolid = rolid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCID")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENID")
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name = "ROLTitle", length = 40)
	public String getRoltitle() {
		return this.roltitle;
	}

	public void setRoltitle(String roltitle) {
		this.roltitle = roltitle;
	}

	@Column(name = "ROLDescription", length = 40)
	public String getRoldescription() {
		return this.roldescription;
	}

	public void setRoldescription(String roldescription) {
		this.roldescription = roldescription;
	}

	@Column(name = "ROLState", length = 40)
	public String getRolstate() {
		return this.rolstate;
	}

	public void setRolstate(String rolstate) {
		this.rolstate = rolstate;
	}

	@Column(name = "ROLGroupRole")
	public Integer getRolgroupRole() {
		return this.rolgroupRole;
	}

	public void setRolgroupRole(Integer rolgroupRole) {
		this.rolgroupRole = rolgroupRole;
	}

	@Column(name = "ROLRoleType")
	public Integer getRolroleType() {
		return this.rolroleType;
	}

	public void setRolroleType(Integer rolroleType) {
		this.rolroleType = rolroleType;
	}

	@Column(name = "ROLCreated", length = 19)
	public Timestamp getRolcreated() {
		return this.rolcreated;
	}

	public void setRolcreated(Timestamp rolcreated) {
		this.rolcreated = rolcreated;
	}

	@Column(name = "ROLUpdated", length = 19)
	public Timestamp getRolupdated() {
		return this.rolupdated;
	}

	public void setRolupdated(Timestamp rolupdated) {
		this.rolupdated = rolupdated;
	}

}