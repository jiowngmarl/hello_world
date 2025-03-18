package com.yedam.api;

public class StringExe {

	public static void main(String[] args) {
		
		String str = "Hello, World";
		str = new String("Hello, World");
		byte[] bAry = str.getBytes(); // 문자열을 바이트형식으로 반환
		
		for (int i = 0;  i < bAry.length; i++) {
			System.out.println(bAry[i]);
		}
		
		byte[] bstr = {72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100};
		
//		String msg = new String(bstr);
		String msg = new String(bstr, 7, 5); // 7번째 위치부터 5개를 출력하겠다는 의미
		System.out.println(msg);
		char result = msg.charAt(0); // 문자
		System.out.println((int) result);
		
		// String : "", char : ''
		if(result == 'W') {
			// 비교구문
		}
		
		int idx = msg.indexOf("r"); // r라는 문자값을 가지고있는지, 가지고 있으면 인덱스 위치의 번호를 없으면 -1을 반환한다
		if(idx != -1) {
			// 처리하는코드를 입력
			
		}
		
		String[] names = {"홍길동", "홍길승", "김민규"};
		int cnt = 0;
		for(int i = 0; i < names.length; i++) {
			if(names[i].indexOf("길") != -1) {    // if(names[i].indexOf("홍") == 0  -> 성이 홍씨인 사람을 찾을때는 이렇게 사용 (인덱스 0번의 성이 홍인 사람)
				cnt++;
			}
		}
		System.out.println("*길* 을 포함하는 이름의 갯수 : " + cnt);
		
		System.out.println("Hello, World".substring(3, 8));  // 인덱스 3부터 8번 전까지 잘라오는것
	}
}
