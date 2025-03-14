package com.yedam.inheritance;

// Friend 상속받는 클래스

public class UnivFriend extends Friend {

	private String univName;
	private String major;
	
	public UnivFriend() {
		super();
	}
	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel); // 부모생성자
		this.univName = name;
		this.major = major;
	}
	
	// 부모의 메소드를 자식이 재정의 : 메서드 오버라이딩
	
	@Override
	public String getName() {
		return super.getName();
	}

//	@Override
//	public void setName(String name) {
//		// 부모 클래스에서 final 메소드이기 때문에 overriding 안됌
//	}
	
	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 학교는 " + getUnivName() + ", 학과는 " + getMajor() ;
	}
}
