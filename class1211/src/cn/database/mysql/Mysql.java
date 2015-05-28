package cn.database.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql {

	public static void main(String[] args){

           // 驱动程序名
           String driver = "com.mysql.jdbc.Driver";
           // URL指向要访问的数据库名scutcs
           String url = "jdbc:mysql://localhost:3306/test";

           // MySQL配置时的用户名
           String user = "root";
 
           // MySQL配置时的密码
           String password = "";

           try {
            // 加载驱动程序
            Class.forName(driver);

            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password);

            if(!conn.isClosed())
             System.out.println("Succeeded connecting to the Database!");

            // statement用来执行SQL语句
            Statement statement = conn.createStatement();

            // 要执行的SQL语句
            String sql = "select * from liuyan";

            // 结果集
            ResultSet rs = statement.executeQuery(sql);

            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("	标题" + "\t\t" + " 内容\t\t\t作者\t\t时间 ");
            System.out.println("-----------------");

            String title = null;
            String content = null;
            String author = null;
            String time = null;
            while(rs.next()) {
   
             // 选择stitle这列数据
            	title = rs.getString("title");
            	content = rs.getString("content");
            	author = rs.getString("author");
            	time = rs.getString("time");
            	
   
             // 首先使用ISO-8859-1字符集将title解码为字节序列并将结果存储新的字节数组中。
//             // 然后使用utf-8字符集解码指定的字节数组
//                title = new String(title.getBytes("ISO-8859-1"),"utf-8");
//                content = new String(content.getBytes("ISO-8859-1"),"utf-8");
//                author = new String(author.getBytes("ISO-8859-1"),"utf-8");
             // 输出结果
             	System.out.println(title + "\t"+ content + "\t" + author + "\t" + time);
            }
            	rs.close();
            	conn.close();
           } catch(ClassNotFoundException e) {
        	   System.out.println("Sorry,can`t find the Driver!");
        	   e.printStackTrace();
           } catch(SQLException e) {
        	   e.printStackTrace();
           } catch(Exception e) {
        	   e.printStackTrace();
           }
	}
}