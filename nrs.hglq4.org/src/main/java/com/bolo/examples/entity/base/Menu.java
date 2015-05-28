package com.bolo.examples.entity.base;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu")
public class Menu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer menid;
	private Integer menparentId;
	private String menentityId;
	private String mennameText;
	private String mentitle;
	private String menhref;
	private String menicon;
	private String meniconHover;
	private Integer mengroup;
	private Integer mentype;
	private Integer mensequenceIndex;
	private Timestamp mencreated;
	private Timestamp menupdated;
	private Set<Role> roles = new HashSet<Role>(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(Integer menid) {
		this.menid = menid;
	}

	/** full constructor */
	public Menu(Integer menid, Integer menparentId, String menentityId,
			String mennameText, String mentitle, String menhref,
			String menicon, String meniconHover, Integer mengroup,
			Integer mentype, Integer mensequenceIndex, Timestamp mencreated,
			Timestamp menupdated, Set<Role> roles) {
		this.menid = menid;
		this.menparentId = menparentId;
		this.menentityId = menentityId;
		this.mennameText = mennameText;
		this.mentitle = mentitle;
		this.menhref = menhref;
		this.menicon = menicon;
		this.meniconHover = meniconHover;
		this.mengroup = mengroup;
		this.mentype = mentype;
		this.mensequenceIndex = mensequenceIndex;
		this.mencreated = mencreated;
		this.menupdated = menupdated;
		this.roles = roles;
	}

	// Property accessors
	@Id
	@Column(name = "MENID", unique = true, nullable = false)
	public Integer getMenid() {
		return this.menid;
	}

	public void setMenid(Integer menid) {
		this.menid = menid;
	}

	@Column(name = "MENParentID")
	public Integer getMenparentId() {
		return this.menparentId;
	}

	public void setMenparentId(Integer menparentId) {
		this.menparentId = menparentId;
	}

	@Column(name = "MENEntityID", length = 40)
	public String getMenentityId() {
		return this.menentityId;
	}

	public void setMenentityId(String menentityId) {
		this.menentityId = menentityId;
	}

	@Column(name = "MENNameText", length = 40)
	public String getMennameText() {
		return this.mennameText;
	}

	public void setMennameText(String mennameText) {
		this.mennameText = mennameText;
	}

	@Column(name = "MENTitle", length = 40)
	public String getMentitle() {
		return this.mentitle;
	}

	public void setMentitle(String mentitle) {
		this.mentitle = mentitle;
	}

	@Column(name = "MENHref", length = 40)
	public String getMenhref() {
		return this.menhref;
	}

	public void setMenhref(String menhref) {
		this.menhref = menhref;
	}

	@Column(name = "MENIcon", length = 40)
	public String getMenicon() {
		return this.menicon;
	}

	public void setMenicon(String menicon) {
		this.menicon = menicon;
	}

	@Column(name = "MENIconHover", length = 40)
	public String getMeniconHover() {
		return this.meniconHover;
	}

	public void setMeniconHover(String meniconHover) {
		this.meniconHover = meniconHover;
	}

	@Column(name = "MENGroup")
	public Integer getMengroup() {
		return this.mengroup;
	}

	public void setMengroup(Integer mengroup) {
		this.mengroup = mengroup;
	}

	@Column(name = "MENType")
	public Integer getMentype() {
		return this.mentype;
	}

	public void setMentype(Integer mentype) {
		this.mentype = mentype;
	}

	@Column(name = "MENSequenceIndex")
	public Integer getMensequenceIndex() {
		return this.mensequenceIndex;
	}

	public void setMensequenceIndex(Integer mensequenceIndex) {
		this.mensequenceIndex = mensequenceIndex;
	}

	@Column(name = "MENCreated", length = 19)
	public Timestamp getMencreated() {
		return this.mencreated;
	}

	public void setMencreated(Timestamp mencreated) {
		this.mencreated = mencreated;
	}

	@Column(name = "MENUpdated", length = 19)
	public Timestamp getMenupdated() {
		return this.menupdated;
	}

	public void setMenupdated(Timestamp menupdated) {
		this.menupdated = menupdated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}