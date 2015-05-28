package cn.hglq4.eshop.dao.user;

import cn.hglq4.eshop.dao.IGenericDAO;
import cn.hglq4.eshop.entity.user.Users;


public interface IUserDAO extends IGenericDAO<Users,Integer> {
	public Users login(String account,String pwd);
	

}
