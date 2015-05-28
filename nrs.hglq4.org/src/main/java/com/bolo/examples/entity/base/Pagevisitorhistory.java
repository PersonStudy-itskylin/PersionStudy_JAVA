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
 * Pagevisitorhistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pagevisitorhistory")
public class Pagevisitorhistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pvhid;
	private Account account;
	private Integer pvhtype;
	private Timestamp pvhvisitDate;
	private Timestamp pvhlogoutDate;
	private String pvhvisitorIp;
	private String pvhurl;
	private String pvhhttpReferer;
	private Integer pvhclicks;
	private Timestamp pvhonlineTime;
	private String pvhplatform;
	private String pvhbrowser;
	private String pvhscreen;
	private String pvhprovince;
	private String pvhcity;
	private Timestamp pvhcreated;
	private Timestamp pvhupdated;
	private String pvhsearchEngine;
	private String pvhkeyword;
	private String pvhformSite;

	// Constructors

	/** default constructor */
	public Pagevisitorhistory() {
	}

	/** minimal constructor */
	public Pagevisitorhistory(Integer pvhid, Account account) {
		this.pvhid = pvhid;
		this.account = account;
	}

	/** full constructor */
	public Pagevisitorhistory(Integer pvhid, Account account, Integer pvhtype,
			Timestamp pvhvisitDate, Timestamp pvhlogoutDate,
			String pvhvisitorIp, String pvhurl, String pvhhttpReferer,
			Integer pvhclicks, Timestamp pvhonlineTime, String pvhplatform,
			String pvhbrowser, String pvhscreen, String pvhprovince,
			String pvhcity, Timestamp pvhcreated, Timestamp pvhupdated,
			String pvhsearchEngine, String pvhkeyword, String pvhformSite) {
		this.pvhid = pvhid;
		this.account = account;
		this.pvhtype = pvhtype;
		this.pvhvisitDate = pvhvisitDate;
		this.pvhlogoutDate = pvhlogoutDate;
		this.pvhvisitorIp = pvhvisitorIp;
		this.pvhurl = pvhurl;
		this.pvhhttpReferer = pvhhttpReferer;
		this.pvhclicks = pvhclicks;
		this.pvhonlineTime = pvhonlineTime;
		this.pvhplatform = pvhplatform;
		this.pvhbrowser = pvhbrowser;
		this.pvhscreen = pvhscreen;
		this.pvhprovince = pvhprovince;
		this.pvhcity = pvhcity;
		this.pvhcreated = pvhcreated;
		this.pvhupdated = pvhupdated;
		this.pvhsearchEngine = pvhsearchEngine;
		this.pvhkeyword = pvhkeyword;
		this.pvhformSite = pvhformSite;
	}

	// Property accessors
	@Id
	@Column(name = "PVHID", unique = true, nullable = false)
	public Integer getPvhid() {
		return this.pvhid;
	}

	public void setPvhid(Integer pvhid) {
		this.pvhid = pvhid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCID", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "PVHType")
	public Integer getPvhtype() {
		return this.pvhtype;
	}

	public void setPvhtype(Integer pvhtype) {
		this.pvhtype = pvhtype;
	}

	@Column(name = "PVHVisitDate", length = 19)
	public Timestamp getPvhvisitDate() {
		return this.pvhvisitDate;
	}

	public void setPvhvisitDate(Timestamp pvhvisitDate) {
		this.pvhvisitDate = pvhvisitDate;
	}

	@Column(name = "PVHLogoutDate", length = 19)
	public Timestamp getPvhlogoutDate() {
		return this.pvhlogoutDate;
	}

	public void setPvhlogoutDate(Timestamp pvhlogoutDate) {
		this.pvhlogoutDate = pvhlogoutDate;
	}

	@Column(name = "PVHVisitorIP", length = 128)
	public String getPvhvisitorIp() {
		return this.pvhvisitorIp;
	}

	public void setPvhvisitorIp(String pvhvisitorIp) {
		this.pvhvisitorIp = pvhvisitorIp;
	}

	@Column(name = "PVHUrl")
	public String getPvhurl() {
		return this.pvhurl;
	}

	public void setPvhurl(String pvhurl) {
		this.pvhurl = pvhurl;
	}

	@Column(name = "PVHHttpReferer")
	public String getPvhhttpReferer() {
		return this.pvhhttpReferer;
	}

	public void setPvhhttpReferer(String pvhhttpReferer) {
		this.pvhhttpReferer = pvhhttpReferer;
	}

	@Column(name = "PVHClicks")
	public Integer getPvhclicks() {
		return this.pvhclicks;
	}

	public void setPvhclicks(Integer pvhclicks) {
		this.pvhclicks = pvhclicks;
	}

	@Column(name = "PVHOnlineTime", length = 19)
	public Timestamp getPvhonlineTime() {
		return this.pvhonlineTime;
	}

	public void setPvhonlineTime(Timestamp pvhonlineTime) {
		this.pvhonlineTime = pvhonlineTime;
	}

	@Column(name = "PVHPlatform")
	public String getPvhplatform() {
		return this.pvhplatform;
	}

	public void setPvhplatform(String pvhplatform) {
		this.pvhplatform = pvhplatform;
	}

	@Column(name = "PVHBrowser")
	public String getPvhbrowser() {
		return this.pvhbrowser;
	}

	public void setPvhbrowser(String pvhbrowser) {
		this.pvhbrowser = pvhbrowser;
	}

	@Column(name = "PVHScreen", length = 100)
	public String getPvhscreen() {
		return this.pvhscreen;
	}

	public void setPvhscreen(String pvhscreen) {
		this.pvhscreen = pvhscreen;
	}

	@Column(name = "PVHProvince", length = 50)
	public String getPvhprovince() {
		return this.pvhprovince;
	}

	public void setPvhprovince(String pvhprovince) {
		this.pvhprovince = pvhprovince;
	}

	@Column(name = "PVHCIty", length = 50)
	public String getPvhcity() {
		return this.pvhcity;
	}

	public void setPvhcity(String pvhcity) {
		this.pvhcity = pvhcity;
	}

	@Column(name = "PVHCreated", length = 19)
	public Timestamp getPvhcreated() {
		return this.pvhcreated;
	}

	public void setPvhcreated(Timestamp pvhcreated) {
		this.pvhcreated = pvhcreated;
	}

	@Column(name = "PVHUpdated", length = 19)
	public Timestamp getPvhupdated() {
		return this.pvhupdated;
	}

	public void setPvhupdated(Timestamp pvhupdated) {
		this.pvhupdated = pvhupdated;
	}

	@Column(name = "PVHSearchEngine", length = 50)
	public String getPvhsearchEngine() {
		return this.pvhsearchEngine;
	}

	public void setPvhsearchEngine(String pvhsearchEngine) {
		this.pvhsearchEngine = pvhsearchEngine;
	}

	@Column(name = "PVHKeyword")
	public String getPvhkeyword() {
		return this.pvhkeyword;
	}

	public void setPvhkeyword(String pvhkeyword) {
		this.pvhkeyword = pvhkeyword;
	}

	@Column(name = "PVHFormSite")
	public String getPvhformSite() {
		return this.pvhformSite;
	}

	public void setPvhformSite(String pvhformSite) {
		this.pvhformSite = pvhformSite;
	}

}