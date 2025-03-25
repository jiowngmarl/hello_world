package com.yedam.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.l;

public class ProductJdbc {

	Connection getConnection() {
		
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
	
	public boolean insert(Product product) {
		
		Connection connection = getConnection();
		String sql = "insert into tbl_product(company_num ,product_code, product_name, product_price, product_company)\r\n"
				+ "values(? ,?, ?, ?, ?)";
		
		try {
			
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, product.companyNum);
			psmt.setString(2, product.productCode);
			psmt.setString(3, product.productName);
			psmt.setInt(4, product.price);
			psmt.setString(5, product.productCompany);
			
			int r = psmt.executeUpdate();
			
			
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Product select (String productCode) {
		
		Connection connection = getConnection();
		String sql = "select *\r\n"
				+ "from tbl_product\r\n"
				+ "where product_code = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, productCode);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				Product product = new Product();
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getInt("product_price"));
				product.setProductCompany(rs.getString("product_company"));
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public List<Product> list(String company) {
		List<Product> list = new ArrayList<Product>();
		Connection connection =getConnection();
		String sql = "select *\r\n"
				+ "from tbl_product\r\n"
				+ "where company_num = ?\r\n"
				+ "order by product_code";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, company);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {

				Product product = new Product();
				product.setCompanyNum(rs.getString("company_num"));
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
	
	
	public boolean update(Product product) {
		
		Connection connection = getConnection();
		String sql = "update tbl_product\r\n"
				+ "   set product_name = nvl(?, product_name),\r\n"
				+ "       product_price = ?,\r\n"
				+ "       product_company = nvl(?, product_company)\r\n"
				+ "where  product_code = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setString(1, product.getProductName());
			psmt.setInt(2, product.getPrice());
			psmt.setString(3, product.getProductCompany());
			psmt.setString(4, product.getProductCode());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete (String productCode) {
		
		Connection connection = getConnection();
		String sql = "delete from tbl_product\r\n"
				+ "where product_code = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, productCode);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
