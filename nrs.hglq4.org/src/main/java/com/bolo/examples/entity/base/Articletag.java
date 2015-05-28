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
 * Articletag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "articletag")
public class Articletag implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer arttid;
	private Article article;
	private String arttidentifier;
	private Timestamp arttcreated;
	private Timestamp arttupdated;

	// Constructors

	/** default constructor */
	public Articletag() {
	}

	/** minimal constructor */
	public Articletag(Integer arttid, Article article) {
		this.arttid = arttid;
		this.article = article;
	}

	/** full constructor */
	public Articletag(Integer arttid, Article article, String arttidentifier,
			Timestamp arttcreated, Timestamp arttupdated) {
		this.arttid = arttid;
		this.article = article;
		this.arttidentifier = arttidentifier;
		this.arttcreated = arttcreated;
		this.arttupdated = arttupdated;
	}

	// Property accessors
	@Id
	@Column(name = "ARTTID", unique = true, nullable = false)
	public Integer getArttid() {
		return this.arttid;
	}

	public void setArttid(Integer arttid) {
		this.arttid = arttid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTId", nullable = false)
	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "ARTTIdentifier", length = 64)
	public String getArttidentifier() {
		return this.arttidentifier;
	}

	public void setArttidentifier(String arttidentifier) {
		this.arttidentifier = arttidentifier;
	}

	@Column(name = "ARTTCreated", length = 19)
	public Timestamp getArttcreated() {
		return this.arttcreated;
	}

	public void setArttcreated(Timestamp arttcreated) {
		this.arttcreated = arttcreated;
	}

	@Column(name = "ARTTUpdated", length = 19)
	public Timestamp getArttupdated() {
		return this.arttupdated;
	}

	public void setArttupdated(Timestamp arttupdated) {
		this.arttupdated = arttupdated;
	}

}