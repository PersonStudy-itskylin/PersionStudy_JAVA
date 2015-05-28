package com.bolo.examples.dao.base;

import org.springframework.stereotype.Repository;

import com.bolo.examples.common.orm.hibernate3.HibernateDao;
import com.bolo.examples.entity.base.User;

/**
 * 人员管理
 * @author 菠萝大象
 */
@Repository
public class UserDao extends HibernateDao<User>{

}