package com.yedam.bookApp;

// 실행클래스(main 메소드)

public class BookApp {
	
	public static void main(String[] args) {
		BookMain2 mainApp1 = BookMain2.getInstance();
//		mainApp.main(args);
		
		BookMain2 mainApp2 = BookMain2.getInstance();

		
		// 1번에 등록
		mainApp1.add(); 
		mainApp1.list();
		
		// 2번 목록
		mainApp2.list();
		
	}
}