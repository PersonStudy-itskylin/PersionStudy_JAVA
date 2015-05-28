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
 * Channelstate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "channelstate")
public class Channelstate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer chsid;
	private String chsname;
	private String chsremark;
	private Timestamp chscreated;
	private Timestamp chsupdated;
	private Set<Channel> channels = new HashSet<Channel>(0);

	// Constructors

	/** default constructor */
	public Channelstate() {
	}

	/** minimal constructor */
	public Channelstate(Integer chsid) {
		this.chsid = chsid;
	}

	/** full constructor */
	public Channelstate(Integer chsid, String chsname, String chsremark,
			Timestamp chscreated, Timestamp chsupdated, Set<Channel> channels) {
		this.chsid = chsid;
		this.chsname = chsname;
		this.chsremark = chsremark;
		this.chscreated = chscreated;
		this.chsupdated = chsupdated;
		this.channels = channels;
	}

	// Property accessors
	@Id
	@Column(name = "CHSID", unique = true, nullable = false)
	public Integer getChsid() {
		return this.chsid;
	}

	public void setChsid(Integer chsid) {
		this.chsid = chsid;
	}

	@Column(name = "CHSName", length = 50)
	public String getChsname() {
		return this.chsname;
	}

	public void setChsname(String chsname) {
		this.chsname = chsname;
	}

	@Column(name = "CHSRemark")
	public String getChsremark() {
		return this.chsremark;
	}

	public void setChsremark(String chsremark) {
		this.chsremark = chsremark;
	}

	@Column(name = "CHSCreated", length = 19)
	public Timestamp getChscreated() {
		return this.chscreated;
	}

	public void setChscreated(Timestamp chscreated) {
		this.chscreated = chscreated;
	}

	@Column(name = "CHSUpdated", length = 19)
	public Timestamp getChsupdated() {
		return this.chsupdated;
	}

	public void setChsupdated(Timestamp chsupdated) {
		this.chsupdated = chsupdated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channelstate")
	public Set<Channel> getChannels() {
		return this.channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}

}