package cn.hglq4.eshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	protected String DRIVER = "com.mysql.jdbc.Driver";
	protected String DBNAME = "hglq4";
	protected String DBPASS = "linwei584520";
	protected String URL = "jdbc:mysql://127.0.0.1:3306/eshop?relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull";

	protected Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, DBNAME, DBPASS);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	protected void closeResource(Connection conn, Statement stmt,
			PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库关闭连接失败，错误代码：0xSQL000");
		}

	}
}
