package cn.hglq4.eshop.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.hglq4.eshop.service.ServiceException;
import cn.hglq4.eshop.service.user.IUserService;
import cn.hglq4.eshop.vo.user.UsersVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="test.xml")

public class TestUser {
	@Autowired
	private IUserService userServiceImpl;
	private UsersVO vo=null;

	@Before
	public void setUp() throws Exception {
		 vo=new UsersVO();
		 vo.setAccount("admin14");
		 vo.setPwd("12345");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		try {
			vo=userServiceImpl.login("admin", "123");
			System.out.println(vo.getLoginDate());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void testAdd() {
		try {
			userServiceImpl.add(vo);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}*/

}
