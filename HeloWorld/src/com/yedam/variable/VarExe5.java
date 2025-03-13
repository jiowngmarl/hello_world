package com.yedam.variable;

import java.util.Scanner;

public class VarExe5 {
	public static void main(String[] args) {
		
		boolean run = true;
		int balance = 0; // 예금액을 저장하는 변수.
		// 10만원 최대, 잔액이 0보다 크도록
		int amount = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			int menu = scanner.nextInt();
			switch(menu) {
			case 1 : 
				System.out.print("금액을 입력 : ");
				amount = scanner.nextInt();
				if(balance + amount > 100000) {
					System.out.println("최대 10만원");
				} else {
					balance += amount;
				}
				break;
			case 2 :
				System.out.print("금액을 입력 : ");
				amount = scanner.nextInt();
				if(balance - amount < 0) {
					System.out.println("잔액 초과");
				} else {
					balance -= amount;
				}
				break;
			case 3 : 
				System.out.println("잔고 : " + balance);
				break;
			case 4 : 
				run = false;
				
			}
		}
		System.out.println("end of prog.");
		
		System.out.println("수정");
	}
}
