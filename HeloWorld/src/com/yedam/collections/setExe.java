package com.yedam.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yedam.variable.Member;

public class setExe {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
//		set.add(100);  -> String으로 선언했기 때문에 다른타입을 적으면 오류 발생
		set.add("Hello"); // 반복되는 값을 허용하지 않는다, Hello는 한번만 출력
		
		// 인터페이스를 사용하기 때문에 (HashSet) 인덱스 번호가 없어서 반복자를 사용하여 출력해야함
		Iterator<String> iter = set.iterator(); // 반복자
		while(iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		}
		
		// Set <Member>
		Set<Member> members = new HashSet<>();
		members.add(new Member("홍길동", 80));
		members.add(new Member("김민규", 85));
		members.add(new Member("홍길동", 80)); // 공통된 값을 입력하더라도 다른 주소(참조값) 을 가지기 때문에 중복 값 허용
		
		Iterator<Member> miter = members.iterator();
		while (miter.hasNext()) {
			Member result = miter.next();
			System.out.println(result.toString());
		}
		
//		int => Integer
		
		int[] intAry = { 10, 20, 30, 40, 20, 10};
		// int 배열에서 중복된 값을 제거한 결과 list 추가
		// list 반복문 활용 출력
		Set<Integer> iset = new HashSet<>();
		// set컬렉션에 값을 저장 (중복 제거)
		for(int i = 0; i < intAry.length; i++) {
			iset.add(intAry[i]);
		}
		// 반복문 -> list 저장
		List<Integer> ilist = new ArrayList<>();
		Iterator<Integer> iterator = iset.iterator();
		while (iterator.hasNext()) {
			ilist.add(iterator.next());
		}
		// 반복문 출력
		ilist.forEach(num -> System.out.println(num));
	}
}
