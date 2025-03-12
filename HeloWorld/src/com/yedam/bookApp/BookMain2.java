package com.yedam.bookApp;

import java.util.Scanner;

public class BookMain2 {

	public static void main(String[] args) {
		
		Book[] bookStore = new Book[100];
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.제목 / 2.저자 / 3.회사 / 4.가격 / 5.종료");
			System.out.print("선택 >> ");
			int menu = Integer.parseInt(scanner.nextLine());
			
			switch (menu) {
			case 1 :
				System.out.print("제목 입력 : ");
				String title = scanner.nextLine();
				System.out.print("저자 입력 : ");
				String author = scanner.nextLine();
				System.out.print("회사 입력 : ");
				String company = scanner.nextLine();
				System.out.print("가격 입력 : ");
				String price = scanner.nextLine();
				
				Book book = new Book(title, author, company, Integer.parseInt(price));
				
				for(int i = 0; i < bookStore.length; i++) {
					if(bookStore[i] == null) {
						bookStore[i] = book;
						System.out.println("등록 완료");
					}
						
				}
				
			case 2 :
			case 3 :
			case 4 :
			case 5 :
			default:
			}
			
		}
	}
}
