package com.yedam.classes;

public class MethodExe5 {
	
	public static void main(String[] args) {
	
		int num1 = 10;
		num1 = 20;
		
		final int num2 = 90;
//		num2 = 40; // final로 선언한 변수는 변경 불가
		
		final Product p1 = new Product();
		p1.setProductCode("A001");
		p1.setProductCode("B001"); // 오류 X

		
		Product p2 = new Product(); // 오류 O
	}
}
