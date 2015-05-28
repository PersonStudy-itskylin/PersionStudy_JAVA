package com.qsh.shopping.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �û�ʵ����
 * @author ��ʢ��
 */
@Entity 
@Table(name="t_user")
public class User {
	/**��Ա���*/
	private int id;
	/**�˺�*/
	private String name;
	/**����*/
	private String password;
	/**�Ա�*/
	private boolean sex;
	/**�绰*/
	private long phone;
	/**QQ����*/
	private long QQ;
	/**����*/
	private String email;
	/**��ͥסַ*/
	private String addr;
	
	private Date regDate;
	
	private String IP;
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String ip) {
		IP = ip;
	}
	@Id
	@GeneratedValue
	//@GeneratedValue(generator = "paymentableGenerator")    
	//@GenericGenerator(name = "paymentableGenerator", strategy = "assigned") 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=15,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getQQ() {
		return QQ;
	}
	public void setQQ(long qq) {
		QQ = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
