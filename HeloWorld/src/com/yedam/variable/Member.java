package com.yedam.variable;

public class Member {
	
	// 클래스 : 필드 (값을 지정)
	public String name;
	public int score;
	// 클래스 생성자(실체 생성)
	// 컴파일러가 기본생성자를 생성해줌.
	// 생성자 overloading.
	public Member() {
		
	}

	public Member(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// Set컬렉션의 중복된 값으로 지정하는 것
	// name, score => hashCode + equals => 동일한값
	
	public int hasCode() {
		return score;
		
	}
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Member) {
			Member target = (Member) obj;
			return this.name.equals(target.name);	
		}
		return false;
	}
	
	// 클래스 : 메소드 (기능) = 반환값 메소드명 (매개값)
	
	public void showInfo() {
		System.out.println("이름은 " + name + " 점수는 : " + score);
	}
	
	public void setMember(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setScore(int score) {
		if(score < 0 || score > 100) {
			System.out.println("적정값을 입력하세요");
			return;
		}
		this.score = score;
	}
	public void getScore(int score) {
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// toString 재정의
	
	public String toString() {
		return "이름 : " + name + ", 점수 : " + score;
		
	}
}
