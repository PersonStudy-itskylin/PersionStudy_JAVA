package cn.hglq4.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.hglq4.eshop.entity.login;

public class loginDAO extends AbstractDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ArrayList<login> loginList = new ArrayList<login>();
	private ResultSet rs;
	//查询所有登陆记录
	public ArrayList<login> selectAll() {
		// TODO 自动生成的方法存根
		String sql = "SELECT * FROM T_LOGIN";
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			login login = new login();
			while(rs.next()){
				login.setAccount(rs.getString("account"));
				login.setRoleName(rs.getString("roleName"));
				login.setIp(rs.getString("ip"));
				login.setLogintime(rs.getDate("logintime"));
				loginList.add(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt, null, null);
		}
		
		return loginList;
	}
	//添加登陆记录
	public boolean addLogin(login login) {
		// TODO 自动生成的方法存根
		boolean result = false;
		String sql = new StringBuffer("INSERT INTO T_LOGIN(")
				.append("account,")
				.append("roleName,")
				.append("ip,")
				.append("logintime")
				.append(")VALUES(?,?,?,NOW())")
				.toString();
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getAccount());
			pstmt.setString(2, login.getRoleName());
			pstmt.setString(3, login.getIp());
			result = (pstmt.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, null, pstmt, null);
		}
		return result;
	}
	
	
	
	//Testing data
	/*public static void main(String[] args) {
		login login = new login();
		loginDAO loginDao = new loginDAO();
		for(int i =1230;i<2345;i++){
			login.setAccount("linwei151" + i);
			login.setRoleName("超级管理员" + i);
			login.setIp("127.0.0." + i);
			
			loginDao.addLogin(login);
		}
		loginDao.selectAll();
	}*/
}
