package com.yedam.variable;

public class VarExe8 {
	public static void main(String[] args) {
		int n1 = 10;
		byte b1 = 120;
//		byte result = b1 + 30; // -128 ~ 127 , 기본연산에서는 int타입으로 계산하기 때문에 타입이 맞지 않아서 컴파일 오류 발생
		byte result = (byte) (b1 + 30); // 강제적 형변환 (casting)
	
		System.out.println("더한 결과 : " + result);
		
		for(int i = 1; i < 15; i++) {
			System.out.println(b1++); // byte의 값이 127을 넘어가면 -128부터 역으로 내려오게된다
		}
	}
}
