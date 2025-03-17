package com.yedam.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListExe {

	public static void main(String[] args) {
		
		// 배열 : int[], String[], Member[] => intAry[0] (인덱스 번호로 값을 지정)
		// 컬렉션 : List<Integer>, List<String>, List<Member>
		// intList.get(0) (메서드를 통해서 값을 지정)
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(100);
		intList.add(150);
		intList.add(200);
		intList.add(100);
		
		for(int i = 0 ; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
		// Set컬렉션.
		
		Set<Integer> intSet = new HashSet<Integer>();
		
		intSet.add(100);
		intSet.add(150);
		intSet.add(200);
		intSet.add(100);
		
		for(Integer num : intSet) {
			System.out.println(num);
		}
		
		//Set<Member>
		
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홀길동" , 20));
		members.add(new Member("박태욱" , 21));
		members.add(new Member("최선욱" , 22));
		members.add(new Member("최선욱" , 22)); //hashCode, equals => 동등
		
		for(Member mbr : members) {
			System.out.println(mbr.toString());
		}
	}
}


