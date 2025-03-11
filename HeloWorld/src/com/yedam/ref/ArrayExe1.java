package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
		
		int[] intAry = {10, 20, 30};
		for (int i = 0; i < intAry.length; i++) {
			 System.out.println(intAry[i]);
		}
		
		intAry = new int[] {40, 50, 60}; // 배열에 새로운 값을 초기화하는 방법
		
		// 배열의 크기를 지정
		intAry = new int[10];
		
		intAry[3] = 30;
		intAry[9] = 90;
		int sum = 0;
		for(int i = 0; i < intAry.length; i++) {
			if(intAry[i] == 0) {
				intAry[i] = (int) (Math.random() * 100) + 1;
			}
			if(intAry[i] % 2 == 1) {
				sum += intAry[i];
			}
			System.out.println((i+1) + "번째 숫자는" + intAry[i]);
		}
		System.out.println("홀수의 합 : " + sum);
		
//		intAry[10] = 100; // 예외발생, 배열의 크기를 넘어선 곳에 값을 초기화 하여서 오류발생
	}
}
