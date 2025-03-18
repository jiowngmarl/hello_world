package com.yedam.collections;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class ListExe {

	public static void main(String[] args) {
		
		// 배열을 활용해서 값을 추가할 경우 새로운 배열을 선언해서 기존의 값을 복사하여 넣어주고 값을 추가해야한다
		
		int[] intAry = {10, 20};
		int[] intAry2 =  new int[5];
		for(int i = 0; i<intAry.length; i++) {
			intAry2[i] = intAry[i];
		}
		intAry2[2] =30;
		
		// add를 통해서 배열의 크기를 가변적으로 이용가능
		List<Integer> list = new ArrayList<Integer>();
		list.add(10); // 추가
		list.add(14);
		list.add(17);
		list.add(20);
		
		Integer it1 = list.get(0); // 조회
		
		list.remove(0); // 삭제
		
		list.set(0, 30); // 수정
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// List - ArrayList
		// 선언할 때 타입을 지정해주면 오류발생을 줄일 수 있다
		List<String> list2 = new ArrayList<String>();
		list2.add("Hello");
//		list2.add(200);
//		list2.add(new Book());
		
		List<Book> list3 = new ArrayList<Book>();
		list3.add(new Book());
		
		
		for(int i = 0; i < list2.size(); i++) {
			String result = (String) list2.get(i); // Object는 최상위 클래스로 어떠한 값(int형, Integer형, ..)이 다 들어갈 수 있지만 캐스팅을 통해 자식의 형태와 맞춰주어야한다
		}
	}
}
