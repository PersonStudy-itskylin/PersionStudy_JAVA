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
 * Relatedarticle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "relatedarticle")
public class Relatedarticle implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer relid;
	private Article articleByArtid;
	private Article articleByArtArtid;
	private Timestamp relcreated;
	private Timestamp relupdated;

	// Constructors

	/** default constructor */
	public Relatedarticle() {
	}

	/** minimal constructor */
	public Relatedarticle(Integer relid, Article articleByArtid,
			Article articleByArtArtid) {
		this.relid = relid;
		this.articleByArtid = articleByArtid;
		this.articleByArtArtid = articleByArtArtid;
	}

	/** full constructor */
	public Relatedarticle(Integer relid, Article articleByArtid,
			Article articleByArtArtid, Timestamp relcreated,
			Timestamp relupdated) {
		this.relid = relid;
		this.articleByArtid = articleByArtid;
		this.articleByArtArtid = articleByArtArtid;
		this.relcreated = relcreated;
		this.relupdated = relupdated;
	}

	// Property accessors
	@Id
	@Column(name = "RELID", unique = true, nullable = false)
	public Integer getRelid() {
		return this.relid;
	}

	public void setRelid(Integer relid) {
		this.relid = relid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTId", nullable = false)
	public Article getArticleByArtid() {
		return this.articleByArtid;
	}

	public void setArticleByArtid(Article articleByArtid) {
		this.articleByArtid = articleByArtid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Art_ARTId", nullable = false)
	public Article getArticleByArtArtid() {
		return this.articleByArtArtid;
	}

	public void setArticleByArtArtid(Article articleByArtArtid) {
		this.articleByArtArtid = articleByArtArtid;
	}

	@Column(name = "RELCreated", length = 19)
	public Timestamp getRelcreated() {
		return this.relcreated;
	}

	public void setRelcreated(Timestamp relcreated) {
		this.relcreated = relcreated;
	}

	@Column(name = "RELUpdated", length = 19)
	public Timestamp getRelupdated() {
		return this.relupdated;
	}

	public void setRelupdated(Timestamp relupdated) {
		this.relupdated = relupdated;
	}

}