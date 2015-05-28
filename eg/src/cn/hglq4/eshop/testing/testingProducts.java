package cn.hglq4.eshop.testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.hglq4.eshop.dao.AbstractDAO;

public class testingProducts extends AbstractDAO{
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 查询所有用户
		public void selectAll() {
			Connection conn = null;
			String sql = "SELECT * FROM T_PRODUCTS";
			try {
				conn = getConn();
				pstmt = conn.prepareStatement(sql);
				rs  = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt("id")+  "  " +
							rs.getString("productCode")+  "  " +
							rs.getString("productName")+  "  " +
							rs.getString("productPhoto")+  "  " +
							rs.getString("desctiption")+  "  " +
							rs.getDouble("purchasingPrice")+  "  " +
							rs.getDouble("sellingPrice")+  "  " + 
							rs.getInt("quantity")+  "  " +
							rs.getString("category")+  "  " + 
							rs.getString("attachments")+  "  " +
							rs.getString("creator")+  "  " + 
							rs.getString("editor")+  "  " +
							rs.getDate("createtime")+  "  " +
							rs.getTimestamp("updatetime")+  "  " + 
							rs.getString("remark")
						);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				closeResource(conn, null, pstmt, rs);
			}
		}
}
