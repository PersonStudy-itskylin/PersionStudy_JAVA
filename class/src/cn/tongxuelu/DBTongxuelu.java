package cn.tongxuelu;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.DBqueryAll;

public class DBTongxuelu extends DBqueryAll{
	
	public ResultSet queryAll() {
		// TODO 自动生成的方法存根
		String sql = "SELECT userno,gr_no,gr_name,gr_sex,gr_birth,gr_birthday,gr_tel,gr_qq,gr_mail,gr_photo,gr_address,tz_rongyu,tz_weibo,love_name,tz_lovesay,tz_aihao,tz_aihao,zw_name FROM [CLASS_1211].[dbo].[geren] g,[CLASS_1211].[dbo].[tuozhan] t , [CLASS_1211].[dbo].[zhiwu] z ,[CLASS_1211].[dbo].[love] where g.gr_no = t.tz_no and tz_zwno = zw_no and love_no = tz_loveno order by gr_no desc";
		state = db.createState();
		try {
			rs = state.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs;
	}
	
}