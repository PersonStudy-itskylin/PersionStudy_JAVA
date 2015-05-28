package cn.hglq4.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.hglq4.eshop.entity.Products;

public class ProductsDAO extends AbstractDAO {

	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private ArrayList<Products> productslist = new ArrayList<Products>();

	// 查询所有用户
	public ArrayList<Products> selectAll() {
		Connection conn = null;
		String sql = "SELECT * FROM T_PRODUCTS";
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Products product = new Products(
						rs.getInt("id"),
						rs.getString("productCode"),
						rs.getString("productName"),
						rs.getString("productPhoto"),
						rs.getString("desctiption"),
						rs.getDouble("purchasingPrice"),
						rs.getDouble("sellingPrice"), 
						rs.getInt("quantity"),
						rs.getString("category"), 
						rs.getString("attachments"),
						rs.getString("creator"), 
						rs.getString("editor"),
						rs.getDate("createtime"),
						rs.getTimestamp("updatetime"), 
						rs.getString("remark")
					);
				productslist.add(product);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			closeResource(conn, stmt, pstmt, rs);
		}
		return productslist;
	}

	public boolean addProduct(Products entity) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = new StringBuffer("INSERT INTO T_PRODUCTS(")
				.append("id,")
				.append("productCode,")
				.append("productName,")
				.append("productPhoto,")
				.append("desctiption,")
				.append("purchasingPrice,")
				.append("sellingPrice,")
				.append("quantity,")
				.append("category,")
				.append("attachments,")
				.append("creator,")
				.append("editor,")
				.append("createtime,")
				.append("remark")
				.append(")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)")
				.toString();
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			pstmt.setString(2, entity.getProductCode());
			pstmt.setString(3, entity.getProductName());
			pstmt.setString(4, entity.getProductPhoto());
			pstmt.setString(5, entity.getDesctiption());
			pstmt.setDouble(6, entity.getPurchasingPrice());
			pstmt.setDouble(7, entity.getSellingPrice());
			pstmt.setInt(8, entity.getQuantity());
			pstmt.setString(9, entity.getCategory());
			pstmt.setString(10, entity.getAttachments());
			pstmt.setString(11, entity.getCreator());
			pstmt.setString(12, entity.getEditor());
			pstmt.setDate(13, entity.getCreatetime());
			pstmt.setString(14, entity.getRemark());

			isSuccess = (pstmt.executeUpdate() > 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, pstmt, null, null);
		}
		return isSuccess;
	}

	public Products selectOne(String productCode) {
		// TODO Auto-generated method stub
		Products entity = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_PRODUCTS WHERE productCode = '"
				+ productCode + "'";
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				entity = new Products();
				entity.setId(rs.getInt("id"));
				entity.setProductCode(rs.getString("productCode"));
				entity.setProductName(rs.getString("productName"));
				entity.setProductPhoto(rs.getString("productPhoto"));
				entity.setDesctiption(rs.getString("desctiption"));
				entity.setPurchasingPrice(rs.getDouble("purchasingPrice"));
				entity.setSellingPrice(rs.getDouble("sellingPrice"));
				entity.setQuantity(rs.getInt("quantity"));
				entity.setCategory(rs.getString("category"));
				entity.setAttachments(rs.getString("attachments"));
				entity.setCreator(rs.getString("creator"));
				entity.setEditor(rs.getString("editor"));
				entity.setCreatetime(rs.getDate("createtime"));
				entity.setUpdatetime(rs.getTimestamp("updatetime"));
				entity.setRemark(rs.getString("remark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(conn, null, null, rs);
		}
		return entity;
	}
}
