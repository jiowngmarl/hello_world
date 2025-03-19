package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. ojdbc 데이터베이스를 연결, 쿼리, 실행결과를 가져오는 라이브러리
 * 2. Connection 객체를 통해 데이터베이스에 접속해서 처리하는 작업 (db session)
 * 3. Statement(PreparedStatemnet) 를 이용해서 쿼리를 실행
 * 4. 처리된 결과를 ResultSet(조회된 결과), int(입력, 수정, 삭제) 를 이용
 */

public class DaoExe {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		String sql = "select empno, ename, job, mgr, hiredate, sal\r\n" 
				+ "from emp order by empno desc";
		
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			System.out.println("연결성공");
			conn.setAutoCommit(false); // autoCommit의 사용여부, false일 경우 커밋을 수동으로 적어줘야한다, ture일 경우 자동 커밋
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate("delete from emp where empno = 9999"); // 1건이 삭제되면 1, 2건이 삭제되면 2 값을 반환해준다\
			if(r>0) {
				System.out.println("삭제성공.");
				conn.commit(); //커밋처리
			}
			ResultSet rs = stmt.executeQuery(sql); // 쿼리작성 -> 실행
			
			// next() 조회된 데이터를 불러오는 역할
			while(rs.next()) {
				System.out.println(rs.getInt("empno") + "," + rs.getString("ename") + "," + rs.getString("job") + "," + rs.getInt("mgr"));
			}
			System.out.println("-- end of data --");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
