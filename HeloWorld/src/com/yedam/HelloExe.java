package com.yedam;

import java.awt.print.Book;

public class HelloExe {
	
	String name;
	String number;
	int age;
	
	public HelloExe(String name,String number,int age) {
		this.name = name;
		this.number = number;
		this.age = age;
	}
	
	
	
	public static void main(String[] args) {
		
		HelloExe[] t = new HelloExe[10];
		
		t[0] = new HelloExe("홍길동", "010-1234-1234", 20);
		t[1] = new HelloExe("홍길동1", "010-1234-1234", 23);
		t[2] = new HelloExe("홍길동2", "010-1234-1234", 22);
		
		int y = t[0].age;
		int x = 0;
		int max = t[0].age;
		
		
		for(int i = 0; i < t.length; i++) {
			if(t[i] != null && max < t[i].age) {
				max = t[i].age;
				x = i;
			}
		}
		System.out.println(t[x].name);
		
		int a = 32000;
		
		int num[] = {34, 32, 88, 23};
		
		String c[] = {"32"};
		
//		int d = Integer.parseInt();
		
		String e[] = {"Hello", "Nice", "Good"};
		
		int[] f = new int[5];
		
//		for(int i = 0; i < f.length; i++) {
//			f[i] = (Math.random() * 50) + 1;	
//		}	
//		
		
	}
	

	
	
}
