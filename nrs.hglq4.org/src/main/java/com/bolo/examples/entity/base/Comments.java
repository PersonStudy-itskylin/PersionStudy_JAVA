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
 * Comments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comments")
public class Comments implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer comid;
	private Article article;
	private String comauthor;
	private String comcontent;
	private Integer comstate;
	private Integer comsequnceIndex;
	private Timestamp comcreated;
	private Timestamp comupdated;
	private String comip;
	private String comarticleName;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(Integer comid, Article article) {
		this.comid = comid;
		this.article = article;
	}

	/** full constructor */
	public Comments(Integer comid, Article article, String comauthor,
			String comcontent, Integer comstate, Integer comsequnceIndex,
			Timestamp comcreated, Timestamp comupdated, String comip,
			String comarticleName) {
		this.comid = comid;
		this.article = article;
		this.comauthor = comauthor;
		this.comcontent = comcontent;
		this.comstate = comstate;
		this.comsequnceIndex = comsequnceIndex;
		this.comcreated = comcreated;
		this.comupdated = comupdated;
		this.comip = comip;
		this.comarticleName = comarticleName;
	}

	// Property accessors
	@Id
	@Column(name = "COMId", unique = true, nullable = false)
	public Integer getComid() {
		return this.comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTId", nullable = false)
	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "COMAuthor", length = 64)
	public String getComauthor() {
		return this.comauthor;
	}

	public void setComauthor(String comauthor) {
		this.comauthor = comauthor;
	}

	@Column(name = "COMContent", length = 65535)
	public String getComcontent() {
		return this.comcontent;
	}

	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}

	@Column(name = "COMState")
	public Integer getComstate() {
		return this.comstate;
	}

	public void setComstate(Integer comstate) {
		this.comstate = comstate;
	}

	@Column(name = "COMSequnceIndex")
	public Integer getComsequnceIndex() {
		return this.comsequnceIndex;
	}

	public void setComsequnceIndex(Integer comsequnceIndex) {
		this.comsequnceIndex = comsequnceIndex;
	}

	@Column(name = "COMCreated", length = 19)
	public Timestamp getComcreated() {
		return this.comcreated;
	}

	public void setComcreated(Timestamp comcreated) {
		this.comcreated = comcreated;
	}

	@Column(name = "COMUpdated", length = 19)
	public Timestamp getComupdated() {
		return this.comupdated;
	}

	public void setComupdated(Timestamp comupdated) {
		this.comupdated = comupdated;
	}

	@Column(name = "COMIp", length = 128)
	public String getComip() {
		return this.comip;
	}

	public void setComip(String comip) {
		this.comip = comip;
	}

	@Column(name = "COMArticleName", length = 100)
	public String getComarticleName() {
		return this.comarticleName;
	}

	public void setComarticleName(String comarticleName) {
		this.comarticleName = comarticleName;
	}

}