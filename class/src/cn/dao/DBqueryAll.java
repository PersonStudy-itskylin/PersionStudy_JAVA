package cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBqueryAll {
	public DBConn db = new DBConn();
	public Statement state = null;
	public ResultSet rs = null;
	
	public ResultSet queryAll(String table) {
		// TODO 自动生成的方法存根
		state = db.createState();
		try {
			rs = state.executeQuery("select * from "+table);
			System.out.println();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs;
	}
	public void closeAll(){
		try {
			//DBConn.getConn().close();
			rs.close();
			state.close();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
}
