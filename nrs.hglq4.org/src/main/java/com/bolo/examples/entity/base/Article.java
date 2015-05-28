package com.bolo.examples.entity.base;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article")
public class Article implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer artid;
	private Channel channel;
	private String arttitle;
	private String artdescription;
	private String artauthor;
	private String artcontext;
	private Timestamp artcreated;
	private Timestamp artupdated;
	private Timestamp artoverdue;
	private String artsource;
	private Integer artallowComments;
	private Integer artsequenceIndex;
	private Integer artisImage;
	private Integer artisShow;
	private String artsubTitle;
	private String artthumbnail;
	private String artcontentUrl;
	private Integer artisDelete;
	private Integer artcontentType;
	private String artsourceId;
	private Integer artsn;
	private Integer artprocessState;
	private String artprocessDirection;
	private String artprocessSiteId;
	private String artflowXml;
	private String artfromRowId;
	private String artfromSiteUrl;
	private String artenumState;
	private String artmodelXml;
	private String artchannelName;
	private String artchannelFullUrl;
	private Integer artclicks;
	private Integer artcommentCount;
	private String arttags;
	private String artkeyWord;
	private String artdescriptionKey;
	private String artvideoCode;
	private String artlistKeys;
	private String artlistKeys2;
	private String artlistKeys3;
	private Integer artprivacyLevel;
	private String artmodelName;
	private String arttableName;
	private String artmodelConfig;
	private String artmodelSchema;
	private String artlistKeys4;
	private String artlistKeys5;
	private String artipstrategy;
	private String artremark;
	private Set<Comments> commentses = new HashSet<Comments>(0);
	private Set<Articletag> articletags = new HashSet<Articletag>(0);
	private Set<Relatedarticle> relatedarticlesForArtArtid = new HashSet<Relatedarticle>(
			0);
	private Set<Statisticshistory> statisticshistories = new HashSet<Statisticshistory>(
			0);
	private Set<Relatedarticle> relatedarticlesForArtid = new HashSet<Relatedarticle>(
			0);
	private Set<Statistics> statisticses = new HashSet<Statistics>(0);
	private Set<Articleindex> articleindexes = new HashSet<Articleindex>(0);
	private Set<Attachment> attachments = new HashSet<Attachment>(0);

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Integer artid, Channel channel) {
		this.artid = artid;
		this.channel = channel;
	}

	/** full constructor */
	public Article(Integer artid, Channel channel, String arttitle,
			String artdescription, String artauthor, String artcontext,
			Timestamp artcreated, Timestamp artupdated, Timestamp artoverdue,
			String artsource, Integer artallowComments,
			Integer artsequenceIndex, Integer artisImage, Integer artisShow,
			String artsubTitle, String artthumbnail, String artcontentUrl,
			Integer artisDelete, Integer artcontentType, String artsourceId,
			Integer artsn, Integer artprocessState, String artprocessDirection,
			String artprocessSiteId, String artflowXml, String artfromRowId,
			String artfromSiteUrl, String artenumState, String artmodelXml,
			String artchannelName, String artchannelFullUrl, Integer artclicks,
			Integer artcommentCount, String arttags, String artkeyWord,
			String artdescriptionKey, String artvideoCode, String artlistKeys,
			String artlistKeys2, String artlistKeys3, Integer artprivacyLevel,
			String artmodelName, String arttableName, String artmodelConfig,
			String artmodelSchema, String artlistKeys4, String artlistKeys5,
			String artipstrategy, String artremark, Set<Comments> commentses,
			Set<Articletag> articletags,
			Set<Relatedarticle> relatedarticlesForArtArtid,
			Set<Statisticshistory> statisticshistories,
			Set<Relatedarticle> relatedarticlesForArtid,
			Set<Statistics> statisticses, Set<Articleindex> articleindexes,
			Set<Attachment> attachments) {
		this.artid = artid;
		this.channel = channel;
		this.arttitle = arttitle;
		this.artdescription = artdescription;
		this.artauthor = artauthor;
		this.artcontext = artcontext;
		this.artcreated = artcreated;
		this.artupdated = artupdated;
		this.artoverdue = artoverdue;
		this.artsource = artsource;
		this.artallowComments = artallowComments;
		this.artsequenceIndex = artsequenceIndex;
		this.artisImage = artisImage;
		this.artisShow = artisShow;
		this.artsubTitle = artsubTitle;
		this.artthumbnail = artthumbnail;
		this.artcontentUrl = artcontentUrl;
		this.artisDelete = artisDelete;
		this.artcontentType = artcontentType;
		this.artsourceId = artsourceId;
		this.artsn = artsn;
		this.artprocessState = artprocessState;
		this.artprocessDirection = artprocessDirection;
		this.artprocessSiteId = artprocessSiteId;
		this.artflowXml = artflowXml;
		this.artfromRowId = artfromRowId;
		this.artfromSiteUrl = artfromSiteUrl;
		this.artenumState = artenumState;
		this.artmodelXml = artmodelXml;
		this.artchannelName = artchannelName;
		this.artchannelFullUrl = artchannelFullUrl;
		this.artclicks = artclicks;
		this.artcommentCount = artcommentCount;
		this.arttags = arttags;
		this.artkeyWord = artkeyWord;
		this.artdescriptionKey = artdescriptionKey;
		this.artvideoCode = artvideoCode;
		this.artlistKeys = artlistKeys;
		this.artlistKeys2 = artlistKeys2;
		this.artlistKeys3 = artlistKeys3;
		this.artprivacyLevel = artprivacyLevel;
		this.artmodelName = artmodelName;
		this.arttableName = arttableName;
		this.artmodelConfig = artmodelConfig;
		this.artmodelSchema = artmodelSchema;
		this.artlistKeys4 = artlistKeys4;
		this.artlistKeys5 = artlistKeys5;
		this.artipstrategy = artipstrategy;
		this.artremark = artremark;
		this.commentses = commentses;
		this.articletags = articletags;
		this.relatedarticlesForArtArtid = relatedarticlesForArtArtid;
		this.statisticshistories = statisticshistories;
		this.relatedarticlesForArtid = relatedarticlesForArtid;
		this.statisticses = statisticses;
		this.articleindexes = articleindexes;
		this.attachments = attachments;
	}

	// Property accessors
	@Id
	@Column(name = "ARTId", unique = true, nullable = false)
	public Integer getArtid() {
		return this.artid;
	}

	public void setArtid(Integer artid) {
		this.artid = artid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHAId", nullable = false)
	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Column(name = "ARTTitle", length = 100)
	public String getArttitle() {
		return this.arttitle;
	}

	public void setArttitle(String arttitle) {
		this.arttitle = arttitle;
	}

	@Column(name = "ARTDescription")
	public String getArtdescription() {
		return this.artdescription;
	}

	public void setArtdescription(String artdescription) {
		this.artdescription = artdescription;
	}

	@Column(name = "ARTAuthor", length = 64)
	public String getArtauthor() {
		return this.artauthor;
	}

	public void setArtauthor(String artauthor) {
		this.artauthor = artauthor;
	}

	@Column(name = "ARTContext", length = 65535)
	public String getArtcontext() {
		return this.artcontext;
	}

	public void setArtcontext(String artcontext) {
		this.artcontext = artcontext;
	}

	@Column(name = "ARTCreated", length = 19)
	public Timestamp getArtcreated() {
		return this.artcreated;
	}

	public void setArtcreated(Timestamp artcreated) {
		this.artcreated = artcreated;
	}

	@Column(name = "ARTUpdated", length = 19)
	public Timestamp getArtupdated() {
		return this.artupdated;
	}

	public void setArtupdated(Timestamp artupdated) {
		this.artupdated = artupdated;
	}

	@Column(name = "ARTOverdue", length = 19)
	public Timestamp getArtoverdue() {
		return this.artoverdue;
	}

	public void setArtoverdue(Timestamp artoverdue) {
		this.artoverdue = artoverdue;
	}

	@Column(name = "ARTSource")
	public String getArtsource() {
		return this.artsource;
	}

	public void setArtsource(String artsource) {
		this.artsource = artsource;
	}

	@Column(name = "ARTAllowComments")
	public Integer getArtallowComments() {
		return this.artallowComments;
	}

	public void setArtallowComments(Integer artallowComments) {
		this.artallowComments = artallowComments;
	}

	@Column(name = "ARTSequenceIndex")
	public Integer getArtsequenceIndex() {
		return this.artsequenceIndex;
	}

	public void setArtsequenceIndex(Integer artsequenceIndex) {
		this.artsequenceIndex = artsequenceIndex;
	}

	@Column(name = "ARTIsImage")
	public Integer getArtisImage() {
		return this.artisImage;
	}

	public void setArtisImage(Integer artisImage) {
		this.artisImage = artisImage;
	}

	@Column(name = "ARTIsShow")
	public Integer getArtisShow() {
		return this.artisShow;
	}

	public void setArtisShow(Integer artisShow) {
		this.artisShow = artisShow;
	}

	@Column(name = "ARTSubTitle", length = 64)
	public String getArtsubTitle() {
		return this.artsubTitle;
	}

	public void setArtsubTitle(String artsubTitle) {
		this.artsubTitle = artsubTitle;
	}

	@Column(name = "ARTThumbnail")
	public String getArtthumbnail() {
		return this.artthumbnail;
	}

	public void setArtthumbnail(String artthumbnail) {
		this.artthumbnail = artthumbnail;
	}

	@Column(name = "ARTContentUrl")
	public String getArtcontentUrl() {
		return this.artcontentUrl;
	}

	public void setArtcontentUrl(String artcontentUrl) {
		this.artcontentUrl = artcontentUrl;
	}

	@Column(name = "ARTIsDelete")
	public Integer getArtisDelete() {
		return this.artisDelete;
	}

	public void setArtisDelete(Integer artisDelete) {
		this.artisDelete = artisDelete;
	}

	@Column(name = "ARTContentType")
	public Integer getArtcontentType() {
		return this.artcontentType;
	}

	public void setArtcontentType(Integer artcontentType) {
		this.artcontentType = artcontentType;
	}

	@Column(name = "ARTSourceId", length = 40)
	public String getArtsourceId() {
		return this.artsourceId;
	}

	public void setArtsourceId(String artsourceId) {
		this.artsourceId = artsourceId;
	}

	@Column(name = "ARTSN")
	public Integer getArtsn() {
		return this.artsn;
	}

	public void setArtsn(Integer artsn) {
		this.artsn = artsn;
	}

	@Column(name = "ARTProcessState")
	public Integer getArtprocessState() {
		return this.artprocessState;
	}

	public void setArtprocessState(Integer artprocessState) {
		this.artprocessState = artprocessState;
	}

	@Column(name = "ARTProcessDirection", length = 50)
	public String getArtprocessDirection() {
		return this.artprocessDirection;
	}

	public void setArtprocessDirection(String artprocessDirection) {
		this.artprocessDirection = artprocessDirection;
	}

	@Column(name = "ARTProcessSiteID", length = 50)
	public String getArtprocessSiteId() {
		return this.artprocessSiteId;
	}

	public void setArtprocessSiteId(String artprocessSiteId) {
		this.artprocessSiteId = artprocessSiteId;
	}

	@Column(name = "ARTFlowXml", length = 65535)
	public String getArtflowXml() {
		return this.artflowXml;
	}

	public void setArtflowXml(String artflowXml) {
		this.artflowXml = artflowXml;
	}

	@Column(name = "ARTFromRowId", length = 50)
	public String getArtfromRowId() {
		return this.artfromRowId;
	}

	public void setArtfromRowId(String artfromRowId) {
		this.artfromRowId = artfromRowId;
	}

	@Column(name = "ARTFromSiteUrl")
	public String getArtfromSiteUrl() {
		return this.artfromSiteUrl;
	}

	public void setArtfromSiteUrl(String artfromSiteUrl) {
		this.artfromSiteUrl = artfromSiteUrl;
	}

	@Column(name = "ARTEnumState", length = 40)
	public String getArtenumState() {
		return this.artenumState;
	}

	public void setArtenumState(String artenumState) {
		this.artenumState = artenumState;
	}

	@Column(name = "ARTModelXml", length = 65535)
	public String getArtmodelXml() {
		return this.artmodelXml;
	}

	public void setArtmodelXml(String artmodelXml) {
		this.artmodelXml = artmodelXml;
	}

	@Column(name = "ARTChannelName", length = 50)
	public String getArtchannelName() {
		return this.artchannelName;
	}

	public void setArtchannelName(String artchannelName) {
		this.artchannelName = artchannelName;
	}

	@Column(name = "ARTChannelFullUrl")
	public String getArtchannelFullUrl() {
		return this.artchannelFullUrl;
	}

	public void setArtchannelFullUrl(String artchannelFullUrl) {
		this.artchannelFullUrl = artchannelFullUrl;
	}

	@Column(name = "ARTClicks")
	public Integer getArtclicks() {
		return this.artclicks;
	}

	public void setArtclicks(Integer artclicks) {
		this.artclicks = artclicks;
	}

	@Column(name = "ARTCommentCount")
	public Integer getArtcommentCount() {
		return this.artcommentCount;
	}

	public void setArtcommentCount(Integer artcommentCount) {
		this.artcommentCount = artcommentCount;
	}

	@Column(name = "ARTTags")
	public String getArttags() {
		return this.arttags;
	}

	public void setArttags(String arttags) {
		this.arttags = arttags;
	}

	@Column(name = "ARTKeyWord")
	public String getArtkeyWord() {
		return this.artkeyWord;
	}

	public void setArtkeyWord(String artkeyWord) {
		this.artkeyWord = artkeyWord;
	}

	@Column(name = "ARTDescriptionKey")
	public String getArtdescriptionKey() {
		return this.artdescriptionKey;
	}

	public void setArtdescriptionKey(String artdescriptionKey) {
		this.artdescriptionKey = artdescriptionKey;
	}

	@Column(name = "ARTVideoCode", length = 65535)
	public String getArtvideoCode() {
		return this.artvideoCode;
	}

	public void setArtvideoCode(String artvideoCode) {
		this.artvideoCode = artvideoCode;
	}

	@Column(name = "ARTListKeys")
	public String getArtlistKeys() {
		return this.artlistKeys;
	}

	public void setArtlistKeys(String artlistKeys) {
		this.artlistKeys = artlistKeys;
	}

	@Column(name = "ARTListKeys2")
	public String getArtlistKeys2() {
		return this.artlistKeys2;
	}

	public void setArtlistKeys2(String artlistKeys2) {
		this.artlistKeys2 = artlistKeys2;
	}

	@Column(name = "ARTListKeys3")
	public String getArtlistKeys3() {
		return this.artlistKeys3;
	}

	public void setArtlistKeys3(String artlistKeys3) {
		this.artlistKeys3 = artlistKeys3;
	}

	@Column(name = "ARTPrivacyLevel")
	public Integer getArtprivacyLevel() {
		return this.artprivacyLevel;
	}

	public void setArtprivacyLevel(Integer artprivacyLevel) {
		this.artprivacyLevel = artprivacyLevel;
	}

	@Column(name = "ARTModelName", length = 50)
	public String getArtmodelName() {
		return this.artmodelName;
	}

	public void setArtmodelName(String artmodelName) {
		this.artmodelName = artmodelName;
	}

	@Column(name = "ARTTableName", length = 50)
	public String getArttableName() {
		return this.arttableName;
	}

	public void setArttableName(String arttableName) {
		this.arttableName = arttableName;
	}

	@Column(name = "ARTModelConfig", length = 65535)
	public String getArtmodelConfig() {
		return this.artmodelConfig;
	}

	public void setArtmodelConfig(String artmodelConfig) {
		this.artmodelConfig = artmodelConfig;
	}

	@Column(name = "ARTModelSchema", length = 65535)
	public String getArtmodelSchema() {
		return this.artmodelSchema;
	}

	public void setArtmodelSchema(String artmodelSchema) {
		this.artmodelSchema = artmodelSchema;
	}

	@Column(name = "ARTListKeys4")
	public String getArtlistKeys4() {
		return this.artlistKeys4;
	}

	public void setArtlistKeys4(String artlistKeys4) {
		this.artlistKeys4 = artlistKeys4;
	}

	@Column(name = "ARTListKeys5")
	public String getArtlistKeys5() {
		return this.artlistKeys5;
	}

	public void setArtlistKeys5(String artlistKeys5) {
		this.artlistKeys5 = artlistKeys5;
	}

	@Column(name = "ARTIPStrategy", length = 128)
	public String getArtipstrategy() {
		return this.artipstrategy;
	}

	public void setArtipstrategy(String artipstrategy) {
		this.artipstrategy = artipstrategy;
	}

	@Column(name = "ARTremark")
	public String getArtremark() {
		return this.artremark;
	}

	public void setArtremark(String artremark) {
		this.artremark = artremark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")
	public Set<Articletag> getArticletags() {
		return this.articletags;
	}

	public void setArticletags(Set<Articletag> articletags) {
		this.articletags = articletags;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articleByArtArtid")
	public Set<Relatedarticle> getRelatedarticlesForArtArtid() {
		return this.relatedarticlesForArtArtid;
	}

	public void setRelatedarticlesForArtArtid(
			Set<Relatedarticle> relatedarticlesForArtArtid) {
		this.relatedarticlesForArtArtid = relatedarticlesForArtArtid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")
	public Set<Statisticshistory> getStatisticshistories() {
		return this.statisticshistories;
	}

	public void setStatisticshistories(
			Set<Statisticshistory> statisticshistories) {
		this.statisticshistories = statisticshistories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articleByArtid")
	public Set<Relatedarticle> getRelatedarticlesForArtid() {
		return this.relatedarticlesForArtid;
	}

	public void setRelatedarticlesForArtid(
			Set<Relatedarticle> relatedarticlesForArtid) {
		this.relatedarticlesForArtid = relatedarticlesForArtid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")
	public Set<Statistics> getStatisticses() {
		return this.statisticses;
	}

	public void setStatisticses(Set<Statistics> statisticses) {
		this.statisticses = statisticses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")
	public Set<Articleindex> getArticleindexes() {
		return this.articleindexes;
	}

	public void setArticleindexes(Set<Articleindex> articleindexes) {
		this.articleindexes = articleindexes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article")
	public Set<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

}