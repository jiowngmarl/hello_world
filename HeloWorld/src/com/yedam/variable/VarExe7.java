package com.yedam.variable;

import java.util.Scanner;

// 추가, 수정, 삭제, 목록 출력.


// 수정 또는 삭제시 boolean isExist = false를 넣고 ture가 아닐 때 "없는 이름이다" 를 출력하는 방법도 있음 

public class VarExe7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		Member[] storage = new Member[100];
		storage[0] = new Member("홍길동", 83);
		storage[1] = new Member("김민혁", 86);
		storage[2] = new Member("한수아", 90);
		
		while(run) {
			System.out.println("1 : 등록, 2 : 수정, 3 : 삭제, 4 : 목록, 5 : 평균, 6 : 종료"); // {null, null, ... ,null}
			System.out.print("선택 >> ");
			int menu = Integer.parseInt(scanner.nextLine()); // 그냥 scannner.nextInt()를 사용하면 숫자를 입력하고 엔터를 칠 경우 숫자만 처리하고 엔터는 밑에서 처리하기 때문에 그것을 방지하기 위한 것
			
			switch(menu) {
			case 1 : 
				System.out.println("이름입력 >> ");
				String name = scanner.nextLine();
				System.out.println("점수입력 >> ");
				int score = Integer.parseInt(scanner.nextLine());
				Member member = new Member(); // 인스턴스 생성.
				member.name = name;
				member.score = score;
				// 빈공간에 값을 할당.
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] == null) {
						storage[i] = member;
						break; // for 반복문 종료.
						}
				}
				break; // case 1의 종료.
				
			case 2 : 
				System.out.println("수정할 이름 입력 >>");
				name = scanner.nextLine();
				for(int i = 0; i < storage.length; i++) {
					if(storage[i].name.equals(name)) {
						System.out.println("수정 이름 입력 : ");
						name = scanner.nextLine();
						System.out.println("수정 성적 입력 : ");
						score = Integer.parseInt(scanner.nextLine());
						storage[i].name = name;
						storage[i].score = score;
						break;
					}	
				}

				
				break;
			case 3 : // 삭제. 이름입력 조회 후 => null 대입.
				boolean isExsit = false;
				System.out.println("삭제할 이름 입력 >> ");
				name = scanner.nextLine();
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].name.contentEquals(name)) {
						storage[i] = null;
						System.out.println("삭제되었습니다.");
						isExsit = true;
						break;
					}
				}
				if(!isExsit) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
			case 4 : 
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						System.out.println("이름 : " + storage[i].name + " 점수 : " + storage[i].score);
					}
				}
				break;
			case 5 :
				int sum = 0;
				int num = 0;
				double avg = 0;
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						sum += storage[i].score;
						num ++;
					}
				}
				avg = (double) sum / num;
				System.out.println("평균은 : " + avg);
				break;
				
			case 6 :
				run = false;
			}
		}
		System.out.println("end of prog.");
	} // end of main().
	
}
