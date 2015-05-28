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
 * Account entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer accid;
	private Point point;
	private String accdescription;
	private String accloginName;
	private String accpassword;
	private Integer acchome;
	private String accfirstName;
	private String accmiddleName;
	private String accemail;
	private String accphoto;
	private String accqq;
	private Integer accstate;
	private Integer accuserType;
	private Integer accsequenceIndex;
	private Timestamp acccreated;
	private Integer accpasswordHashed;
	private Timestamp accupdated;
	private Integer accgroupPassport;
	private String accenumState;
	private Timestamp accoverdue;
	private Integer accuserModelId;
	private String accuserModelName;
	private String accmodelXml;
	private Integer accpoint;
	private Integer accprestige;
	private Long accmoney;
	private Integer accpublishCount;
	private String accmodelName;
	private String accmodelConfig;
	private String accmodelSchema;
	private Integer accemailValidate;
	private Integer accmodelState;
	private Set<Pagevisitorhistory> pagevisitorhistories = new HashSet<Pagevisitorhistory>(
			0);
	private Set<Loges> logeses = new HashSet<Loges>(0);
	private Set<Pagevisitor> pagevisitors = new HashSet<Pagevisitor>(0);
	private Set<Statistics> statisticses = new HashSet<Statistics>(0);
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Statisticshistory> statisticshistories = new HashSet<Statisticshistory>(
			0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(Integer accid) {
		this.accid = accid;
	}

	/** full constructor */
	public Account(Integer accid, Point point, String accdescription,
			String accloginName, String accpassword, Integer acchome,
			String accfirstName, String accmiddleName, String accemail,
			String accphoto, String accqq, Integer accstate,
			Integer accuserType, Integer accsequenceIndex,
			Timestamp acccreated, Integer accpasswordHashed,
			Timestamp accupdated, Integer accgroupPassport,
			String accenumState, Timestamp accoverdue, Integer accuserModelId,
			String accuserModelName, String accmodelXml, Integer accpoint,
			Integer accprestige, Long accmoney, Integer accpublishCount,
			String accmodelName, String accmodelConfig, String accmodelSchema,
			Integer accemailValidate, Integer accmodelState,
			Set<Pagevisitorhistory> pagevisitorhistories, Set<Loges> logeses,
			Set<Pagevisitor> pagevisitors, Set<Statistics> statisticses,
			Set<Role> roles, Set<Statisticshistory> statisticshistories) {
		this.accid = accid;
		this.point = point;
		this.accdescription = accdescription;
		this.accloginName = accloginName;
		this.accpassword = accpassword;
		this.acchome = acchome;
		this.accfirstName = accfirstName;
		this.accmiddleName = accmiddleName;
		this.accemail = accemail;
		this.accphoto = accphoto;
		this.accqq = accqq;
		this.accstate = accstate;
		this.accuserType = accuserType;
		this.accsequenceIndex = accsequenceIndex;
		this.acccreated = acccreated;
		this.accpasswordHashed = accpasswordHashed;
		this.accupdated = accupdated;
		this.accgroupPassport = accgroupPassport;
		this.accenumState = accenumState;
		this.accoverdue = accoverdue;
		this.accuserModelId = accuserModelId;
		this.accuserModelName = accuserModelName;
		this.accmodelXml = accmodelXml;
		this.accpoint = accpoint;
		this.accprestige = accprestige;
		this.accmoney = accmoney;
		this.accpublishCount = accpublishCount;
		this.accmodelName = accmodelName;
		this.accmodelConfig = accmodelConfig;
		this.accmodelSchema = accmodelSchema;
		this.accemailValidate = accemailValidate;
		this.accmodelState = accmodelState;
		this.pagevisitorhistories = pagevisitorhistories;
		this.logeses = logeses;
		this.pagevisitors = pagevisitors;
		this.statisticses = statisticses;
		this.roles = roles;
		this.statisticshistories = statisticshistories;
	}

	// Property accessors
	@Id
	@Column(name = "ACCID", unique = true, nullable = false)
	public Integer getAccid() {
		return this.accid;
	}

	public void setAccid(Integer accid) {
		this.accid = accid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POIID")
	public Point getPoint() {
		return this.point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Column(name = "ACCDescription")
	public String getAccdescription() {
		return this.accdescription;
	}

	public void setAccdescription(String accdescription) {
		this.accdescription = accdescription;
	}

	@Column(name = "ACCLoginName", length = 40)
	public String getAccloginName() {
		return this.accloginName;
	}

	public void setAccloginName(String accloginName) {
		this.accloginName = accloginName;
	}

	@Column(name = "ACCPassword", length = 40)
	public String getAccpassword() {
		return this.accpassword;
	}

	public void setAccpassword(String accpassword) {
		this.accpassword = accpassword;
	}

	@Column(name = "ACCHome")
	public Integer getAcchome() {
		return this.acchome;
	}

	public void setAcchome(Integer acchome) {
		this.acchome = acchome;
	}

	@Column(name = "ACCFirstName", length = 40)
	public String getAccfirstName() {
		return this.accfirstName;
	}

	public void setAccfirstName(String accfirstName) {
		this.accfirstName = accfirstName;
	}

	@Column(name = "ACCMiddleName", length = 40)
	public String getAccmiddleName() {
		return this.accmiddleName;
	}

	public void setAccmiddleName(String accmiddleName) {
		this.accmiddleName = accmiddleName;
	}

	@Column(name = "ACCEmail", length = 40)
	public String getAccemail() {
		return this.accemail;
	}

	public void setAccemail(String accemail) {
		this.accemail = accemail;
	}

	@Column(name = "ACCPhoto", length = 40)
	public String getAccphoto() {
		return this.accphoto;
	}

	public void setAccphoto(String accphoto) {
		this.accphoto = accphoto;
	}

	@Column(name = "ACCQQ", length = 40)
	public String getAccqq() {
		return this.accqq;
	}

	public void setAccqq(String accqq) {
		this.accqq = accqq;
	}

	@Column(name = "ACCState")
	public Integer getAccstate() {
		return this.accstate;
	}

	public void setAccstate(Integer accstate) {
		this.accstate = accstate;
	}

	@Column(name = "ACCUserType")
	public Integer getAccuserType() {
		return this.accuserType;
	}

	public void setAccuserType(Integer accuserType) {
		this.accuserType = accuserType;
	}

	@Column(name = "ACCSequenceIndex")
	public Integer getAccsequenceIndex() {
		return this.accsequenceIndex;
	}

	public void setAccsequenceIndex(Integer accsequenceIndex) {
		this.accsequenceIndex = accsequenceIndex;
	}

	@Column(name = "ACCCreated", length = 19)
	public Timestamp getAcccreated() {
		return this.acccreated;
	}

	public void setAcccreated(Timestamp acccreated) {
		this.acccreated = acccreated;
	}

	@Column(name = "ACCPasswordHashed")
	public Integer getAccpasswordHashed() {
		return this.accpasswordHashed;
	}

	public void setAccpasswordHashed(Integer accpasswordHashed) {
		this.accpasswordHashed = accpasswordHashed;
	}

	@Column(name = "ACCUpdated", length = 19)
	public Timestamp getAccupdated() {
		return this.accupdated;
	}

	public void setAccupdated(Timestamp accupdated) {
		this.accupdated = accupdated;
	}

	@Column(name = "ACCGroupPassport")
	public Integer getAccgroupPassport() {
		return this.accgroupPassport;
	}

	public void setAccgroupPassport(Integer accgroupPassport) {
		this.accgroupPassport = accgroupPassport;
	}

	@Column(name = "ACCEnumState", length = 40)
	public String getAccenumState() {
		return this.accenumState;
	}

	public void setAccenumState(String accenumState) {
		this.accenumState = accenumState;
	}

	@Column(name = "ACCOverdue", length = 19)
	public Timestamp getAccoverdue() {
		return this.accoverdue;
	}

	public void setAccoverdue(Timestamp accoverdue) {
		this.accoverdue = accoverdue;
	}

	@Column(name = "ACCUserModelID")
	public Integer getAccuserModelId() {
		return this.accuserModelId;
	}

	public void setAccuserModelId(Integer accuserModelId) {
		this.accuserModelId = accuserModelId;
	}

	@Column(name = "ACCUserModelName", length = 40)
	public String getAccuserModelName() {
		return this.accuserModelName;
	}

	public void setAccuserModelName(String accuserModelName) {
		this.accuserModelName = accuserModelName;
	}

	@Column(name = "ACCModelXml", length = 65535)
	public String getAccmodelXml() {
		return this.accmodelXml;
	}

	public void setAccmodelXml(String accmodelXml) {
		this.accmodelXml = accmodelXml;
	}

	@Column(name = "ACCPoint")
	public Integer getAccpoint() {
		return this.accpoint;
	}

	public void setAccpoint(Integer accpoint) {
		this.accpoint = accpoint;
	}

	@Column(name = "ACCPrestige")
	public Integer getAccprestige() {
		return this.accprestige;
	}

	public void setAccprestige(Integer accprestige) {
		this.accprestige = accprestige;
	}

	@Column(name = "ACCMoney", precision = 10, scale = 0)
	public Long getAccmoney() {
		return this.accmoney;
	}

	public void setAccmoney(Long accmoney) {
		this.accmoney = accmoney;
	}

	@Column(name = "ACCPublishCount")
	public Integer getAccpublishCount() {
		return this.accpublishCount;
	}

	public void setAccpublishCount(Integer accpublishCount) {
		this.accpublishCount = accpublishCount;
	}

	@Column(name = "ACCModelName", length = 40)
	public String getAccmodelName() {
		return this.accmodelName;
	}

	public void setAccmodelName(String accmodelName) {
		this.accmodelName = accmodelName;
	}

	@Column(name = "ACCModelConfig", length = 65535)
	public String getAccmodelConfig() {
		return this.accmodelConfig;
	}

	public void setAccmodelConfig(String accmodelConfig) {
		this.accmodelConfig = accmodelConfig;
	}

	@Column(name = "ACCModelSchema", length = 65535)
	public String getAccmodelSchema() {
		return this.accmodelSchema;
	}

	public void setAccmodelSchema(String accmodelSchema) {
		this.accmodelSchema = accmodelSchema;
	}

	@Column(name = "ACCEmailValidate")
	public Integer getAccemailValidate() {
		return this.accemailValidate;
	}

	public void setAccemailValidate(Integer accemailValidate) {
		this.accemailValidate = accemailValidate;
	}

	@Column(name = "ACCModelState")
	public Integer getAccmodelState() {
		return this.accmodelState;
	}

	public void setAccmodelState(Integer accmodelState) {
		this.accmodelState = accmodelState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Pagevisitorhistory> getPagevisitorhistories() {
		return this.pagevisitorhistories;
	}

	public void setPagevisitorhistories(
			Set<Pagevisitorhistory> pagevisitorhistories) {
		this.pagevisitorhistories = pagevisitorhistories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Loges> getLogeses() {
		return this.logeses;
	}

	public void setLogeses(Set<Loges> logeses) {
		this.logeses = logeses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Pagevisitor> getPagevisitors() {
		return this.pagevisitors;
	}

	public void setPagevisitors(Set<Pagevisitor> pagevisitors) {
		this.pagevisitors = pagevisitors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Statistics> getStatisticses() {
		return this.statisticses;
	}

	public void setStatisticses(Set<Statistics> statisticses) {
		this.statisticses = statisticses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Statisticshistory> getStatisticshistories() {
		return this.statisticshistories;
	}

	public void setStatisticshistories(
			Set<Statisticshistory> statisticshistories) {
		this.statisticshistories = statisticshistories;
	}

}