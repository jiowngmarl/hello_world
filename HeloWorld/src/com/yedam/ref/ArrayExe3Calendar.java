package com.yedam.ref;

import java.util.Iterator;

public class ArrayExe3Calendar {
	
	// 2025년 기준으로 1일의 위치를 지정하는 메서드
	public static int getFirstDay(int month) {
		
		switch(month) {
		case 1 :
			return 3;
		case 2 :
			return 6;
		case 3 :
			return 6;
		case 4 :
			return 2;
		default :
			return 1;
		}
	}
	
	public static int getLastDate(int month) {
		
		int date = 31;
		switch(month) {
		case 2 :
			date = 28;
			break;
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			date = 30;
		}
		return date;
	}
	
	
	
	public static void main(String[] args) {
		
		String[] days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		// String.valueof(dayCount).length() -> dayCount의 숫자를 문자로 바꿔주는것, 이것과 if 문을 이용하여 문자의 길이가 1일때 공백 2개, 2일때 공백 1개로 만들기도 가능
		
		for (String day : days) {
			System.out.print(" " + day);
		}
		System.out.println();
		int month = 3;
		int space = getFirstDay(month); // 1일의 위치값
		int lastDate = getLastDate(month); // 월단위 마지막 일수를 표시 (예) 2월의 마지막은 28일

		for(int i = 0; i < space; i++) {
			System.out.print("    ");
		}
		
		for(int d = 1; d <= lastDate; d++) {
			if(String.valueOf(d).length() == 1) {
				System.out.print("   " + d);
			} else if (String.valueOf(d).length() == 2){
				if(d == 21) {
					System.out.print(" TST");
				} else {
					System.out.print("  " + d);
				}
			}
			if((d + space) % 7 == 0) {
				System.out.println();
			}
		}
	}
}
