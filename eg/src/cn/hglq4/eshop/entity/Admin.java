package cn.hglq4.eshop.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9118986366868408141L;
	
	private int manager;
	private String account;
	private String pwd;
	private int role;
	private String creator;
	private String editor;
	private Date createtime;
	private Timestamp updatetime;
	private String remark;
	
	/**
	 * @return manager
	 */
	public int getManager() {
		return manager;
	}
	/**
	 * @param manager 要设置的 manager
	 */
	public void setManager(int manager) {
		this.manager = manager;
	}
	/**
	 * @return account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account 要设置的 account
	 */
	public void setAccount(String account) {
		this.account = account;
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
	 * @return role
	 */
	public int getRole() {
		return role;
	}
	/**
	 * @param role 要设置的 role
	 */
	public void setRole(int role) {
		this.role = role;
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
	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Admin(int manager,String account,String pwd,int role,String creator,String editor,Date createtime,Timestamp updatetime,String remark) {
		// TODO 自动生成的构造函数存根
		super();
		this.manager = manager;
		this.account = account;
		this.pwd = pwd;
		this.role = role;
		this.creator = creator;
		this.editor = editor;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.remark = remark;
	}
	public Admin() {
		// TODO 自动生成的构造函数存根
		super();
	}
	
}
