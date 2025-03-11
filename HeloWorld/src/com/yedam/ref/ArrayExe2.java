package com.yedam.ref;

import com.yedam.variable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
		String[] strAry = {"Heelo", "World", "20", "23.4"};
		
		// 확장 for문
		
		for(String str : strAry) {
			System.out.println(str);
		}
		
		// 크기지정
		
		strAry = new String[10];
		for(String str : strAry) {
			System.out.println(str);
		}
		
		// Member 클래스, 다른 패키지에 있기 때문에 import 하여 사용하기
		Member[] memAry = new Member[10];
		memAry[0] = new Member();
		memAry[0].setMember("홍길동", 80);
		memAry[0].setScore(-90);
		memAry[0].showInfo();
		
		memAry[1] = new Member();
		memAry[1].setMember("박동민", 85);
		memAry[0].setScore(180);
		memAry[1].showInfo();
		
		memAry[2] = new Member("최민혁", 77);
		memAry[2].showInfo();
		
		for(int i = 0; i < memAry.length; i++) {
			if(memAry[i] != null) {				
  			memAry[i].showInfo();
			} 
		}
	}
}
