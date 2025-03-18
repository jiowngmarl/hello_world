package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {

	public static void main(String[] args) {
		
		int[] intAry = {10, 20};
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(10); // int -> Integer 박싱. Integer -> int 언박싱
		list.add(new Integer(20)); // 원래의 모습은 이거지만 위에처럼 숫자만 넣어도 가능하다 -> 위에처럼 표기하는것을 권장
		//
		int num1 = 10; // ==를 이용하여 값을 비교
		Integer num2 = new Integer(20); // ==를 사용하면 주소값을 비교함
		System.out.println(num1 == num2.intValue()); // num2는 Integer클래스의 참조값(주소)이기 때문에 값을 비교하기 위해서는 intValue()를 사용하여 값을 비교해야한다
	}
}
