package com.yedam.api;

import java.util.Calendar;

public class calendarExe {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2024); // 정보를 바꾼는 것 (년도의 정보를 바꾼 코드) , 2024년
		calendar.set(Calendar.MONTH, 1); // 2월
		calendar.set(Calendar.DATE, 10); // 10일
		calendar.set(2023, 2, 5); // 2023년 3월 5일
		
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 요일정보
		System.out.println(calendar.getActualMaximum(Calendar.DATE)); // 월의 마지막날을 출력
		
		// 년, 월 입력 = > 1일의 요일 반환, 말일을 반환
		
		getDay(2025, 7); // 7월달의 1일의 요일을 반환
		getLastDate(2025, 7); // 7월달의 마지막날
	}
	
	static String getDay(int year, int month) {
		Calendar today = Calendar.getInstance();
		today.set(year, month - 1, 1);
		int day = today.get(Calendar.DAY_OF_WEEK);
		switch (day) {
		case 1 :
			return "일요일";
		case 2 :
			return "월요일";
		case 3 :
			return "화요일";
		case 4 :
			return "수요일";
		case 5 :
			return "목요일";
		case 6 :
			return "금요일";
		case 7 :
			return "토요일";
		}
	}
	
	static int getLastDate(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month);
		System.out.println(calendar.getActualMaximum(Calendar.DATE));
		return 0;
	}
}
