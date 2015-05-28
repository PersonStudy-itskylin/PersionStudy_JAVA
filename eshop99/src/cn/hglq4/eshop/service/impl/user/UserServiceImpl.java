package cn.hglq4.eshop.service.impl.user;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hglq4.eshop.dao.user.IUserDAO;
import cn.hglq4.eshop.entity.user.Users;
import cn.hglq4.eshop.service.ServiceException;
import cn.hglq4.eshop.service.user.IUserService;
import cn.hglq4.eshop.vo.user.UsersVO;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDAO userDAOImpl;

	@Override
	public void add(UsersVO vo) throws ServiceException {
		Users entity=new Users();
		BeanUtils.copyProperties(vo, entity);
		userDAOImpl.save(entity);

	}


	@Override
	public UsersVO login(String account, String pwd) throws ServiceException {
		Users u=userDAOImpl.login(account, pwd);
		UsersVO vo=new UsersVO();
		BeanUtils.copyProperties(u, vo);
		
		return vo;
	}

}
