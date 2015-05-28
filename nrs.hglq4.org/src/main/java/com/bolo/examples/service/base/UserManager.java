package com.bolo.examples.service.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.common.web.Page;
import com.bolo.examples.dao.base.UserDao;
import com.bolo.examples.entity.base.User;

/**
 * 人员管理
 * @author 菠萝大象
 */
@Service
public class UserManager {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 根据条件查询
	 */
	@SuppressWarnings("rawtypes")
	public List queryResult(HttpServletRequest request){
		List<Criterion> criterions = new ArrayList<Criterion>();
		String name = request.getParameter("name");
		if(StringUtils.isNotBlank(name))
			criterions.add(Restrictions.like("name",name,MatchMode.ANYWHERE));
		String role_id = request.getParameter("role_id");
		if(StringUtils.isNotBlank(role_id))
			criterions.add(Restrictions.eq("role.id",Integer.valueOf(role_id)));
		return userDao.query(criterions.toArray(new Criterion[criterions.size()]));
	}
	
	public User getUser(Serializable id){
		return userDao.get(id);
	}
	
	/**
	 * @param currentPage 当前页
	 * @param pageSize 每页大小
	 * @param hql 查询语句
	 * @return Page<User> 返回一个页面，包含：totalRows,pageSize,currentPage,totalPages,startRow
	 */
	public Page<User> getUsersByPage(int currentPage,int pageSize){
		
		return userDao.page(currentPage, pageSize);
	}
	
	
}
