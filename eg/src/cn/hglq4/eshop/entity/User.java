package cn.hglq4.eshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	private String userName;
	private String loginName;
	private String pwd;
	private int sex;
	private java.sql.Date birthdate;
	private String photo;
	private String country;
	private String province;
	private String city;
	private String address;
	private String tel;
	private String email;
	private String qq;
	private int pwdQuestion1;
	private String pwdAnser1;
	private int pwdQuestion2;
	private String pwdAnser2;
	private int pwdQuestion3;
	private String pwdAnser3;
	private int married;
	private String like;
	private String description;
	private String ethnic;
	private String education;
	private String job;
	private String party;
	private String ipaddress;
	private String creator;
	private String editor;
	private java.sql.Date createtime;
	private java.sql.Timestamp updatetime;
	private String remark;

	public User(int userId, String userName, String loginName, String pwd,
			int sex, java.sql.Date birthdate, String photo, String country,
			String province, String city, String address, String tel,
			String email, String qq, int pwdQuestion1, String pwdAnser1,
			int pwdQuestion2, String pwdAnser2, int pwdQuestion3,
			String pwdAnser3, int married, String like, String description,
			String ethnic, String education, String job, String party,
			String ipaddress, String creator, String editor,
			java.sql.Date createtime, java.sql.Timestamp updatetime,
			String remark) {
		// TODO 自动生成的构造函数存根
		super();
		this.userId = userId;
		this.userName = userName;
		this.loginName = loginName;
		this.pwd = pwd;
		this.sex = sex;
		this.birthdate = birthdate;
		this.photo = photo;
		this.country = country;
		this.province = province;
		this.city = city;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.qq = qq;
		this.pwdQuestion1 = pwdQuestion1;
		this.pwdAnser1 = pwdAnser1;
		this.pwdQuestion2 = pwdQuestion2;
		this.pwdAnser2 = pwdAnser2;
		this.pwdQuestion3 = pwdQuestion3;
		this.pwdAnser3 = pwdAnser3;
		this.married = married;
		this.like = like;
		this.description = description;
		this.ethnic = ethnic;
		this.education = education;
		this.job = job;
		this.party = party;
		this.ipaddress = ipaddress;
		this.creator = creator;
		this.editor = editor;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.remark = remark;
	}

	public User() {
		// TODO 自动生成的构造函数存根
		super();
	}

	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            要设置的 userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName
	 *            要设置的 loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            要设置的 pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            要设置的 sex
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return birthdate
	 */
	public java.sql.Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate
	 *            要设置的 birthdate
	 */
	public void setBirthdate(java.sql.Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            要设置的 photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            要设置的 country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 *            要设置的 province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            要设置的 city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            要设置的 tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq
	 *            要设置的 qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return pwdQuestion1
	 */
	public int getPwdQuestion1() {
		return pwdQuestion1;
	}

	/**
	 * @param pwdQuestion1
	 *            要设置的 pwdQuestion1
	 */
	public void setPwdQuestion1(int pwdQuestion1) {
		this.pwdQuestion1 = pwdQuestion1;
	}

	/**
	 * @return pwdAnser1
	 */
	public String getPwdAnser1() {
		return pwdAnser1;
	}

	/**
	 * @param pwdAnser1
	 *            要设置的 pwdAnser1
	 */
	public void setPwdAnser1(String pwdAnser1) {
		this.pwdAnser1 = pwdAnser1;
	}

	/**
	 * @return pwdQuestion2
	 */
	public int getPwdQuestion2() {
		return pwdQuestion2;
	}

	/**
	 * @param pwdQuestion2
	 *            要设置的 pwdQuestion2
	 */
	public void setPwdQuestion2(int pwdQuestion2) {
		this.pwdQuestion2 = pwdQuestion2;
	}

	/**
	 * @return pwdAnser2
	 */
	public String getPwdAnser2() {
		return pwdAnser2;
	}

	/**
	 * @param pwdAnser2
	 *            要设置的 pwdAnser2
	 */
	public void setPwdAnser2(String pwdAnser2) {
		this.pwdAnser2 = pwdAnser2;
	}

	/**
	 * @return pwdQuestion3
	 */
	public int getPwdQuestion3() {
		return pwdQuestion3;
	}

	/**
	 * @param pwdQuestion3
	 *            要设置的 pwdQuestion3
	 */
	public void setPwdQuestion3(int pwdQuestion3) {
		this.pwdQuestion3 = pwdQuestion3;
	}

	/**
	 * @return pwdAnser3
	 */
	public String getPwdAnser3() {
		return pwdAnser3;
	}

	/**
	 * @param pwdAnser3
	 *            要设置的 pwdAnser3
	 */
	public void setPwdAnser3(String pwdAnser3) {
		this.pwdAnser3 = pwdAnser3;
	}

	/**
	 * @return married
	 */
	public int getMarried() {
		return married;
	}

	/**
	 * @param married
	 *            要设置的 married
	 */
	public void setMarried(int married) {
		this.married = married;
	}

	/**
	 * @return like
	 */
	public String getLike() {
		return like;
	}

	/**
	 * @param like
	 *            要设置的 like
	 */
	public void setLike(String like) {
		this.like = like;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return ethnic
	 */
	public String getEthnic() {
		return ethnic;
	}

	/**
	 * @param ethnic
	 *            要设置的 ethnic
	 */
	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	/**
	 * @return education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education
	 *            要设置的 education
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            要设置的 job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return party
	 */
	public String getParty() {
		return party;
	}

	/**
	 * @param party
	 *            要设置的 party
	 */
	public void setParty(String party) {
		this.party = party;
	}

	/**
	 * @return ipaddress
	 */
	public String getIpaddress() {
		return ipaddress;
	}

	/**
	 * @param ipaddress
	 *            要设置的 ipaddress
	 */
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	/**
	 * @return creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            要设置的 creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return editor
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * @param editor
	 *            要设置的 editor
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * @return createtime
	 */
	public java.sql.Date getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *            要设置的 createtime
	 */
	public void setCreatetime(java.sql.Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return updatetime
	 */
	public Timestamp getUpdatetime() {
		return updatetime;
	}

	/**
	 * @param updatetime
	 *            要设置的 updatetime
	 */
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
