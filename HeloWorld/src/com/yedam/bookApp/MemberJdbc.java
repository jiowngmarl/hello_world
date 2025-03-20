package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberJdbc {

	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User login(String id, String pw) {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Connection connection = getConnect();
		String sql = "select * from tbl_member where user_id = ? and password = ?";
		
		try {
			PreparedStatement psmt =  connection.prepareStatement(sql);
			psmt.setString(1, id); // 1번째 파라미터
			psmt.setString(2, pw); // 2번째 파라미터
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				User user = new User(rs.getString("user_id"), rs.getString("user_name"), rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회결과가 없으면 null 반환
	}
	
	// {userId: "user01"}, {password: "1111"}, {userName: "홍길동"} (키 : 값 ...)으로 출력
	public List<Map<String, String>> memberList() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Connection conn = getConnect(); // db session 을 받아오는것
		String sql = "select * from tbl_member?";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", rs.getString("user_id"));
				map.put("password", rs.getString("password"));
				map.put("userName", rs.getString("user_name"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
}
