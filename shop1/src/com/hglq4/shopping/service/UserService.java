package com.hglq4.shopping.service;

import java.util.List;

import com.hglq4.shopping.model.User;
/**
 * 
 * @author Blue_Sky
 *
 */
public interface UserService {
	/**�û�ע��*/
	public User register(User user) throws Exception;
	/**ɾ���û�*/
	public boolean remove(String[] ids);
	/**�޸��û�*/
	public boolean modify(User p);
	/**��ѯ�����û�*/
	public List<User> getPersons();
	/**分页显示所有用户*/
	public List<User> getPersons(int start, int end);
	/**�û���½*/
	public User login(String name,String password)throws IndexOutOfBoundsException;
	/**����û����Ƿ����*/
	public boolean checkUserName(String username);
	
	public int getCount();
}
