package com.yedam.api;

public class StringTest {

	public static void main(String[] args) {
		
		StringUtil stringUtil = new StringUtil();
		
		// 성별을 반환(남 / 여)
		String[] ssn = {"0106241230123", "010624 1230123", "010624-1230123"};
		for(int i = 0; i < ssn.length; i++) {
			String gender = StringUtil.getGender(ssn[i]);
			System.out.println(gender);
		}
		
		String[] files = {"c:/temp/orange.jpg" , "d:/storage/test/grape.jpeg", "d:/img/melon.png"};
		for(int i = 0; i < files.length; i++) {
			System.out.println("파일이름은 " + StringUtil.getFileName(files[i]));
			System.out.println("파일의 확장자는 " + StringUtil.getExtName(files[i]));
		}
	}
	
}
