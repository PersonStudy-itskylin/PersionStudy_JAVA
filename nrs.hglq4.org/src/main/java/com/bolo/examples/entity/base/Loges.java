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
 * Loges entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "loges")
public class Loges implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer logid;
	private Account account;
	private String logcontent;
	private Timestamp logcreated;
	private String logpage;
	private String logremark;
	private Timestamp logupdated;

	// Constructors

	/** default constructor */
	public Loges() {
	}

	/** minimal constructor */
	public Loges(Integer logid, Account account) {
		this.logid = logid;
		this.account = account;
	}

	/** full constructor */
	public Loges(Integer logid, Account account, String logcontent,
			Timestamp logcreated, String logpage, String logremark,
			Timestamp logupdated) {
		this.logid = logid;
		this.account = account;
		this.logcontent = logcontent;
		this.logcreated = logcreated;
		this.logpage = logpage;
		this.logremark = logremark;
		this.logupdated = logupdated;
	}

	// Property accessors
	@Id
	@Column(name = "LOGID", unique = true, nullable = false)
	public Integer getLogid() {
		return this.logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCID", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "LOGContent", length = 65535)
	public String getLogcontent() {
		return this.logcontent;
	}

	public void setLogcontent(String logcontent) {
		this.logcontent = logcontent;
	}

	@Column(name = "LOGCreated", length = 19)
	public Timestamp getLogcreated() {
		return this.logcreated;
	}

	public void setLogcreated(Timestamp logcreated) {
		this.logcreated = logcreated;
	}

	@Column(name = "LOGPage")
	public String getLogpage() {
		return this.logpage;
	}

	public void setLogpage(String logpage) {
		this.logpage = logpage;
	}

	@Column(name = "LOGRemark", length = 100)
	public String getLogremark() {
		return this.logremark;
	}

	public void setLogremark(String logremark) {
		this.logremark = logremark;
	}

	@Column(name = "LOGUpdated", length = 19)
	public Timestamp getLogupdated() {
		return this.logupdated;
	}

	public void setLogupdated(Timestamp logupdated) {
		this.logupdated = logupdated;
	}

}