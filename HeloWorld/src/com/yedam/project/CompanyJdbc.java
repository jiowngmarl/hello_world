package com.yedam.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompanyJdbc {

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
	
	public Company loginCompany(String companyNum, String companyId, String companyPw) {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Connection connection = getConnect();
		String sql = "select company_num,\r\n"
				+ "       company_id,\r\n"
				+ "       company_pw\r\n"
				+ "from   tbl_company\r\n"
				+ "where  company_num = ? and company_id = ? and company_pw = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, companyNum);
			psmt.setString(2, companyId);
			psmt.setString(3, companyPw);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				Company company = new Company(companyNum, companyId, companyPw);
				return company;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(Company company) {
		
		Connection connection = getConnect();
		String sql = "insert into tbl_company (company_num, company_id, company_pw)\r\n"
				+ "values (?, ?, ?)";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, company.getCompanyNum());
			psmt.setString(2, company.getCompanyId());
			psmt.setString(3, company.getCompanyPw());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Company select(String companyNum, String companyId) {
		
		Connection connection = getConnect();
		String sql = "select *\r\n"
				+ "from tbl_company\r\n"
				+ "where company_num = ? or company_id = ?";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, companyNum);
			psmt.setString(2, companyId);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				Company company = new Company();
				company.setCompanyNum(rs.getString("company_num"));
				company.setCompanyId(rs.getString("company_id"));
				company.setCompanyPw(rs.getString("company_pw"));
				return company;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
