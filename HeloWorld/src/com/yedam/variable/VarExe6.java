package com.yedam.variable;

import java.util.Scanner;

public class VarExe6 {
	public static void test() {
		
			// 임의의 정수 1~50 임의의 값.
			// 0 <= x < 1
			for(int i = 0; i <= 5; i++) {
			System.out.println((int) (Math.random() * 50) + 1);
			}
			// 학생의 점수를 30~100
			// 정수(int) -> 5개 저장.
			// 홀수의 값을 출력
			
			int[] nums = new int[5];
			
			for(int i = 0; i < nums.length; i++) {
				nums[i] = ((int) (Math.random() * 71) + 30); 
				if(nums[i] % 2 != 0) {
					System.out.println(nums[i]);
				}
			}
	
	}
//	public static void main(String[] args) {
//		Member m1 = new Member();
//		m1.name = "홍길동";
//		System.out.println();
//		Member m2 = new Member();
//		m2.name = "최민수";
//		Member m3 = new Member();
//		m3.name = "김병수";
//		Member m4 = new Member();
//		m4.name = "박인만";
//		
//		Member[] members = {m1, m2, m3, m4};
//		int a = members[0].score;
//		String name = members[0].name;
//		// 70 ~ 100 사이의 임의값으로 점수지정
//		for(int i = 0; i < members.length; i++) {
//			members[i].score = ((int) (Math.random() * 71) + 30);
//			if(a < members[i].score) {
//				a = members[i].score;
//				name = members[i].name;
//				}
//			System.out.println("점수 : " + members[i].score + " 이름 : " + members[i].name);
//			}
//		System.out.println("최고점수 : " + a + " 이름 : " + name);
//	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Member m1 = new Member(m1.score);
		m1.name = "홍길동";
		Member m2 = new Member();
		m2.name = "최민수";
		Member m3 = new Member();
		m3.name = "김병수";
		Member m4 = new Member();
		m4.name = "박인만";
		
		Member[] members = {m1, m2, m3, m4};
		
		// 조회이름을 입력 -> 점수출력
		
		for(int i = 0; i < members.length; i++) {
			members[i].score = ((int) (Math.random() * 71) + 30);
			System.out.println("점수 : " + members[i].score + " 이름 : " + members[i].name);
		}
	
		System.out.println("조회할 이름 입력 : ");
		String search = scanner.nextLine();
		for(int i = 0; i < members.length; i++) {
			if(members[i].name.equals(search)) {
				System.out.println("성적 : " + members[i].score);
			}
		}
		
	}
}
