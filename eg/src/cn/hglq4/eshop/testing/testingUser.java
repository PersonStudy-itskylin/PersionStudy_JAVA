package cn.hglq4.eshop.testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.hglq4.eshop.dao.AbstractDAO;
import cn.hglq4.eshop.dao.UserDAO;
import cn.hglq4.eshop.entity.User;

public class testingUser extends AbstractDAO {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 查询所有用户
	public void selectAll() {
		Connection conn = null;
		String sql = "SELECT * FROM T_USER ORDER BY UPDATETIME DESC";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("user_id") + "  , "
						+ rs.getString("user_name") + "  , "
						+ rs.getString("loginname") + "  , "
						+ rs.getString("pwd") + "  , " + rs.getInt("sex")
						+ "  , " + rs.getDate("birthdate") + "  , "
						+ rs.getString("photo") + "  , "
						+ rs.getString("country") + "  , "
						+ rs.getString("province") + "  , "
						+ rs.getString("city") + "  , "
						+ rs.getString("address") + "  , "
						+ rs.getString("tel") + "  , " + rs.getString("email")
						+ "  , " + rs.getString("qq") + "  , "
						+ rs.getInt("pwd_question1") + "  , "
						+ rs.getString("pwd_anser1") + "  , "
						+ rs.getInt("pwd_question2") + "  , "
						+ rs.getString("pwd_anser2") + "  , "
						+ rs.getInt("pwd_question3") + "  , "
						+ rs.getString("pwd_anser3") + "  , "
						+ rs.getInt("married") + "  , " + rs.getString("love")
						+ "  , " + rs.getString("description") + "  , "
						+ rs.getString("ethnic") + "  , "
						+ rs.getString("education") + "  , "
						+ rs.getString("job") + "  , " + rs.getString("party")
						+ "  , " + rs.getString("ipaddress") + "  , "
						+ rs.getString("creator") + "  , "
						+ rs.getString("editor") + "  , "
						+ rs.getDate("createtime") + "  , "
						+ rs.getTimestamp("updatetime") + "  , "
						+ rs.getString("remark"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			closeResource(conn, null, pstmt, rs);
		}
	}
	
	public static void main(String[] args) {
		int i = (int)(Math.random()*100000);
		for (; i <=  (i + 1487); i++) {
			User user = new User();
			user.setUserName("linwei1512351" + i);
			user.setPwd("123");
			if (i / 2 == 0) {
				user.setSex(0);
			} else {
				user.setSex(1);
			}
			user.setBirthdate(new java.sql.Date(System.currentTimeMillis()));
			user.setPhoto("暂无" + i);
			user.setCountry("中国" + i);
			user.setProvince("湖北" + i);
			user.setCity("黄冈" + i);
			user.setAddress("黄冈市新港二路4" + i + "号");

			user.setTel("123456789" + i);
			user.setEmail("34506" + i + "@qq.com");
			user.setQq("34506" + i);

			user.setPwdQuestion1(1);
			user.setPwdAnser1("456");
			user.setPwdQuestion2(2);
			user.setPwdAnser2("456");
			user.setPwdQuestion3(3);
			user.setPwdAnser3("456");
			if (i / 2 == 0) {
				user.setMarried(0);
			} else {
				user.setMarried(1);
			}
			user.setLike("计算机" + i);
			user.setDescription("暂无详细说明" + i);
			user.setEthnic("汉族" + i);
			user.setEducation("博士后" + i);
			user.setJob("程序猿" + i);
			user.setParty("123" + i);
			user.setCreator("admin" + i);
			user.setEditor("admin" + i);
			user.setRemark("暂无详细说明" + i);
			user.setCreatetime(new java.sql.Date(System.currentTimeMillis()));

			UserDAO db = new UserDAO();
			System.out.println(db.addUser(user));

		}
		
		
		/*------------------------------*/
		new testingUser().selectAll();
	}
}
