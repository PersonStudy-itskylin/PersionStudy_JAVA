package cn.hglq4.eshop.entity;

import java.io.Serializable;
import java.sql.Date;

public class login implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6335129235437066722L;
	
	private int id;
	private String account;
	private String roleName;
	private String ip;
	private Date logintime;
	
	public login() {
		// TODO 自动生成的构造函数存根
		super();
	}
	public login(int id,String account,String roleName,String ip,Date logintime) {
		this.id = id;
		this.account = account;
		this.roleName = roleName;
		this.ip = ip;
		this.logintime = logintime;
		// TODO 自动生成的构造函数存根
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return acount
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param acount 要设置的 acount
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return role
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param role 要设置的 role
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip 要设置的 ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return logintime
	 */
	public Date getLogintime() {
		return logintime;
	}
	/**
	 * @param logintime 要设置的 logintime
	 */
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
}
