package com.yedam.project;

import java.util.Scanner;

public class ProductMain {
	
	public static Scanner scanner = new Scanner(System.in);
	private static ProductJdbc dao1 = new ProductJdbc();
	private static CompanyJdbc dao2 = new CompanyJdbc();
	
	private static Product loginUser(String userId, String userPw) {
		return dao1.loginUser(userId, userPw);
	}
	
	private static Product searchId(String id) {
		return dao1.select(id);
	}
	
	private static Company loginCompany(String companyNum, String companyId, String companyPw) {
		return dao2.loginCompany(companyNum, companyId, companyPw);
	}
	
	private static Company searchNumId(String companyNum, String companyId) {
		return dao2.select(companyNum, companyId);
	}
	
	public static void main(String[] args) {
		
		boolean run = true;
		
//		while(run) {
//			System.out.println("------------------------------");
//			System.out.println("1.사용자 2.판매자");
//			System.out.println("------------------------------");
//			int num = Integer.parseInt(scanner.nextLine());
//		}
		
//		while(user) {
//			
//			System.out.print("<사용자 로그인> ID 입력 : ");
//			String userId = scanner.nextLine();
//			System.out.print("<사용자 로그인> PW 입력 : ");
//			String userPw = scanner.nextLine();
//			
//			Product product = loginUser(userId, userPw);
//			
//			if(product != null) {
//				System.out.println("로그인 완료");
//				break;
//			}
//			System.out.println("ID, PW를 확인하세요");
//		}
		
//		while(run) {
//			
//			System.out.print("<사용자 회원가입> ID 입력 : ");
//			String putUserId = scanner.nextLine();		
//			if(dao1.select(putUserId) != null) {
//				System.out.println("등록된 ID 입니다");
//				continue;
//			}
//			System.out.print("<사용자 회원가입> PW 입력 : ");
//			String putUserPw = scanner.nextLine();
//			
//			Product product = new Product(putUserId, putUserPw);
//			
//			if(dao1.insert(product)) {
//				System.out.println("정상등록");
//			} else {
//				System.out.println("등록예외");
//			}
//			run = false;
//		}
//		
//		while(run) {
//
//			System.out.print("<판매자 로그인> 사업자번호 입력 : ");
//			String companyNum = scanner.nextLine();
//			System.out.print("<판매자 로그인> ID 입력 : ");
//			String companyId = scanner.nextLine();
//			System.out.print("<판매자 로그인> PW 입력 : ");
//			String companyPw = scanner.nextLine();
//			
//			Company company = loginCompany(companyNum, companyId, companyPw);
//			
//			if(company != null) {
//				System.out.println("로그인 완료");
//				break;
//			}
//			System.out.println("사업자 번호, ID, PW를 확인하세요");
//		}
		
		while(run) {
			System.out.print("<판매자 회원가입> 사업자번호 입력 : ");
			String putCompanyNum = scanner.nextLine();
			System.out.println("<판매자 회원가입> ID 입력 : ");
			String putCompanyId = scanner.nextLine();
			if(dao2.select(putCompanyNum, putCompanyId) != null) {
				System.out.println("등록된 사업자번호, ID입니다");
				continue;
			}
			System.out.println("<판매자 회원가입> PW 입력 : ");
			String putCompanyPw = scanner.nextLine();
			
			Company company = new Company(putCompanyNum, putCompanyId, putCompanyPw);
			
			if(dao2.insert(company)) {
				System.out.println("정상등록");
			} else {
				System.out.println("등록예외");
			}
		}
	}		
}



//while (run) {
//	
//	Scanner scanner = new  Scanner(System.in);
//	System.out.println("------------------------------");
//	System.out.println("1.사용자 2.판매자");
//	System.out.println("------------------------------");
//	String num = scanner.nextLine();
//
//	switch (Integer.parseInt(num)) {
//	case 1 :
//		System.out.print("ID입력 : ");
//		String id1 = scanner.nextLine();
//		System.out.print("PW입력 : ");
//		String pw1 = scanner.nextLine();
//		run = false;
//		break;
//	case 2 :
//		System.out.print("ID입력 : ");
//		String id2 = scanner.nextLine();
//		System.out.print("PW입력 : ");
//		String pw2 = scanner.nextLine();
//		run = false;
//		break;
//	default : 
//		System.out.println("다시 입력하세요");
//	}
//}