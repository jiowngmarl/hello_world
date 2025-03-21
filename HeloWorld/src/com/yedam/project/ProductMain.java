package com.yedam.project;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		
		boolean run = true;
		
		while (run) {
			
			Scanner scanner = new  Scanner(System.in);
			System.out.println("------------------------------");
			System.out.println("1.사용자 2.판매자");
			System.out.println("------------------------------");
			String num = scanner.nextLine();
		
			switch (Integer.parseInt(num)) {
			case 1 :
				System.out.print("ID입력 : ");
				String id1 = scanner.nextLine();
				System.out.print("PW입력 : ");
				String pw1 = scanner.nextLine();
				run = false;
				break;
			case 2 :
				System.out.print("ID입력 : ");
				String id2 = scanner.nextLine();
				System.out.print("PW입력 : ");
				String pw2 = scanner.nextLine();
				run = false;
				break;
			default : 
				System.out.println("다시 입력하세요");
			}
		}
			
	}		
}
