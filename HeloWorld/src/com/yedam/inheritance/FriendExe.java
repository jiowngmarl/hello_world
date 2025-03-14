package com.yedam.inheritance;

// 상속

public class FriendExe {

	public static void main(String[] args) {
		
		Friend[] friends = new Friend[10];
		
		// instance
		Friend f1 = new Friend();
		f1.setName("홍길동");
		f1.setTel("010-1111-2222");
		System.out.println(f1.toString());
		
		UnivFriend f2 = new UnivFriend();
		f2.setName("김자식");
		f2.setTel("010-1111-1111");
		f2.setUnivName("우리학교");
		f2.setMajor("역사학과");
		System.out.println(f2.toString());
		
		CompanyFriend f3 = new CompanyFriend();
		f3.setName("김영식");
		f3.setTel("010-2222-3333");
		f3.setCompany("아마존");
		f3.setDept("개발팀");
		System.out.println(f3.toString());
		// 부모클래스의 변수에 자식인스턴스 대입
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		
		// Friends[] => toString()
		for(int i = 0; i <  friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
		
		// 형변환
		
		int num = 20;
		double num2 = num; // 자동형변환 promotion
		num = (int) num2; // 강제형변환 casting
		
		Friend f4 = new CompanyFriend("김무열", "010-1111-1111");
		CompanyFriend cf = (CompanyFriend) f4; // 부모클래스를 자식클래스에 대입
		
		Friend f5 = new Friend("박성길", "010-1111-1111");
		
		if(f5 instanceof CompanyFriend) {
			cf = (CompanyFriend) f5;
		} else{
			System.out.println("Casting 할 수 없습니다");
		}
	}
}
