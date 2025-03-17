package com.yedam.interfaces;

public class ServiceApp {

	public static void main(String[] args) {
		
//		MysqlDao dao = new MysqlDao();
		
//		OracleDao dao = new OracleDao();

		Dao dao = new MysqlDao(); 
		
		//등록
		dao.insert();
		
		//수정
		dao.update();
		
		//삭제
		dao.delete();
	}
}
