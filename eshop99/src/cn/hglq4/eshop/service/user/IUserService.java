package cn.hglq4.eshop.service.user;

import cn.hglq4.eshop.service.ServiceException;
import cn.hglq4.eshop.vo.user.UsersVO;

public interface IUserService{
	public void add(UsersVO vo) throws ServiceException;
	public UsersVO login(String account,String pwd) throws ServiceException;

}
