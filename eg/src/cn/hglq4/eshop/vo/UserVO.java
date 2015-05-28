package cn.hglq4.eshop.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class UserVO {
	
	private int userId;//ID
	private String userName;//账号
	private String loginName;//姓名
	private String pwd;//密码
	private String pwd2;//确认密码
	private String verifyCode;//验证码
	private int sex;
	private Date birthdate;
	private String photo;
	private String country;
	private String province;
	private String city;
	private String address;
	private String tel;
	private String email;
	private String qq;
	private String pwdQuestion1;
	private String pwdAnser1;
	private String pwdQuestion2;
	private String pwdAnser2;
	private String pwdQuestion3;
	private String pwdAnser3;
	private int married;//婚否
	private List<String> like;//爱好  泛型
	private String description;//自我介绍
	private String ethnic;
	private String education;
	private String job;
	private String party;
	private String creator;
	private String editor;
	private Date createtime;
	private Timestamp updatetime;
	private String remark;
	
	
	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * @param userId 要设置的 userId
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
	 * @param userName 要设置的 userName
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
	 * @param loginName 要设置的 loginName
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
	 * @param pwd 要设置的 pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	/**
	 * @return pwd2
	 */
	public String getPwd2() {
		return pwd2;
	}


	/**
	 * @param pwd2 要设置的 pwd2
	 */
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}


	/**
	 * @return verifyCode
	 */
	public String getVerifyCode() {
		return verifyCode;
	}


	/**
	 * @param verifyCode 要设置的 verifyCode
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}


	/**
	 * @return sex
	 */
	public int getSex() {
		return sex;
	}


	/**
	 * @param sex 要设置的 sex
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}


	/**
	 * @return birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}


	/**
	 * @param birthdate 要设置的 birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	/**
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}


	/**
	 * @param photo 要设置的 photo
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
	 * @param country 要设置的 country
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
	 * @param province 要设置的 province
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
	 * @param city 要设置的 city
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
	 * @param address 要设置的 address
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
	 * @param tel 要设置的 tel
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
	 * @param email 要设置的 email
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
	 * @param qq 要设置的 qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}


	/**
	 * @return pwdQuestion1
	 */
	public String getPwdQuestion1() {
		return pwdQuestion1;
	}


	/**
	 * @param pwdQuestion1 要设置的 pwdQuestion1
	 */
	public void setPwdQuestion1(String pwdQuestion1) {
		this.pwdQuestion1 = pwdQuestion1;
	}


	/**
	 * @return pwdAnser1
	 */
	public String getPwdAnser1() {
		return pwdAnser1;
	}


	/**
	 * @param pwdAnser1 要设置的 pwdAnser1
	 */
	public void setPwdAnser1(String pwdAnser1) {
		this.pwdAnser1 = pwdAnser1;
	}


	/**
	 * @return pwdQuestion2
	 */
	public String getPwdQuestion2() {
		return pwdQuestion2;
	}


	/**
	 * @param pwdQuestion2 要设置的 pwdQuestion2
	 */
	public void setPwdQuestion2(String pwdQuestion2) {
		this.pwdQuestion2 = pwdQuestion2;
	}


	/**
	 * @return pwdAnser2
	 */
	public String getPwdAnser2() {
		return pwdAnser2;
	}


	/**
	 * @param pwdAnser2 要设置的 pwdAnser2
	 */
	public void setPwdAnser2(String pwdAnser2) {
		this.pwdAnser2 = pwdAnser2;
	}


	/**
	 * @return pwdQuestion3
	 */
	public String getPwdQuestion3() {
		return pwdQuestion3;
	}


	/**
	 * @param pwdQuestion3 要设置的 pwdQuestion3
	 */
	public void setPwdQuestion3(String pwdQuestion3) {
		this.pwdQuestion3 = pwdQuestion3;
	}


	/**
	 * @return pwdAnser3
	 */
	public String getPwdAnser3() {
		return pwdAnser3;
	}


	/**
	 * @param pwdAnser3 要设置的 pwdAnser3
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
	 * @param married 要设置的 married
	 */
	public void setMarried(int married) {
		this.married = married;
	}


	/**
	 * @return like
	 */
	public List<String> getLike() {
		return like;
	}


	/**
	 * @param like 要设置的 like
	 */
	public void setLike(List<String> like) {
		this.like = like;
	}


	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description 要设置的 description
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
	 * @param ethnic 要设置的 ethnic
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
	 * @param education 要设置的 education
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
	 * @param job 要设置的 job
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
	 * @param party 要设置的 party
	 */
	public void setParty(String party) {
		this.party = party;
	}


	/**
	 * @return creator
	 */
	public String getCreator() {
		return creator;
	}


	/**
	 * @param creator 要设置的 creator
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
	 * @param editor 要设置的 editor
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}


	/**
	 * @return createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}


	/**
	 * @param createtime 要设置的 createtime
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	/**
	 * @return updatetime
	 */
	public Timestamp getUpdatetime() {
		return updatetime;
	}


	/**
	 * @param updatetime 要设置的 updatetime
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
	 * @param remark 要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}


	public UserVO() {
		// TODO 自动生成的构造函数存根
	}
}
