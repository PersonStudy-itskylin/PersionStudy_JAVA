package cn.lin.DBDao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn{
    public final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public final static String URL    = "jdbc:sqlserver://localhost:1433;DatabaseName=WUZIQI";
    public final static String DBNAME = "403415171";
    public final static String DBPASS = "123456";
    private static Statement state=null;
    private ResultSet rs=null;
	
    //加载驱动，连接数据库
    public static Connection getConn() throws ClassNotFoundException, SQLException{
    	Class.forName(DRIVER);
//    	System.out.print("--------驱动加载成功-------");
        Connection conn = DriverManager.getConnection(URL,DBNAME,DBPASS);
//        System.out.print("--------数据库链接成功-------");
        return conn ;
    }
    
    //创建数据库对象
    public Statement createState(){
    	try {
			state = getConn().createStatement();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	return  state;
    }
}
