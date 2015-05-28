package com.bolo.examples.dao.base;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bolo.examples.common.orm.hibernate3.HibernateDao;
import com.bolo.examples.entity.base.Role;

/**
 * 角色管理
 * @author 菠萝大象
 */
@Repository
public class RoleDao extends HibernateDao<Role>{

	public List<Role> getRoles(){
		return super.getAll();
	}
}
