package com.bolo.examples.entity.base;

import java.io.Serializable;

import javax.persistence.*;


/**
 * 人员管理
 * @author 菠萝大象
 */
@Entity
@Table
public class User implements Serializable{                                                                                                                                                                                                                                                                     

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer user_id;      //主键
	private String name;     //登录用户
	private Role role;       //角色ID
	
	
	public String getName() {
		return name;
	}
	@Id
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
