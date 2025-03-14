package com.yedam.inheritance;

// 친구 정보중 공통된 부분을 담아놓은 클래스

public class Friend {

	//필드
	private String name;
	private String tel;
	
	//생성자
	public Friend() {
	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "이름은 " + getName() + ", 연락처는 " + getTel();
	}
	
	//getter setter
	
	public String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
