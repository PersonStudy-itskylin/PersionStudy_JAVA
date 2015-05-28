package com.bolo.examples.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Articleindex entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "articleindex")
public class Articleindex implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ariid;
	private Article article;
	private String arioperation;
	private Integer ariisLock;

	// Constructors

	/** default constructor */
	public Articleindex() {
	}

	/** minimal constructor */
	public Articleindex(Integer ariid, Article article) {
		this.ariid = ariid;
		this.article = article;
	}

	/** full constructor */
	public Articleindex(Integer ariid, Article article, String arioperation,
			Integer ariisLock) {
		this.ariid = ariid;
		this.article = article;
		this.arioperation = arioperation;
		this.ariisLock = ariisLock;
	}

	// Property accessors
	@Id
	@Column(name = "ARIID", unique = true, nullable = false)
	public Integer getAriid() {
		return this.ariid;
	}

	public void setAriid(Integer ariid) {
		this.ariid = ariid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTId", nullable = false)
	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "ARIOperation")
	public String getArioperation() {
		return this.arioperation;
	}

	public void setArioperation(String arioperation) {
		this.arioperation = arioperation;
	}

	@Column(name = "ARIIsLock")
	public Integer getAriisLock() {
		return this.ariisLock;
	}

	public void setAriisLock(Integer ariisLock) {
		this.ariisLock = ariisLock;
	}

}