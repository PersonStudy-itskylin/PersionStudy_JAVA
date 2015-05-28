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
 * Statisticshistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "statisticshistory")
public class Statisticshistory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sthid;
	private Account account;
	private Article article;
	private Channel channel;
	private Timestamp sthvisitDate;
	private String sthurl;
	private Timestamp sthcreated;
	private Timestamp sthupdated;

	// Constructors

	/** default constructor */
	public Statisticshistory() {
	}

	/** minimal constructor */
	public Statisticshistory(Integer sthid, Account account, Article article,
			Channel channel) {
		this.sthid = sthid;
		this.account = account;
		this.article = article;
		this.channel = channel;
	}

	/** full constructor */
	public Statisticshistory(Integer sthid, Account account, Article article,
			Channel channel, Timestamp sthvisitDate, String sthurl,
			Timestamp sthcreated, Timestamp sthupdated) {
		this.sthid = sthid;
		this.account = account;
		this.article = article;
		this.channel = channel;
		this.sthvisitDate = sthvisitDate;
		this.sthurl = sthurl;
		this.sthcreated = sthcreated;
		this.sthupdated = sthupdated;
	}

	// Property accessors
	@Id
	@Column(name = "STHID", unique = true, nullable = false)
	public Integer getSthid() {
		return this.sthid;
	}

	public void setSthid(Integer sthid) {
		this.sthid = sthid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCID", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTId", nullable = false)
	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHAId", nullable = false)
	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Column(name = "STHVisitDate", length = 19)
	public Timestamp getSthvisitDate() {
		return this.sthvisitDate;
	}

	public void setSthvisitDate(Timestamp sthvisitDate) {
		this.sthvisitDate = sthvisitDate;
	}

	@Column(name = "STHUrl")
	public String getSthurl() {
		return this.sthurl;
	}

	public void setSthurl(String sthurl) {
		this.sthurl = sthurl;
	}

	@Column(name = "STHCreated", length = 19)
	public Timestamp getSthcreated() {
		return this.sthcreated;
	}

	public void setSthcreated(Timestamp sthcreated) {
		this.sthcreated = sthcreated;
	}

	@Column(name = "STHUpdated", length = 19)
	public Timestamp getSthupdated() {
		return this.sthupdated;
	}

	public void setSthupdated(Timestamp sthupdated) {
		this.sthupdated = sthupdated;
	}

}