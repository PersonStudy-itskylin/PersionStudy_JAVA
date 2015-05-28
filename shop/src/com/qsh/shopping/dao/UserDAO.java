package com.qsh.shopping.dao;

import java.util.List;

import com.qsh.shopping.model.User;
/**
 * �û���ݷ��ʶ���ӿ�
 * @author ��ʢ��
 */
public interface UserDAO {
	/**�û�ע��*/
	public User save(User user);
	/**ɾ���û�*/
	public boolean delete(int id);
	/**�޸��û�*/
	public boolean update(User user);
	/**��ѯ�����û�*/
	public List<User> findAll();
	/**分页显示所有用户*/
	public List<User> findAll(int start, int end);
	/**�û���½*/
	public User login(String name,String password)throws IndexOutOfBoundsException;
	/**����û����Ƿ����,���ڷ���true,���򷵻�false*/
	public boolean checkUserName(String username);
}
