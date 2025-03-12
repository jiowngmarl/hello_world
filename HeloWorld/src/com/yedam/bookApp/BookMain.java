package com.yedam.bookApp;

import java.util.Scanner;

public class BookMain {
	
	static Book[] bookStore = new Book[100];
	static Scanner scanner = new Scanner(System.in);
	
	public static int getSequnceNo() {
		int max = 0;
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getOrderNo() > max) {
				max = bookStore[i].getOrderNo();
			}
		}
		return max + 1;
	}
	
	// 등록기능을 구현하는 메서드
	public static void add() {
		System.out.print("제목입력 : ");
		String title = scanner.nextLine();
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println("이미 등록된 도서입니다.");
				return;
			}
		}
		System.out.print("저자입력 : ");
		String author = scanner.nextLine();
		System.out.print("출판사입력 : ");
		String company = scanner.nextLine();
		System.out.print("가격입력 : ");
		String price = scanner.nextLine();
		
		Book book = new Book(title, author, company, Integer.parseInt(price), getSequnceNo());
		
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] == null) {
				bookStore[i] = book;
				break;
			}
		}
	} // end of add()
	
	// 수정기능을 구현하는 메서드
	public static void edit() {
		
		System.out.print("수정 도서명 입력 : ");
		String title = scanner.nextLine();
		if(title.isBlank()) {
			System.out.println("책제목을 반드시 입력하세요");
			return;
		}
		System.out.print("수정 저자명 입력 : ");
		String author = scanner.nextLine();
		System.out.print("수정 출판사명 입력 : ");
		String company = scanner.nextLine();
		System.out.print("수정 가격 입력 : ");
		String price = scanner.nextLine();
		
		boolean isExist = false;
		
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				if(!author.isBlank()) {
					bookStore[i].setAuthor(author);
				}
				if(!company.isBlank()) {
					bookStore[i].setCompany(company);
				}
				if(!price.isBlank()) {
					bookStore[i].setPrice(Integer.parseInt(price));
				}
				isExist = true;
				System.out.println("수정완료");
			}
			if(!isExist) {
				System.out.println("찾을 수 없습니다");
			}
		}
		
	} // end of edit()
	
	public static void delete() {
		
		while(true) {
			System.out.print("제목입력 : ");
			String title = scanner.nextLine();
			if(!title.isBlank()) {
				break;
			}
			System.out.println("제목을 반드시 입력");
		}
		
		Boolean isExist = false;
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				bookStore[i] = null;
				System.out.println("삭제완료");
				isExist = true;
			}
		}
		
	} // end of delete()
	
	public static void list() {
		init();
		
		// 순번 정렬
		// 순번1 > 순번2, 앞에 순번이 null 인 경우
	
		Book temp = null;
		
		for(int i = 0; i < bookStore.length - 1; i++) {
			for(int j = 0; j < bookStore.length - 1; j++) {
				if(bookStore[j+1] == null) {  // 변경 X
					continue;
				}
				if(bookStore[j] == null || bookStore[j].getOrderNo() > bookStore[j+1].getOrderNo()) {  // 변경 O
					temp = bookStore[j];
					bookStore[j]= bookStore[j+1];
					bookStore[j] = temp;		
				}
			}
		}
		
		int seqNo = 1;
		for(Book bok : bookStore) {
			if(bok != null) {
				System.out.println(seqNo++ + " " +bok.showList());
			}
		}
	} // end of list()
	
	public static void detail() {
		
		boolean isExist = false;
		System.out.print("상세보기 책 제목 입력 : ");
		String title = scanner.nextLine();
		
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println(bookStore[i].showBookInfo());
				isExist = true;
				break;
			}
		}
		
		if(!isExist) {
			System.out.println("없는 책입니다.");
		}
	}
	
	public static void main(String[] args) {
		
		init();
		boolean run = true;
		
		while (run) {
			System.out.println("1.도서등록 / 2.수정 / 3.삭제 / 4.목록 / 5.상세조회 / 9.종료");
			System.out.print("선택 >> ");
			int menu = Integer.parseInt(scanner.nextLine());
			
			switch(menu) {
			case 1 :
				add();
				break;
			case 2 :
				edit();
				break;
			case 3 :
				delete();
				break;
			case 4 :
				list();
				break;
			case 5 :
				detail();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다");
				run = false;
				break;
			default :
				System.out.println("메뉴를 다시 선택하세요");
			}
		}
		System.out.println("end of prog.");
		
	}
	public static void init() {
		bookStore[0] = new Book("이것이자바다", "신용권", "한빛출", 20000, 1);
		bookStore[1] = new Book("스크립트기초", "박기초", "우리출", 26000, 2);
		bookStore[2] = new Book("HTML,CSS", "김하늘", "가람출", 25000, 3);
		
		System.out.println("수정");
	}
}
