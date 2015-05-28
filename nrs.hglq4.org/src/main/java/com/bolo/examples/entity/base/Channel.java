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
 * Channel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "channel")
public class Channel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer chaid;
	private Channelstate channelstate;
	private Integer chaparentId;
	private String chaalias;
	private String chafullPath;
	private String chaparameter;
	private String chatemplateName;
	private String chadetailTemplate;
	private Integer chadefaultContentId;
	private Integer chasequenceIndex;
	private Integer chareferenceId;
	private String chatitle;
	private String chadescription;
	private Integer chasecurityLevel;
	private Timestamp chacreated;
	private String chafolder;
	private String chatitleImage;
	private Integer chaprocess;
	private Integer chaprocessLayouNo;
	private Integer chaprocessEnd;
	private String chatype;
	private String chaname;
	private String charefAreaId;
	private Integer chaisComment;
	private String chafullUrl;
	private String chareturnUrl;
	private Timestamp chaupdated;
	private String chaenumState;
	private Long chasarticlesCount;
	private String chatags;
	private String chakeyWord;
	private String chadescriptionKey;
	private String chaipstrategy;
	private String chamodelName;
	private String charemark1;
	private Set<Channeltag> channeltags = new HashSet<Channeltag>(0);
	private Set<Article> articles = new HashSet<Article>(0);
	private Set<Statistics> statisticses = new HashSet<Statistics>(0);
	private Set<Statisticshistory> statisticshistories = new HashSet<Statisticshistory>(
			0);

	// Constructors

	/** default constructor */
	public Channel() {
	}

	/** minimal constructor */
	public Channel(Integer chaid, Channelstate channelstate) {
		this.chaid = chaid;
		this.channelstate = channelstate;
	}

	/** full constructor */
	public Channel(Integer chaid, Channelstate channelstate,
			Integer chaparentId, String chaalias, String chafullPath,
			String chaparameter, String chatemplateName,
			String chadetailTemplate, Integer chadefaultContentId,
			Integer chasequenceIndex, Integer chareferenceId, String chatitle,
			String chadescription, Integer chasecurityLevel,
			Timestamp chacreated, String chafolder, String chatitleImage,
			Integer chaprocess, Integer chaprocessLayouNo,
			Integer chaprocessEnd, String chatype, String chaname,
			String charefAreaId, Integer chaisComment, String chafullUrl,
			String chareturnUrl, Timestamp chaupdated, String chaenumState,
			Long chasarticlesCount, String chatags, String chakeyWord,
			String chadescriptionKey, String chaipstrategy,
			String chamodelName, String charemark1,
			Set<Channeltag> channeltags, Set<Article> articles,
			Set<Statistics> statisticses,
			Set<Statisticshistory> statisticshistories) {
		this.chaid = chaid;
		this.channelstate = channelstate;
		this.chaparentId = chaparentId;
		this.chaalias = chaalias;
		this.chafullPath = chafullPath;
		this.chaparameter = chaparameter;
		this.chatemplateName = chatemplateName;
		this.chadetailTemplate = chadetailTemplate;
		this.chadefaultContentId = chadefaultContentId;
		this.chasequenceIndex = chasequenceIndex;
		this.chareferenceId = chareferenceId;
		this.chatitle = chatitle;
		this.chadescription = chadescription;
		this.chasecurityLevel = chasecurityLevel;
		this.chacreated = chacreated;
		this.chafolder = chafolder;
		this.chatitleImage = chatitleImage;
		this.chaprocess = chaprocess;
		this.chaprocessLayouNo = chaprocessLayouNo;
		this.chaprocessEnd = chaprocessEnd;
		this.chatype = chatype;
		this.chaname = chaname;
		this.charefAreaId = charefAreaId;
		this.chaisComment = chaisComment;
		this.chafullUrl = chafullUrl;
		this.chareturnUrl = chareturnUrl;
		this.chaupdated = chaupdated;
		this.chaenumState = chaenumState;
		this.chasarticlesCount = chasarticlesCount;
		this.chatags = chatags;
		this.chakeyWord = chakeyWord;
		this.chadescriptionKey = chadescriptionKey;
		this.chaipstrategy = chaipstrategy;
		this.chamodelName = chamodelName;
		this.charemark1 = charemark1;
		this.channeltags = channeltags;
		this.articles = articles;
		this.statisticses = statisticses;
		this.statisticshistories = statisticshistories;
	}

	// Property accessors
	@Id
	@Column(name = "CHAId", unique = true, nullable = false)
	public Integer getChaid() {
		return this.chaid;
	}

	public void setChaid(Integer chaid) {
		this.chaid = chaid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHSID", nullable = false)
	public Channelstate getChannelstate() {
		return this.channelstate;
	}

	public void setChannelstate(Channelstate channelstate) {
		this.channelstate = channelstate;
	}

	@Column(name = "CHAParentId")
	public Integer getChaparentId() {
		return this.chaparentId;
	}

	public void setChaparentId(Integer chaparentId) {
		this.chaparentId = chaparentId;
	}

	@Column(name = "CHAAlias", length = 16)
	public String getChaalias() {
		return this.chaalias;
	}

	public void setChaalias(String chaalias) {
		this.chaalias = chaalias;
	}

	@Column(name = "CHAFullPath")
	public String getChafullPath() {
		return this.chafullPath;
	}

	public void setChafullPath(String chafullPath) {
		this.chafullPath = chafullPath;
	}

	@Column(name = "CHAParameter")
	public String getChaparameter() {
		return this.chaparameter;
	}

	public void setChaparameter(String chaparameter) {
		this.chaparameter = chaparameter;
	}

	@Column(name = "CHATemplateName", length = 64)
	public String getChatemplateName() {
		return this.chatemplateName;
	}

	public void setChatemplateName(String chatemplateName) {
		this.chatemplateName = chatemplateName;
	}

	@Column(name = "CHADetailTemplate", length = 64)
	public String getChadetailTemplate() {
		return this.chadetailTemplate;
	}

	public void setChadetailTemplate(String chadetailTemplate) {
		this.chadetailTemplate = chadetailTemplate;
	}

	@Column(name = "CHADefaultContentId")
	public Integer getChadefaultContentId() {
		return this.chadefaultContentId;
	}

	public void setChadefaultContentId(Integer chadefaultContentId) {
		this.chadefaultContentId = chadefaultContentId;
	}

	@Column(name = "CHASequenceIndex")
	public Integer getChasequenceIndex() {
		return this.chasequenceIndex;
	}

	public void setChasequenceIndex(Integer chasequenceIndex) {
		this.chasequenceIndex = chasequenceIndex;
	}

	@Column(name = "CHAReferenceId")
	public Integer getChareferenceId() {
		return this.chareferenceId;
	}

	public void setChareferenceId(Integer chareferenceId) {
		this.chareferenceId = chareferenceId;
	}

	@Column(name = "CHATitle", length = 64)
	public String getChatitle() {
		return this.chatitle;
	}

	public void setChatitle(String chatitle) {
		this.chatitle = chatitle;
	}

	@Column(name = "CHADescription", length = 64)
	public String getChadescription() {
		return this.chadescription;
	}

	public void setChadescription(String chadescription) {
		this.chadescription = chadescription;
	}

	@Column(name = "CHASecurityLevel")
	public Integer getChasecurityLevel() {
		return this.chasecurityLevel;
	}

	public void setChasecurityLevel(Integer chasecurityLevel) {
		this.chasecurityLevel = chasecurityLevel;
	}

	@Column(name = "CHACreated", length = 19)
	public Timestamp getChacreated() {
		return this.chacreated;
	}

	public void setChacreated(Timestamp chacreated) {
		this.chacreated = chacreated;
	}

	@Column(name = "CHAFolder", length = 64)
	public String getChafolder() {
		return this.chafolder;
	}

	public void setChafolder(String chafolder) {
		this.chafolder = chafolder;
	}

	@Column(name = "CHATitleImage", length = 64)
	public String getChatitleImage() {
		return this.chatitleImage;
	}

	public void setChatitleImage(String chatitleImage) {
		this.chatitleImage = chatitleImage;
	}

	@Column(name = "CHAProcess")
	public Integer getChaprocess() {
		return this.chaprocess;
	}

	public void setChaprocess(Integer chaprocess) {
		this.chaprocess = chaprocess;
	}

	@Column(name = "CHAProcessLayouNo")
	public Integer getChaprocessLayouNo() {
		return this.chaprocessLayouNo;
	}

	public void setChaprocessLayouNo(Integer chaprocessLayouNo) {
		this.chaprocessLayouNo = chaprocessLayouNo;
	}

	@Column(name = "CHAProcessEnd")
	public Integer getChaprocessEnd() {
		return this.chaprocessEnd;
	}

	public void setChaprocessEnd(Integer chaprocessEnd) {
		this.chaprocessEnd = chaprocessEnd;
	}

	@Column(name = "CHAType", length = 16)
	public String getChatype() {
		return this.chatype;
	}

	public void setChatype(String chatype) {
		this.chatype = chatype;
	}

	@Column(name = "CHAName", length = 50)
	public String getChaname() {
		return this.chaname;
	}

	public void setChaname(String chaname) {
		this.chaname = chaname;
	}

	@Column(name = "CHARefAreaId", length = 40)
	public String getCharefAreaId() {
		return this.charefAreaId;
	}

	public void setCharefAreaId(String charefAreaId) {
		this.charefAreaId = charefAreaId;
	}

	@Column(name = "CHAIsComment")
	public Integer getChaisComment() {
		return this.chaisComment;
	}

	public void setChaisComment(Integer chaisComment) {
		this.chaisComment = chaisComment;
	}

	@Column(name = "CHAFullUrl")
	public String getChafullUrl() {
		return this.chafullUrl;
	}

	public void setChafullUrl(String chafullUrl) {
		this.chafullUrl = chafullUrl;
	}

	@Column(name = "CHAReturnUrl")
	public String getChareturnUrl() {
		return this.chareturnUrl;
	}

	public void setChareturnUrl(String chareturnUrl) {
		this.chareturnUrl = chareturnUrl;
	}

	@Column(name = "CHAUpdated", length = 19)
	public Timestamp getChaupdated() {
		return this.chaupdated;
	}

	public void setChaupdated(Timestamp chaupdated) {
		this.chaupdated = chaupdated;
	}

	@Column(name = "CHAEnumState", length = 40)
	public String getChaenumState() {
		return this.chaenumState;
	}

	public void setChaenumState(String chaenumState) {
		this.chaenumState = chaenumState;
	}

	@Column(name = "CHASArticlesCount")
	public Long getChasarticlesCount() {
		return this.chasarticlesCount;
	}

	public void setChasarticlesCount(Long chasarticlesCount) {
		this.chasarticlesCount = chasarticlesCount;
	}

	@Column(name = "CHATags")
	public String getChatags() {
		return this.chatags;
	}

	public void setChatags(String chatags) {
		this.chatags = chatags;
	}

	@Column(name = "CHAKeyWord")
	public String getChakeyWord() {
		return this.chakeyWord;
	}

	public void setChakeyWord(String chakeyWord) {
		this.chakeyWord = chakeyWord;
	}

	@Column(name = "CHADescriptionKey")
	public String getChadescriptionKey() {
		return this.chadescriptionKey;
	}

	public void setChadescriptionKey(String chadescriptionKey) {
		this.chadescriptionKey = chadescriptionKey;
	}

	@Column(name = "CHAIPStrategy", length = 128)
	public String getChaipstrategy() {
		return this.chaipstrategy;
	}

	public void setChaipstrategy(String chaipstrategy) {
		this.chaipstrategy = chaipstrategy;
	}

	@Column(name = "CHAModelName", length = 128)
	public String getChamodelName() {
		return this.chamodelName;
	}

	public void setChamodelName(String chamodelName) {
		this.chamodelName = chamodelName;
	}

	@Column(name = "CHARemark1")
	public String getCharemark1() {
		return this.charemark1;
	}

	public void setCharemark1(String charemark1) {
		this.charemark1 = charemark1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channel")
	public Set<Channeltag> getChanneltags() {
		return this.channeltags;
	}

	public void setChanneltags(Set<Channeltag> channeltags) {
		this.channeltags = channeltags;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "channel")
	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channel")
	public Set<Statistics> getStatisticses() {
		return this.statisticses;
	}

	public void setStatisticses(Set<Statistics> statisticses) {
		this.statisticses = statisticses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "channel")
	public Set<Statisticshistory> getStatisticshistories() {
		return this.statisticshistories;
	}

	public void setStatisticshistories(
			Set<Statisticshistory> statisticshistories) {
		this.statisticshistories = statisticshistories;
	}

}