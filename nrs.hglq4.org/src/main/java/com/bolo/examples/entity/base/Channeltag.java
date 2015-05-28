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
 * Channeltag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "channeltag")
public class Channeltag implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer chatid;
	private Channel channel;
	private String chatidentifier;
	private Timestamp chatcreated;
	private Timestamp chatupdated;

	// Constructors

	/** default constructor */
	public Channeltag() {
	}

	/** minimal constructor */
	public Channeltag(Integer chatid, Channel channel) {
		this.chatid = chatid;
		this.channel = channel;
	}

	/** full constructor */
	public Channeltag(Integer chatid, Channel channel, String chatidentifier,
			Timestamp chatcreated, Timestamp chatupdated) {
		this.chatid = chatid;
		this.channel = channel;
		this.chatidentifier = chatidentifier;
		this.chatcreated = chatcreated;
		this.chatupdated = chatupdated;
	}

	// Property accessors
	@Id
	@Column(name = "CHATId", unique = true, nullable = false)
	public Integer getChatid() {
		return this.chatid;
	}

	public void setChatid(Integer chatid) {
		this.chatid = chatid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHAId", nullable = false)
	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Column(name = "CHATIdentifier", length = 64)
	public String getChatidentifier() {
		return this.chatidentifier;
	}

	public void setChatidentifier(String chatidentifier) {
		this.chatidentifier = chatidentifier;
	}

	@Column(name = "CHATCreated", length = 19)
	public Timestamp getChatcreated() {
		return this.chatcreated;
	}

	public void setChatcreated(Timestamp chatcreated) {
		this.chatcreated = chatcreated;
	}

	@Column(name = "CHATUpdated", length = 19)
	public Timestamp getChatupdated() {
		return this.chatupdated;
	}

	public void setChatupdated(Timestamp chatupdated) {
		this.chatupdated = chatupdated;
	}

}