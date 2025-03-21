package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmpDAO {

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
	
	public boolean insert(Employee employee) {
		
		Connection connection = getConnection();
		String sql = "insert into tbl_emp(\r\n"
				+ "                    emp_no,\r\n"
				+ "                    emp_name,\r\n"
				+ "                    phone,\r\n"
				+ "                    hire_date,\r\n"
				+ "                    salary\r\n"
				+ "                    )\r\n"
				+ "values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, employee.getEmpNo());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getPhoneNo());
			stmt.setString(4, employee.getDate());
			stmt.setInt(5, employee.getSalary());
			
			int r = stmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}


	public List<Employee> lists() {
		List<Employee> list = new ArrayList<Employee>();
		Connection connection = getConnection();
		String sql = "select *\r\n"
				+ "from tbl_emp";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpNo(rs.getString("empNo"));
				employee.setName(rs.getString("name"));
				employee.setPhoneNo(rs.getString("phoneNo"));
				employee.setDate(rs.getString("date"));
				employee.setSalary(rs.getInt("salary"));
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	
	public boolean update(Employee employee) {
		
		Connection connection = getConnection();		
		String sql = "update tbl_emp\r\n"
				+ "set    emp_no = ?,\r\n"
				+ "       emp_name = ?,\r\n"
				+ "       phone = ?,\r\n"
				+ "       hire_date = ?,\r\n"
				+ "       salary = ?\r\n"
				+ "where  emp = ? and salary = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,employee.getEmpNo());;
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getPhoneNo());
			stmt.setString(4, employee.getDate());
			stmt.setInt(5, employee.getSalary());

			int r = stmt.executeUpdate(sql);
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public boolean delete (String empNo) {
		
		Connection connection = getConnection();
		String sql = "\r\n"
				+ "delete from tbl_emp\r\n"
				+ "where emp_no = ?";
		
		try {
			Statement stmt = connection.createStatement();
			int r = stmt.executeUpdate(sql);
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Employee> list() {
		List<Employee> list = new ArrayList<Employee>();
		Connection connection = getConnection();
		String sql = "select *\r\n"
				+ "from tbl_emp";
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("empNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}




