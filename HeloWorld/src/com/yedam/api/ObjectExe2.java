package com.yedam.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectExe2 {

	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1.toString());
		
		Date obj2 = new Date();
		System.out.println(obj2.toString());
		
		// 출력 2025년 03월 17일 13시 23분 45초
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // hh12시 HH는 24시로 표현
		System.out.println(sdf.format(obj2));
	}
}
