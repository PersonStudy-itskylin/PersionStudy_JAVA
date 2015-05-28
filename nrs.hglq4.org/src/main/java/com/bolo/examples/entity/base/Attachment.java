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
 * Attachment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "attachment")
public class Attachment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer attId;
	private Article article;
	private String attarticleId;
	private String attfileType;
	private String attfileName;
	private String attfileSize;
	private String attfilePath;
	private String attfileDescription;
	private Timestamp attattUploadDate;
	private Integer attattDownloadCount;
	private Timestamp attattCreated;
	private Timestamp attattUpdated;
	private String attattEnumState;
	private String attremark1;

	// Constructors

	/** default constructor */
	public Attachment() {
	}

	/** minimal constructor */
	public Attachment(Integer attId, Article article) {
		this.attId = attId;
		this.article = article;
	}

	/** full constructor */
	public Attachment(Integer attId, Article article, String attarticleId,
			String attfileType, String attfileName, String attfileSize,
			String attfilePath, String attfileDescription,
			Timestamp attattUploadDate, Integer attattDownloadCount,
			Timestamp attattCreated, Timestamp attattUpdated,
			String attattEnumState, String attremark1) {
		this.attId = attId;
		this.article = article;
		this.attarticleId = attarticleId;
		this.attfileType = attfileType;
		this.attfileName = attfileName;
		this.attfileSize = attfileSize;
		this.attfilePath = attfilePath;
		this.attfileDescription = attfileDescription;
		this.attattUploadDate = attattUploadDate;
		this.attattDownloadCount = attattDownloadCount;
		this.attattCreated = attattCreated;
		this.attattUpdated = attattUpdated;
		this.attattEnumState = attattEnumState;
		this.attremark1 = attremark1;
	}

	// Property accessors
	@Id
	@Column(name = "AttId", unique = true, nullable = false)
	public Integer getAttId() {
		return this.attId;
	}

	public void setAttId(Integer attId) {
		this.attId = attId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTId", nullable = false)
	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "ATTArticleId", length = 40)
	public String getAttarticleId() {
		return this.attarticleId;
	}

	public void setAttarticleId(String attarticleId) {
		this.attarticleId = attarticleId;
	}

	@Column(name = "ATTFileType", length = 8)
	public String getAttfileType() {
		return this.attfileType;
	}

	public void setAttfileType(String attfileType) {
		this.attfileType = attfileType;
	}

	@Column(name = "ATTFileName")
	public String getAttfileName() {
		return this.attfileName;
	}

	public void setAttfileName(String attfileName) {
		this.attfileName = attfileName;
	}

	@Column(name = "ATTFileSize", length = 30)
	public String getAttfileSize() {
		return this.attfileSize;
	}

	public void setAttfileSize(String attfileSize) {
		this.attfileSize = attfileSize;
	}

	@Column(name = "ATTFilePath")
	public String getAttfilePath() {
		return this.attfilePath;
	}

	public void setAttfilePath(String attfilePath) {
		this.attfilePath = attfilePath;
	}

	@Column(name = "ATTFileDescription")
	public String getAttfileDescription() {
		return this.attfileDescription;
	}

	public void setAttfileDescription(String attfileDescription) {
		this.attfileDescription = attfileDescription;
	}

	@Column(name = "ATTAttUploadDate", length = 19)
	public Timestamp getAttattUploadDate() {
		return this.attattUploadDate;
	}

	public void setAttattUploadDate(Timestamp attattUploadDate) {
		this.attattUploadDate = attattUploadDate;
	}

	@Column(name = "ATTAttDownloadCount")
	public Integer getAttattDownloadCount() {
		return this.attattDownloadCount;
	}

	public void setAttattDownloadCount(Integer attattDownloadCount) {
		this.attattDownloadCount = attattDownloadCount;
	}

	@Column(name = "ATTAttCreated", length = 19)
	public Timestamp getAttattCreated() {
		return this.attattCreated;
	}

	public void setAttattCreated(Timestamp attattCreated) {
		this.attattCreated = attattCreated;
	}

	@Column(name = "ATTAttUpdated", length = 19)
	public Timestamp getAttattUpdated() {
		return this.attattUpdated;
	}

	public void setAttattUpdated(Timestamp attattUpdated) {
		this.attattUpdated = attattUpdated;
	}

	@Column(name = "ATTAttEnumState", length = 50)
	public String getAttattEnumState() {
		return this.attattEnumState;
	}

	public void setAttattEnumState(String attattEnumState) {
		this.attattEnumState = attattEnumState;
	}

	@Column(name = "ATTremark1")
	public String getAttremark1() {
		return this.attremark1;
	}

	public void setAttremark1(String attremark1) {
		this.attremark1 = attremark1;
	}

}