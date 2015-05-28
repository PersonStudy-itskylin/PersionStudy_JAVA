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
 * Pagevisitor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pagevisitor")
public class Pagevisitor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pavid;
	private Account account;
	private Timestamp pavvisitDate;
	private Timestamp pavlogoutDate;
	private String pavvisitorIp;
	private String pavurl;
	private String pavhttpReferer;
	private Integer pavclicks;
	private Timestamp pavonlineTime;
	private String pavplatform;
	private String pavbrowser;
	private String pavscreen;
	private String pavprovince;
	private String pavcity;
	private Timestamp pavcreated;
	private Timestamp pavupdated;
	private String pavsearchEngine;
	private String pavkeyword;
	private String pavfromSite;

	// Constructors

	/** default constructor */
	public Pagevisitor() {
	}

	/** minimal constructor */
	public Pagevisitor(Integer pavid, Account account) {
		this.pavid = pavid;
		this.account = account;
	}

	/** full constructor */
	public Pagevisitor(Integer pavid, Account account, Timestamp pavvisitDate,
			Timestamp pavlogoutDate, String pavvisitorIp, String pavurl,
			String pavhttpReferer, Integer pavclicks, Timestamp pavonlineTime,
			String pavplatform, String pavbrowser, String pavscreen,
			String pavprovince, String pavcity, Timestamp pavcreated,
			Timestamp pavupdated, String pavsearchEngine, String pavkeyword,
			String pavfromSite) {
		this.pavid = pavid;
		this.account = account;
		this.pavvisitDate = pavvisitDate;
		this.pavlogoutDate = pavlogoutDate;
		this.pavvisitorIp = pavvisitorIp;
		this.pavurl = pavurl;
		this.pavhttpReferer = pavhttpReferer;
		this.pavclicks = pavclicks;
		this.pavonlineTime = pavonlineTime;
		this.pavplatform = pavplatform;
		this.pavbrowser = pavbrowser;
		this.pavscreen = pavscreen;
		this.pavprovince = pavprovince;
		this.pavcity = pavcity;
		this.pavcreated = pavcreated;
		this.pavupdated = pavupdated;
		this.pavsearchEngine = pavsearchEngine;
		this.pavkeyword = pavkeyword;
		this.pavfromSite = pavfromSite;
	}

	// Property accessors
	@Id
	@Column(name = "PAVID", unique = true, nullable = false)
	public Integer getPavid() {
		return this.pavid;
	}

	public void setPavid(Integer pavid) {
		this.pavid = pavid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCID", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "PAVVisitDate", length = 19)
	public Timestamp getPavvisitDate() {
		return this.pavvisitDate;
	}

	public void setPavvisitDate(Timestamp pavvisitDate) {
		this.pavvisitDate = pavvisitDate;
	}

	@Column(name = "PAVLogoutDate", length = 19)
	public Timestamp getPavlogoutDate() {
		return this.pavlogoutDate;
	}

	public void setPavlogoutDate(Timestamp pavlogoutDate) {
		this.pavlogoutDate = pavlogoutDate;
	}

	@Column(name = "PAVVisitorIp", length = 128)
	public String getPavvisitorIp() {
		return this.pavvisitorIp;
	}

	public void setPavvisitorIp(String pavvisitorIp) {
		this.pavvisitorIp = pavvisitorIp;
	}

	@Column(name = "PAVUrl")
	public String getPavurl() {
		return this.pavurl;
	}

	public void setPavurl(String pavurl) {
		this.pavurl = pavurl;
	}

	@Column(name = "PAVHttpReferer")
	public String getPavhttpReferer() {
		return this.pavhttpReferer;
	}

	public void setPavhttpReferer(String pavhttpReferer) {
		this.pavhttpReferer = pavhttpReferer;
	}

	@Column(name = "PAVClicks")
	public Integer getPavclicks() {
		return this.pavclicks;
	}

	public void setPavclicks(Integer pavclicks) {
		this.pavclicks = pavclicks;
	}

	@Column(name = "PAVOnlineTime", length = 19)
	public Timestamp getPavonlineTime() {
		return this.pavonlineTime;
	}

	public void setPavonlineTime(Timestamp pavonlineTime) {
		this.pavonlineTime = pavonlineTime;
	}

	@Column(name = "PAVPlatform")
	public String getPavplatform() {
		return this.pavplatform;
	}

	public void setPavplatform(String pavplatform) {
		this.pavplatform = pavplatform;
	}

	@Column(name = "PAVBrowser")
	public String getPavbrowser() {
		return this.pavbrowser;
	}

	public void setPavbrowser(String pavbrowser) {
		this.pavbrowser = pavbrowser;
	}

	@Column(name = "PAVScreen")
	public String getPavscreen() {
		return this.pavscreen;
	}

	public void setPavscreen(String pavscreen) {
		this.pavscreen = pavscreen;
	}

	@Column(name = "PAVProvince", length = 50)
	public String getPavprovince() {
		return this.pavprovince;
	}

	public void setPavprovince(String pavprovince) {
		this.pavprovince = pavprovince;
	}

	@Column(name = "PAVCity", length = 50)
	public String getPavcity() {
		return this.pavcity;
	}

	public void setPavcity(String pavcity) {
		this.pavcity = pavcity;
	}

	@Column(name = "PAVCreated", length = 19)
	public Timestamp getPavcreated() {
		return this.pavcreated;
	}

	public void setPavcreated(Timestamp pavcreated) {
		this.pavcreated = pavcreated;
	}

	@Column(name = "PAVUpdated", length = 19)
	public Timestamp getPavupdated() {
		return this.pavupdated;
	}

	public void setPavupdated(Timestamp pavupdated) {
		this.pavupdated = pavupdated;
	}

	@Column(name = "PAVSearchEngine", length = 50)
	public String getPavsearchEngine() {
		return this.pavsearchEngine;
	}

	public void setPavsearchEngine(String pavsearchEngine) {
		this.pavsearchEngine = pavsearchEngine;
	}

	@Column(name = "PAVKeyword")
	public String getPavkeyword() {
		return this.pavkeyword;
	}

	public void setPavkeyword(String pavkeyword) {
		this.pavkeyword = pavkeyword;
	}

	@Column(name = "PAVFromSite")
	public String getPavfromSite() {
		return this.pavfromSite;
	}

	public void setPavfromSite(String pavfromSite) {
		this.pavfromSite = pavfromSite;
	}

}