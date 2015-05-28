package cn.gonggao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.DBqueryAll;

public class DBGonggao extends DBqueryAll{
	
	public ResultSet queryGonggao() {
		// TODO 自动生成的方法存根
		try {
			state = db.createState();
			rs = state.executeQuery("SELECT * FROM [GONGGAO] order by [times] desc");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		
		return rs;
	}
	
	public String queryGonggaoTop1() {
		// TODO 自动生成的方法存根
		String result = "";
		try {
			state = db.createState();
			rs = state.executeQuery("SELECT TOP 1 * FROM GONGGAO order by [times] desc");
			rs.next();
			result  = rs.getString("content");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet queryGonggaoTop5() {
		// TODO 自动生成的方法存根
		try {
			state = db.createState();
			rs = state.executeQuery("SELECT TOP 5 * FROM [dbo].[GONGGAO] order by [times] desc");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet queryGonggaoId(String id) {
		// TODO 自动生成的方法存根
		try {
			rs = db.createState().executeQuery("SELECT * FROM [dbo].[GONGGAO] where id=" + id + " order by [times] desc");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}
}
