package cn.tongxuelu;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import cn.dao.DBqueryAll;

public class Username extends DBqueryAll{
	
	public String getUsername(HttpServletRequest user) {
		// TODO 自动生成的方法存根
		String username = user.getParameter("userno");
		state=db.createState();
		
		try {
			rs=state.executeQuery("select gr_name from [geren] where gr_no='"+ username + "'");
			rs.next();
			username = rs.getString("gr_name");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return username;
	}
}
