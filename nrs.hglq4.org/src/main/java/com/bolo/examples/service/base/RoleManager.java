package com.bolo.examples.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.dao.base.RoleDao;
import com.bolo.examples.entity.base.Role;

/**
 * 角色管理
 * @author 菠萝大象
 */
@Service
public class RoleManager {

	@Autowired
	private RoleDao roleDao;
	
	/**
	 * 取得所有角色信息
	 */
	public List<Role> getRoles(){
		return roleDao.getRoles();
	}
	
	public Role getRole(Serializable id){
		return roleDao.get(id);
	}
}
