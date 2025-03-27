package com.yedam.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserJdbc {

	Connection getConnection() {
		String url = "jdbc:oracle:thin:@192.168.0.23:1521:xe";
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
	
	public User loginUser(String id, String pw) { // 로그인 기능
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Connection connection = getConnection();
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
				User user = new User(rs.getString("user_id"), rs.getString("user_pw"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(User user) { // 회원가입 기능
		
		Connection connection = getConnection();
		String sql = "insert into tbl_user (user_id, user_pw)\r\n"
				+ "values (?, ?)";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User select(String id) {
		
		Connection connection = getConnection();
		String sql = "select *\r\n"
				+ "from   tbl_user\r\n"
				+ "where  user_id = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserPw(rs.getString("user_pw"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Product> userList() {
		List<Product> list = new ArrayList<Product>();
		Connection connection = getConnection();
		String sql = "select product_code,\r\n"
				+ "       product_name,\r\n"
				+ "       product_price,\r\n"
				+ "       product_company\r\n"
				+ "from   tbl_product\r\n"
				+ "order by product_code";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				Product product = new Product();
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getInt("product_price"));
				product.setProductCompany(rs.getString("product_company"));
				list.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Product> userSearchList(String productCode) {
		List<Product> list = new ArrayList<Product>();
		Connection connection = getConnection();
		String sql = "select product_code,\r\n"
				+ "       product_name,\r\n"
				+ "       product_price,\r\n"
				+ "       product_company\r\n"
				+ "from   tbl_product\r\n"
				+ "where  product_code = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, productCode);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				Product product = new Product();
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getInt("product_price"));
				product.setProductCompany(rs.getString("product_company"));
				list.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean userInsert(Product product) {
		
		Connection connection = getConnection();
		String sql = "insert into tbl_userProduct (\r\n"
				+ "                             user_id,\r\n"
				+ "                             product_code,\r\n"
				+ "                             product_name,\r\n"
				+ "                             product_price,\r\n"
				+ "                             product_company\r\n"
				+ "                             )\r\n"
				+ "values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, product.userId);
			psmt.setString(2, product.productCode);
			psmt.setString(3, product.productName);
			psmt.setInt(4, product.price);
			psmt.setString(5, product.productCompany);
			
			int r = psmt.executeUpdate();
			
			if(r > 0 ) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	

}
