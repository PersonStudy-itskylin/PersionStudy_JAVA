package cn.xiangce;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.DBqueryAll;

public class DBXiangce extends DBqueryAll {
	
	public ResultSet queryXiangcetop2(String user) {
		// TODO 自动生成的方法存根
		state = db.createState();
		try {
			rs = state.executeQuery("select * from [images] where image_user='"+ user +"' order by image_time desc");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return rs;
	}
}
