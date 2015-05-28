package cn.hglq4.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.hglq4.eshop.entity.OrderDetail;

public class OrderDetailDao extends AbstractDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	public ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
	private ResultSet rs = null;

	// 查询订单表
	public void selectAll() {
		// TODO 自动生成的方法存根
		String sql = new StringBuffer("SELECT * FROM T_ORDERDETAIL").toString();
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				OrderDetail order = new OrderDetail(
						rs.getInt("id"),
						rs.getInt("order_id"), 
						rs.getInt("product_id"),
						rs.getInt("quantity"), 
						rs.getDouble("price"),
						rs.getFloat("discount"), 
						rs.getInt("pur_order_id"),
						rs.getInt("stock"), 
						rs.getDate("distribudate"),
						rs.getInt("status_id"), 
						rs.getString("creator"),
						rs.getString("editor"), 
						rs.getDate("createtime"),
						rs.getTimestamp("updatetime"), 
						rs.getString("remark"));
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 新建订单
	public boolean addOrder(OrderDetail order) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		String sql = new StringBuffer("INSERT INTO T_ORDERDETAIL(")
				.append("order_id,").append("product_id,").append("quantity,")
				.append("price,").append("discount,").append("pur_order_id,")
				.append("stock,").append("distribudate,").append("status,")
				.append("creator,").append("editor,").append("createtime,")
				.append("remark").append(")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)")
				.toString();
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOrder_id());
			pstmt.setInt(2, order.getProduct_id());
			pstmt.setInt(3, order.getQuantity());
			pstmt.setDouble(4, order.getPrice());
			pstmt.setFloat(5, order.getDiscount());
			pstmt.setInt(6, order.getPur_order_id());
			pstmt.setDate(7, order.getDistribudate());
			pstmt.setInt(8, order.getStatus());
			pstmt.setDate(9, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setString(10, order.getCreator());
			pstmt.setString(11, order.getEditor());
			pstmt.setDate(12, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setString(13, order.getRemark());

			isSuccess = (pstmt.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, null, null);
		}

		return isSuccess;
	}
}
