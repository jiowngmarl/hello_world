package com.yedam.bookApp;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// 실행클래스(main 메소드)

public class BookApp {
	
	public static void main(String[] args) {
	
		BookMain3 mainApp2 = BookMain3.getInstance();
		mainApp2.main(args);
		
//		MemberJdbc dao = new MemberJdbc();
//		List<Map<String, String>> list = dao.memberList();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(list);
//		System.out.println(json);
		
		
		
//		BookMain2 mainApp1 = BookMain2.getInstance();
//		mainApp1.main(args);
		
////		Book book = new Book();
////		book.setTitle("자바스크립트 기초");
////		book.setAuthor("신용권");
////		book.setCompany("한빛출판사");
////		book.setPrice(20000);
//		
//		BookJdbc dao = new BookJdbc();
//		if(dao.insert(book)) {
//			System.out.println("등록성공");
//		} else {
//			System.out.println("등록실패");
//		}
//		
//		if(dao.delete("5")) {
//			System.out.println("삭제성공");
//		} else {
//			System.out.println("삭제실패");
//		}
//		
//		if(dao.update(book)) {
//			System.out.println("수정성공");
//		} else {
//			System.out.println("수정실패");
//		}
		
		
//		List<Book> list = dao.list("");
//		for(Book bk : list) {
//			System.out.println(bk.showList());
//		}
		
		
//		BookMain2 mainApp1 = BookMain2.getInstance();
//		mainApp.main(args);
//		
//		BookMain2 mainApp2 = BookMain2.getInstance();
//
//		
//		// 1번에 등록
//		mainApp1.add(); 
//		mainApp1.list();
//		
//		// 2번 목록
//		mainApp2.list();
		
	}
}