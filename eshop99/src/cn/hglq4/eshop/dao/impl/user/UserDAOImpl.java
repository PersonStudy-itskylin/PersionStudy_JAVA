package cn.hglq4.eshop.dao.impl.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hglq4.eshop.dao.impl.GenericDAOImpl;
import cn.hglq4.eshop.dao.user.IUserDAO;
import cn.hglq4.eshop.entity.user.Users;

@Repository
public class UserDAOImpl extends GenericDAOImpl<Users,Integer> implements IUserDAO {
	
	@Override
	public Users login(String account, String pwd) {
		List<Users> list=getHibernateTemplate().find("from Users where account=? and pwd=?", new Object[]{account,pwd});
		if(list!=null&&list.size()==1){
			return list.get(0);
		}else{
		    return null;
		}
	}
}
