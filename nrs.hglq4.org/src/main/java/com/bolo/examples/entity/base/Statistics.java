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
 * Statistics entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "statistics")
public class Statistics implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer staid;
	private Account account;
	private Article article;
	private Channel channel;
	private Timestamp stavisitDate;
	private String staurl;
	private Timestamp stacreated;
	private Timestamp staupdated;

	// Constructors

	/** default constructor */
	public Statistics() {
	}

	/** minimal constructor */
	public Statistics(Integer staid, Account account, Article article,
			Channel channel) {
		this.staid = staid;
		this.account = account;
		this.article = article;
		this.channel = channel;
	}

	/** full constructor */
	public Statistics(Integer staid, Account account, Article article,
			Channel channel, Timestamp stavisitDate, String staurl,
			Timestamp stacreated, Timestamp staupdated) {
		this.staid = staid;
		this.account = account;
		this.article = article;
		this.channel = channel;
		this.stavisitDate = stavisitDate;
		this.staurl = staurl;
		this.stacreated = stacreated;
		this.staupdated = staupdated;
	}

	// Property accessors
	@Id
	@Column(name = "STAID", unique = true, nullable = false)
	public Integer getStaid() {
		return this.staid;
	}

	public void setStaid(Integer staid) {
		this.staid = staid;
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

	@Column(name = "STAVisitDate", length = 19)
	public Timestamp getStavisitDate() {
		return this.stavisitDate;
	}

	public void setStavisitDate(Timestamp stavisitDate) {
		this.stavisitDate = stavisitDate;
	}

	@Column(name = "STAUrl")
	public String getStaurl() {
		return this.staurl;
	}

	public void setStaurl(String staurl) {
		this.staurl = staurl;
	}

	@Column(name = "STACreated", length = 19)
	public Timestamp getStacreated() {
		return this.stacreated;
	}

	public void setStacreated(Timestamp stacreated) {
		this.stacreated = stacreated;
	}

	@Column(name = "STAUpdated", length = 19)
	public Timestamp getStaupdated() {
		return this.staupdated;
	}

	public void setStaupdated(Timestamp staupdated) {
		this.staupdated = staupdated;
	}

}