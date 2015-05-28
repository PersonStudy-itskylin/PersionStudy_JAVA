package cn.login;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.dao.DBConn;
import cn.dao.DBqueryAll;

public class DBlogin extends DBqueryAll{
	Statement state = null;
	ResultSet rs = null;
	DBConn db = new DBConn();
	
	public boolean ifUser(String user,String pwd) {
		// TODO 自动生成的方法存根
		boolean result=false;
		String sql = "SELECT g.userno,pwd,gr_no FROM [users] u,[geren] g where  u.userno=g.userno";
		state = db.createState();
		try {
			rs = state.executeQuery(sql);
			user = new String(user.getBytes("iso-8859-1"),"utf-8");
			while(rs.next()){
				if( (user.equals(rs.getString("userno")) || user.equals(rs.getString("gr_no")) ) && pwd.equals(rs.getString("pwd")) ){
					result = true ;
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return result;
	}
}
