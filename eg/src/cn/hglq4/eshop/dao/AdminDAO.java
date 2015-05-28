package cn.hglq4.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.hglq4.eshop.entity.Admin;

public class AdminDAO extends AbstractDAO {
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	public ArrayList<Admin> adminlist = new ArrayList<Admin>();

	// 查询所有管理员
	public void selectAll() {
		Connection conn = null;
		String sql = "SELECT * FROM T_ADMIN";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getDate(7), rs.getTimestamp(8),
						rs.getString(9));
				adminlist.add(admin);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			closeResource(conn, null, pstmt, rs);
		}
	}
	
	
	
	//login admin
	public Admin loginAdmin(String account,String pwd){
		String sql = "SELECT * FROM T_ADMIN WHERE ACCOUNT=? AND PWD=?";
		Admin admin = null;
		Connection conn = null;
			try {
				conn = getConn();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, account);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
//				System.out.println(rs.next());
				if(rs.next()){
					/*
					admin.setManager(rs.getInt(1));
					admin.setAccount(rs.getString(2)
							);*/
					admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getTimestamp(8), rs.getString(9));
					//return admin;
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally{
				closeResource(conn, null, pstmt, rs);
			}
			return admin;
	}

	
//	public static void main(String[] args) {
//		AdminDAO admin = new AdminDAO();
//		Admin user =admin.loginAdmin("1231124", "1234546");
//		if(user!=null){
//			System.out.println(user.getManager() + "   " + user.getAccount() +  "  "  +  user.getPwd() + " " + user.getRole()  + " " + user.getRemark());
//		}
//		System.out.println("asdf5vg6156a156");
//	}
}
