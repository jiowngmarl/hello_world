package com.yedam.api;

public class StringUtil {

	static String getGender(String ssn) {

		
		int pos = -1;
		if(ssn.length() == 13) {
			pos = 6;
		} else if(ssn.length() == 14) {
			pos = 7;
		}
		
		char gNo = ssn.charAt(pos);
		switch (gNo) {
		case '1' :
		case '3' :
			return "남";
			
		case '2' :
		case '4' :
			return "여";
		default:
			return "알수없음";
		}
		
//		String sex = "";
//			
//		for(int i = 0 ; i < ssn.length(); i++) {
//			if(ssn.length() == 13 && (ssn.charAt(6) == '1' || ssn.charAt(6) == '3')) {
//				sex = "남자";
//			} else if(ssn.length() == 13 && ( ssn.charAt(6) == '2' || ssn.charAt(6) == '4')) {
//				sex = "여자";
//			} else if(ssn.length() == 14 && (ssn.charAt(7) == '1' || ssn.charAt(7) == '3')) {
//				sex = "남자";
//			} else if(ssn.length() == 14 && (ssn.charAt(7) == '2' || ssn.charAt(7) == '4')) {
//				sex = "여자";
//			}
//		}
//		return sex;
	}
	
	static String getFileName(String file) {
		int pos = 0;
		String fileName = "";
		while(true) {
			int idx = file.indexOf("/", pos); // 찾을 값, 찾을 위치의 시작값
			if (idx == -1) {
				fileName = file.substring(pos, file.indexOf(".")); // 마지막 "/" 값부터 "." 사이의 값을 fileName으로 지정하는 것
				break;
			}
			pos = idx + 1;
		}
		return fileName;
		
//		String name = "";
//		
//		for(int i = 0; i < file.length(); i++) {
//			if(file.indexOf("orange")  != -1) {
//				name = "orange";
//			} else if(file.indexOf("grape") != -1) {
//				name = "grape";
//			} else if(file.indexOf("melon") != -1) {
//				name = "melon";
//			}
//		}
//		return name;
	}

	static String getExtName(String file) {
		
		String extName = "";
		extName = file.substring(file.lastIndexOf(".") + 1); // 마지막"."으로 끝나는 곳의 인덱스에 +1 한 곳 부터 출력
		return extName;
	}
		
//		String fileName = "";
//		
//		for(int i = 0; i < files.length(); i++) {
//			if(files.indexOf("jpg") != -1) {
//				fileName = "jpg";
//			} else if(files.indexOf("jpeg") != -1) {
//				fileName = "jpeg";
//			} else if(files.indexOf("png") != -1) {
//				fileName = "png";
//			}
//		}
//		
//		return fileName;
//	}
}
