package com.yedam.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductJdbc {

	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		
		try {
			Connection connection = DriverManager.getConnection(url, userId, userPw);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Product loginUser(String id, String pw) { // 로그인 기능
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Connection connection = getConnect();
		String sql = "select user_id,\r\n"
				+ "       user_pw\r\n"
				+ "from   tbl_user\r\n"
				+ "where  user_id = ? and user_pw = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				Product product = new Product(rs.getString("user_id"), rs.getString("user_pw"));
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(Product product) { // 회원가입 기능
		
		Connection connection = getConnect();
		String sql = "insert into tbl_user (user_id, user_pw)\r\n"
				+ "values (?, ?)";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, product.getUserId());
			psmt.setString(2, product.getUserPw());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Product select(String id) {
		
		Connection connection = getConnect();
		String sql = "select *\r\n"
				+ "from   tbl_user\r\n"
				+ "where  user_id = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				Product product = new Product();
				product.setUserId(rs.getString("user_id"));
				product.setUserPw(rs.getString("user_pw"));
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}