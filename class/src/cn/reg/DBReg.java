package cn.reg;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import cn.dao.DBqueryAll;

public class DBReg extends DBqueryAll{
	
	public boolean getReg(HttpServletRequest reg) {
		// TODO 自动生成的方法存根
		boolean result= false;
		String sql = "insert into users(userno,pwd) values(?,?)";
		state = db.createState();
		try {
			if(state.executeUpdate("insert into users(userno,pwd) values('"+ reg.getParameter("userno") +"','" 
					+ reg.getParameter("pwd") +"')")>0){
				result = true ;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	public boolean getRegister() {
		// TODO 自动生成的方法存根
		boolean result= false;

		
		
		
		return result;
	}
}
