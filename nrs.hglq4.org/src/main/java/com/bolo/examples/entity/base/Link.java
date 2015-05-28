package com.bolo.examples.entity.base;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Link entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "link")
public class Link implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer linid;
	private String lintitle;
	private String linurl;
	private Timestamp lincreated;
	private String linthumbnail;
	private String lintag;
	private Integer linorderNumber;
	private Timestamp linupdated;

	// Constructors

	/** default constructor */
	public Link() {
	}

	/** minimal constructor */
	public Link(Integer linid) {
		this.linid = linid;
	}

	/** full constructor */
	public Link(Integer linid, String lintitle, String linurl,
			Timestamp lincreated, String linthumbnail, String lintag,
			Integer linorderNumber, Timestamp linupdated) {
		this.linid = linid;
		this.lintitle = lintitle;
		this.linurl = linurl;
		this.lincreated = lincreated;
		this.linthumbnail = linthumbnail;
		this.lintag = lintag;
		this.linorderNumber = linorderNumber;
		this.linupdated = linupdated;
	}

	// Property accessors
	@Id
	@Column(name = "LINID", unique = true, nullable = false)
	public Integer getLinid() {
		return this.linid;
	}

	public void setLinid(Integer linid) {
		this.linid = linid;
	}

	@Column(name = "LINTitle", length = 65)
	public String getLintitle() {
		return this.lintitle;
	}

	public void setLintitle(String lintitle) {
		this.lintitle = lintitle;
	}

	@Column(name = "LINUrl")
	public String getLinurl() {
		return this.linurl;
	}

	public void setLinurl(String linurl) {
		this.linurl = linurl;
	}

	@Column(name = "LINCreated", length = 19)
	public Timestamp getLincreated() {
		return this.lincreated;
	}

	public void setLincreated(Timestamp lincreated) {
		this.lincreated = lincreated;
	}

	@Column(name = "LINThumbnail")
	public String getLinthumbnail() {
		return this.linthumbnail;
	}

	public void setLinthumbnail(String linthumbnail) {
		this.linthumbnail = linthumbnail;
	}

	@Column(name = "LINTag")
	public String getLintag() {
		return this.lintag;
	}

	public void setLintag(String lintag) {
		this.lintag = lintag;
	}

	@Column(name = "LINOrderNumber")
	public Integer getLinorderNumber() {
		return this.linorderNumber;
	}

	public void setLinorderNumber(Integer linorderNumber) {
		this.linorderNumber = linorderNumber;
	}

	@Column(name = "LINUpdated", length = 19)
	public Timestamp getLinupdated() {
		return this.linupdated;
	}

	public void setLinupdated(Timestamp linupdated) {
		this.linupdated = linupdated;
	}

}