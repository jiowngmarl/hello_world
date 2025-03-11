package com.yedam.variable;

import java.util.Scanner;

public class VarExe4 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] scores = new int[3];
		
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i < scores.length; i++) {
			System.out.print("정수의 합을 입력하세요 : ");
			scores[i] = scanner.nextInt();
			sum += scores[i];
		}
		avg = (sum * 1.0) / scores.length;
		
		System.out.println("정수의 합 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("변경된 사항");
	}
}
