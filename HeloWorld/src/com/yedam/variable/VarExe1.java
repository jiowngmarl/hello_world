package com.yedam.variable;

import java.awt.SystemColor;

// 관례 : 클래스의 이름은 대문자로 시작
public class VarExe1 {
	public static void main(String[] args) {
		int number1 = 70;
		int number2 = 80;
		number1 = 71;
		
		int sum = number1 + number2;
		
		System.out.println("두 점수의 합은 " + sum + "입니다.");
		
		// 연산은 두 변수의 유형(데이터 타입) 항상 동일해야한다.
		double avg = sum / 2.0;
		System.out.println("두 점수의 평균은 " + avg + "입니다" );
	}
}
