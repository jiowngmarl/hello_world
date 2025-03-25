package com.yedam.project;

import java.util.List;
import java.util.Scanner;

import oracle.net.aso.p;

public class ProjectMain {
	
	public static Scanner scanner = new Scanner(System.in);
	private static UserJdbc dao1 = new UserJdbc();
	private static CompanyJdbc dao2 = new CompanyJdbc();
	private static ProductJdbc dao3 = new ProductJdbc();
	
	private String companyNum;
	
	public void login() {
		
		while(true) {
			
			System.out.print("<판매자 로그인> 사업자번호 입력 : ");
			String companyNum = scanner.nextLine();
			System.out.print("<판매자 로그인> ID 입력 : ");
			String companyId = scanner.nextLine();
			System.out.print("<판매자 로그인> PW 입력 : ");
			String companyPw = scanner.nextLine();
			
			Company company = loginCompany(companyNum, companyId, companyPw);
			
			if(company != null) {
				System.out.println("로그인 완료");
				this.companyNum = companyNum;
				break;
			}
			System.out.println("사업자 번호, ID, PW를 확인하세요");
		}
		
	}
	
	public String getLoggedInCompanyNum() {
		return this.companyNum;
	}
	
	
	private static User loginUser(String userId, String userPw) {
		return dao1.loginUser(userId, userPw);
	}
	
	private static User searchId(String id) {
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
		
//		--사용자 로그인
//		while(run) {
//			
//			System.out.print("<사용자 로그인> ID 입력 : ");
//			String userId = scanner.nextLine();
//			System.out.print("<사용자 로그인> PW 입력 : ");
//			String userPw = scanner.nextLine();
//			
//			User user = loginUser(userId, userPw);
//			
//			if(user != null) {
//				System.out.println("로그인 완료");
//				break;
//			}
//			System.out.println("ID, PW를 확인하세요");
//		}
		
//		--사용자 회원가입
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
//			User user = new User(putUserId, putUserPw);
//			
//			if(dao1.insert(user)) {
//				System.out.println("정상등록");
//			} else {
//				System.out.println("등록예외");
//			}
//			run = false;
//		}
//		
//		--판매자 로그인
//		while(run) {
//			
//			String returnCompanyNum = "";
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
//				returnCompanyNum = companyNum;
//				break;
//			}
//			System.out.println("사업자 번호, ID, PW를 확인하세요");
//			
//		}
		
		ProjectMain projectMain = new ProjectMain();
		projectMain.login();
		
		String loggedInCompanyNum = projectMain.getLoggedInCompanyNum();

		
		System.out.println("<등록한 상품 목록>");

		
		List<Product> list = dao3.list(loggedInCompanyNum);

		for(Product pro : list) {

				System.out.println(pro.showList());

		}
		
		
//		--판매자 상품 수정
//		System.out.print("수정할 상품의 코드릅 입력하세요 : ");
//		String productCode = scanner.nextLine();
//		System.out.print("상품명 수정 : ");
//		String updateProductName = scanner.nextLine();
//		System.out.print("상품가격 수정 : ");
//		String updateProductPrice = scanner.nextLine();
//		System.out.print("상품회사 수정 : ");
//		String updateProductCompany = scanner.nextLine();
//		
//		Product product = new Product();
//		product.setProductCode(productCode);
//		product.setProductName(updateProductName);
//		product.setPrice(Integer.parseInt(updateProductPrice));
//		product.setProductCompany(updateProductCompany);
//		
//		if(dao3.update(product)) {
//			System.out.println("수정성공");
//		} else {
//			System.out.println("수정예외");
//		}
		
		System.out.print("삭제할 상품의 코드를 입력하세요 : ");
		String deleteProduct = scanner.nextLine();
		
		if(dao3.delete(deleteProduct)) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제예외");
		}
		
		
		
//		--판매자 상품등록
//		while(true) {
//			
//			System.out.println("<상품 등록>");
//			System.out.print("상품코드 : ");
//			String productCode = scanner.nextLine();
//			if(dao3.select(productCode) != null) {
//				System.out.println("등록된 코드의 상품입니다");
//				continue;
//			}
//			
//			System.out.print("상품명 : ");
//			String productName = scanner.nextLine();
//			System.out.print("상품가격 : ");
//			int price = Integer.parseInt(scanner.nextLine());
//			System.out.print("상품회사 : ");
//			String productCompany = scanner.nextLine();
//			
//			Product product = new Product(loggedInCompanyNum ,productCode, productName, price, productCompany);
//			
//			if(dao3.insert(product)) {
//				System.out.println("정상등록");
//			} else {
//				System.out.println("등록예외");
//			}
//		}
		

		
		
//		
//		--판매자 회원가입
//		while(run) {
//			System.out.print("<판매자 회원가입> 사업자번호 입력 : ");
//			String putCompanyNum = scanner.nextLine();
//			System.out.print("<판매자 회원가입> ID 입력 : ");
//			String putCompanyId = scanner.nextLine();
//			if(dao2.select(putCompanyNum, putCompanyId) != null) {
//				System.out.println("등록된 사업자번호, ID입니다");
//				continue;
//			}
//			System.out.print("<판매자 회원가입> PW 입력 : ");
//			String putCompanyPw = scanner.nextLine();
//			
//			Company company = new Company(putCompanyNum, putCompanyId, putCompanyPw);
//			
//			if(dao2.insert(company)) {
//				System.out.println("정상등록");
//			} else {
//				System.out.println("등록예외");
//			}
//		}
		

		
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
