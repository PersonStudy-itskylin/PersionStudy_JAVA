package cn.hglq4.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.hglq4.eshop.entity.User;

public class UserDAO extends AbstractDAO{
	
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	public ArrayList<User> userlist =new ArrayList<User>();
	
	//查询所有用户
	public void selectAll(){
		Connection conn = null;
		String sql =  "SELECT * FROM T_USER ORDER BY UPDATETIME DESC";
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				User user = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("loginname"), rs.getString("pwd"), rs.getInt("sex"), rs.getDate("birthdate"), rs.getString("photo"), rs.getString("country"), rs.getString("province"), rs.getString("city"), rs.getString("address"), rs.getString("tel"), rs.getString("email"), rs.getString("qq"), rs.getInt("pwd_question1"), rs.getString("pwd_anser1"), rs.getInt("pwd_question2"), rs.getString("pwd_anser2"), rs.getInt("pwd_question3"), rs.getString("pwd_anser3"), rs.getInt("married"), rs.getString("love"), rs.getString("description"), rs.getString("ethnic"), rs.getString("education"), rs.getString("job"), rs.getString("party"),rs.getString("ipaddress"), rs.getString("creator"), rs.getString("editor"), rs.getDate("createtime"), rs.getTimestamp("updatetime"),rs.getString("remark"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			closeResource(conn, stmt, pstmt, rs);
		}
	}
	
	//检查用户名是否重复
	public boolean checkUser(String userName){
		boolean result = true;//TRUE  不存在，false  存在
		Connection conn = null;
		String sql =  "SELECT USER_NAME FROM T_USER WHERE USER_NAME=?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			closeResource(conn, null, pstmt, rs);
		}
		return result;
	}
	
	//注册添加用户
	public boolean addUser(User user){
		boolean result = false;
		Connection conn = null;
		StringBuffer sql = new StringBuffer("INSERT INTO T_USER(")
				.append("user_name,")
		 		.append("loginname,")
		 		.append("pwd,")
		 		.append("sex,")
		 		.append("birthdate,")
		 		.append("photo,")
		 		.append("country,")
		 		.append("province,")
		 		.append("city,")
		 		.append("address,")
		 		.append("tel,")
		 		.append("email,")
		 		.append("qq,")
		 		.append("pwd_question1,")
		 		.append("pwd_anser1,")
		 		.append("pwd_question2,")
		 		.append("pwd_anser2,")
		 		.append("pwd_question3,")
		 		.append("pwd_anser3,")
		 		.append("married,")
		 		.append("love,")
		 		.append("description,")
		 		.append("ethnic,")
		 		.append("education,")
		 		.append("job,")
		 		.append("party,")
		 		.append("creator,")
		 		.append("editor,")
		 		.append("createtime,")
		 		.append("remark,")
		 		.append("ipaddress")
		 		.append(") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?);");//
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getLoginName());
			pstmt.setString(3, user.getPwd());
			pstmt.setInt(4, user.getSex());
			pstmt.setDate(5,user.getBirthdate());
			pstmt.setString(6, user.getPhoto());
			pstmt.setString(7, user.getCountry());
			pstmt.setString(8, user.getProvince());
			pstmt.setString(9, user.getCity());
			pstmt.setString(10, user.getAddress());
			pstmt.setString(11, user.getTel());
			pstmt.setString(12, user.getEmail());
			pstmt.setString(13, user.getQq());
			pstmt.setInt(14, user.getPwdQuestion1());
			pstmt.setString(15, user.getPwdAnser1());
			pstmt.setInt(16, user.getPwdQuestion2());
			pstmt.setString(17, user.getPwdAnser2());
			pstmt.setInt(18, user.getPwdQuestion3());
			pstmt.setString(19, user.getPwdAnser3());
			pstmt.setInt(20, user.getMarried());
			pstmt.setString(21, user.getLike());
			pstmt.setString(22, user.getDescription());
			pstmt.setString(23, user.getEthnic());
			pstmt.setString(24, user.getEducation());
			pstmt.setString(25, user.getJob());
			pstmt.setString(26, user.getParty());
			pstmt.setString(27, user.getCreator());
			pstmt.setString(28, user.getEditor());
			pstmt.setString(29, user.getRemark());
			pstmt.setString(30, user.getIpaddress());
			result = (pstmt.executeUpdate()>0);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			closeResource(conn, null, pstmt, rs);
		}
		return result;
	}
	
	
	//修改用户信息
	public boolean eidtUser(User user){
		boolean result = false;
		Connection conn = null;
		StringBuffer sql = new StringBuffer("UPDATE FROM T_USER SET ")
		 		.append("loginname=?,")
		 		.append("pwd=?,")
		 		.append("sex=?,")
		 		.append("birthdate=?,")
		 		.append("photo=?,")
		 		.append("country=?,")
		 		.append("province=?,")
		 		.append("city=?,")
		 		.append("address=?,")
		 		.append("tel=?,")
		 		.append("email=?,")
		 		.append("qq=?,")
		 		.append("pwd_question1=?,")
		 		.append("pwd_anser1=?,")
		 		.append("pwd_question2=?,")
		 		.append("pwd_anser2=?,")
		 		.append("pwd_question3=?,")
		 		.append("pwd_anser3=?,")
		 		.append("married=?,")
		 		.append("love=?,")
		 		.append("description=?,")
		 		.append("ethnic=?,")
		 		.append("education=?,")
		 		.append("job=?,")
		 		.append("party=?,")
		 		.append("editor=?,")
		 		.append("remark=?")
		 		.append(" WHERE USER_NAME=?");
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getLoginName());
			pstmt.setString(2, user.getPwd());
			pstmt.setInt(3, user.getSex());
			pstmt.setDate(4, user.getBirthdate());
			pstmt.setString(5,user.getPhoto());
			pstmt.setString(6, user.getCountry());
			pstmt.setString(7, user.getProvince());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getAddress());
			pstmt.setString(10, user.getTel());
			pstmt.setString(11, user.getEmail());
			pstmt.setString(12, user.getQq());
			pstmt.setInt(13, user.getPwdQuestion1());
			pstmt.setString(14, user.getPwdAnser1());
			pstmt.setInt(15, user.getPwdQuestion2());
			pstmt.setString(16, user.getPwdAnser2());
			pstmt.setInt(17, user.getPwdQuestion3());
			pstmt.setString(18, user.getPwdAnser3());
			pstmt.setInt(29, user.getMarried());
			pstmt.setString(20, user.getLike());
			pstmt.setString(21, user.getDescription());
			pstmt.setString(22, user.getEthnic());
			pstmt.setString(23, user.getEducation());
			pstmt.setString(24, user.getJob());
			pstmt.setString(25, user.getParty());
			pstmt.setString(26, user.getEditor());
			pstmt.setString(27, user.getRemark());
			pstmt.setString(28, user.getUserName());
			
			result = (pstmt.executeUpdate()>0)?true:false;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			closeResource(conn, null, pstmt, rs);
		}
		return result;
	}
	
	//删除用户（id）
	public boolean delUser(String userId){
		boolean result = false;
		Connection conn = null;
		String sql =  "DELETE FROM T_USER WHERE USER_ID=?";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			if(pstmt.executeUpdate()>0){
				result = true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			closeResource(conn, null, pstmt, rs);
		}
		return result;
	}
}
