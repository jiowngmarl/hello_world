package com.yedam.exceptions;

import java.util.Scanner;

public class NumberFormatExe {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요  : ");
		String strNo = scanner.nextLine();
		
		try {
			int no = Integer.parseInt(strNo);
		} catch (NumberFormatException e) {
			System.out.println("정수를 입력해야합니다");
			
		}
		int no = Integer.parseInt(strNo);
		System.out.println(no);
	}
}
