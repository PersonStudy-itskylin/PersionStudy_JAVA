package cn.hglq4.eshop.testing;

import cn.hglq4.eshop.dao.AbstractDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testingOrder extends AbstractDAO {

	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;

	// 查询订单表
	public void selectAll() {
		// TODO 自动生成的方法存根
		String sql = new StringBuffer("SELECT * FROM T_ORDERDETAIL").toString();
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "     "
						+ rs.getInt("order_id") + "     "
						+ rs.getInt("product_id") + "     "
						+ rs.getInt("quantity") + "     "
						+ rs.getDouble("price") + "     "
						+ rs.getString("discount") + "     "
						+ rs.getInt("pur_order_id") + "     "
						+ rs.getInt("stock") + "     "
						+ rs.getDate("distribudate") + "     "
						+ rs.getInt("status_id") + "     "
						+ rs.getString("creator") + "     "
						+ rs.getString("editor") + "     "
						+ rs.getDate("createtime") + "     "
						+ rs.getTimestamp("updatetime") + "     "
						+ rs.getString("remark"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new testingOrder().selectAll();
	}
}
