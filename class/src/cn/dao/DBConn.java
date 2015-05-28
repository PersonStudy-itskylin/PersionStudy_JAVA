package cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
    // 驱动程序名
	public final static String DRIVER = "com.mysql.jdbc.Driver";
    // URL指向要访问的数据库名scutcs
	public final static String URL = "jdbc:mysql://42.192.10.28:3306/hglq4";
    // MySQL配置时的用户名
	public final static String DBNAME = "hglq4";
    // MySQL配置时的密码
	public final static String DBPASS = "linwei584520";
	private static Statement state=null;

    //加载驱动，连接数据库
    public static Connection getConn() throws ClassNotFoundException, SQLException{
          
        	   Class.forName(DRIVER);
//           	System.out.print("--------驱动加载成功-------");
               Connection conn = DriverManager.getConnection(URL,DBNAME,DBPASS);
//               System.out.print("--------数据库链接成功-------");
               return conn;
           
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