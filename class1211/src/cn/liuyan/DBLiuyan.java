package cn.liuyan;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.sqlserver.DBConn;
import cn.sqlserver.DBqueryAll;

public class DBLiuyan extends DBqueryAll{	
	Statement state = null;
	ResultSet rs = null;
	public ResultSet queryAll(){
		state = new DBConn().createState();
		String sql = "select * from LIUYAN";
			try {
				rs = state.executeQuery(sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return rs;
	}
	public ResultSet queryTop5(){
		state = new DBConn().createState();		
		String sql = "SELECT TOP 5 * FROM [LIUYAN] order by times desc";
		
			try {
				rs = state.executeQuery(sql);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		return rs;
	}
	public boolean addliuyan(String userno,String content) {
		// TODO 自动生成的方法存根
		boolean flag = false ;
		int i =0;
		state = new DBConn().createState();
		
		try {
			userno = new String(userno.getBytes("iso-8859-1"),"utf-8");
			content = new String(content.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String sql = "insert into LIUYAN(users,content) values('"+ userno +"','"+ content +"')";
		try {
			i = state.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			if(i>0){
				flag = true;
			}
		return flag;
	}
	public boolean delliuya(String userno){
		boolean result = false;
		state = new DBConn().createState();
		try {
			if(state.executeUpdate("delect LIUYAN where users='"+ userno +"'") > 0){
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
}
