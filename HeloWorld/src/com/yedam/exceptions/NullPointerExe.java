package com.yedam.exceptions;

import java.util.Scanner;

public class NullPointerExe {

	public static void main(String[] args) {

		try {
			excetpMethod();
		} catch (NumberFormatException e) {
			System.out.println("예외떠넘기기 처리");
		} finally { // 정상이든 예외든 발생후에 실행할 코드를 입력
			System.out.println("정상실행 or 예외발생 실행코드");
		}
		System.out.println("end of prog");
	}
		
		static void excetpMethod() throws NumberFormatException {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("정수를 입력하세요");
			String strNo = scanner.nextLine();
			int no = 1;
			no = Integer.parseInt(strNo);
			System.out.println(no);
		}
}
