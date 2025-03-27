package com.yedam.project;

import java.util.List;
import java.util.Scanner;

import oracle.net.aso.p;

public class ProjectMain {
	
	public static Scanner scanner = new Scanner(System.in);
	private static UserJdbc dao1 = new UserJdbc();
	private static CompanyJdbc dao2 = new CompanyJdbc();
	private static ProductJdbc dao3 = new ProductJdbc();
	public static ProjectMain projectMain = new ProjectMain();
	
	private String companyNum;
	private String userId;
	private static boolean select = true;
	private static boolean user = false;
	private static boolean company = false;
	
	public void userLogin() { // 사용자 로그인
		
		while(true) {
			
			System.out.println("--------------------------------------------");
			System.out.println("<사용자 로그인>");
			System.out.println("<뒤로가기 : B>");
			System.out.print("ID 입력 : ");
			String userId = scanner.nextLine();
			
			if(userId.equals("b")) {
				break;
			}
			
			System.out.print("PW 입력 : ");
			String userPw = scanner.nextLine();
			System.out.println("--------------------------------------------");
			
			User user = loginUser(userId, userPw);
			
			if(user != null) {
				System.out.println("로그인 완료");
				this.userId = userId;
				break;
			} 
			System.out.println("ID, PW를 확인하세요");
		}	
	}
	
	public void newUserAccount() {  // 사용자 회원가입
		
		while(true) {
			
			System.out.println("<사용자 회원가입>");
			System.out.println("<뒤로가기 : B>");
			System.out.print("ID 입력 : ");
			String putUserId = scanner.nextLine();	
			
			if(dao1.select(putUserId) != null) {
				System.out.println("등록된 ID 입니다");
				continue;
			}
			
			if(putUserId.equals("b")) {
				break;
			}
			

			System.out.print("<사용자 회원가입> PW 입력 : ");
			String putUserPw = scanner.nextLine();
			
			User user = new User(putUserId, putUserPw);
			
			if(dao1.insert(user)) {
				System.out.println("정상등록");
				break;
			} else {
				System.out.println("등록예외");
			}
		}
	}
		
	public void companyLogin() { // 판매자 로그인
		
		while(true) {
			
			System.out.println("--------------------------------------------");
			System.out.println("<판매자 로그인>");
			System.out.println("<뒤로가기 : B>");
			System.out.print("사업자번호 입력 : ");
			String companyNum = scanner.nextLine();
			
			if(companyNum.equals("b")) {
				break;
			}
			
			System.out.print("ID 입력 : ");
			String companyId = scanner.nextLine();
			System.out.print("PW 입력 : ");
			String companyPw = scanner.nextLine();
			System.out.println("--------------------------------------------");
			
			Company company = loginCompany(companyNum, companyId, companyPw);
			
			if(company != null) {
				System.out.println("로그인 완료");
				this.companyNum = companyNum;
				break;
			}
			System.out.println("사업자 번호, ID, PW를 확인하세요");
		}	
	}
	
	public void newCompanyAccount() { // 판매자 회원가입
		
		while(true) {
			System.out.println("<판매자 회원가입>");
			System.out.println("<뒤로가기 : B>");
			System.out.print("<판매자 회원가입> 사업자번호 입력 : ");
			String putCompanyNum = scanner.nextLine();
			
			if(putCompanyNum.equals("b")) {
				break;
			}
			
			System.out.print("<판매자 회원가입> ID 입력 : ");
			String putCompanyId = scanner.nextLine();
			if(dao2.select(putCompanyNum, putCompanyId) != null) {
				System.out.println("등록된 사업자번호, ID입니다");
				continue;
			}
			System.out.print("<판매자 회원가입> PW 입력 : ");
			String putCompanyPw = scanner.nextLine();
			
			Company company = new Company(putCompanyNum, putCompanyId, putCompanyPw);
			
			if(dao2.insert(company)) {
				System.out.println("정상등록");
				break;
			} else {
				System.out.println("등록예외");
			}
		}
	}
	
	public void userProductSystem() {
		
		while(true) {
			
			String loggedInUserId = projectMain.getLoggedInUserId();
			List<Product> list = dao1.userList();
			System.out.println("--------------------------------------------");
			System.out.printf("%-9s %-9s %-9s %-9s%n","<상품코드>","<상품명>","<상품가격>","<회사명>");
			for(Product pro : list) {
				System.out.println(" " + pro.userShowList());
			}
			System.out.println("<1.상품구매><2.구매상품><3.종료>");
			System.out.println("--------------------------------------------");
			int userMenu = Integer.parseInt(scanner.nextLine());
			
			if(userMenu == 1) {
				
				String productCode = "";
				
				while(true) {
					
					System.out.print("구매할 상품의 코드를 입력하세요 : ");
					productCode = scanner.nextLine();
					
					if(!productCode.isBlank()) {
						break;
					}
					System.out.println("코드를 입력하세요");
				}
				

				List<Product> list1 = dao1.userSearchList(productCode);
				for(Product pro : list1) {
					System.out.println("--------------------------------------------");
					System.out.println(pro.userShowList());
					System.out.println("--------------------------------------------");
				}
				
				Product selectProduct = null;
				System.out.print("검색한 상품을 구매하시겠습니까 (Y/N) : ");
				String answer = scanner.nextLine();
				
				if(answer.equals("y")) {
					List<Product> list2 = dao1.userSearchList(productCode);
					for(Product pro : list2) {
						if(pro.getProductCode().equals(productCode)) {
							selectProduct = pro;
							break;
						}
					}
					
					if(selectProduct != null) {
						selectProduct.setUserId(loggedInUserId);
						dao1.userInsert(selectProduct);
						System.out.println("구매완료");
						continue;
					} else if(answer.equals("n")) {
						System.out.println("구매실패");
					}	
				}
			} else if(userMenu == 2) {
				System.out.println("-------------------------------------------------");
				System.out.println("<구매목록>");
				System.out.printf("%-9s %-9s %-9s %-9s %-9s%n","<아이디>","<상품코드>","<상품명>","<상품가격>","<회사명>");
				List<Product> list2 = dao3.userlist(loggedInUserId);
				for(Product pro : list2) {
					System.out.println(" " + pro.purchaseList());
				}
				System.out.println("-------------------------------------------------");
			} else if(userMenu == 3) {
				System.out.println("종료합니다");
				user = false;
				break;
			} else {
				System.out.println("다시 입력하세요");
			}
		
		}
	}
	
	public void companyProductSystem() {
		
		while(true) {
			
			String loggedInCompanyNum = projectMain.getLoggedInCompanyNum();
			
			
			System.out.println("--------------------------------------------");
			System.out.println("<등록한 상품 목록>");
			System.out.printf("%-9s %-9s %-9s %-9s %-9s%n","<사업자>","<상품코드>","<상품명>","<상품가격>","<회사명>");
			List<Product> list = dao3.list(loggedInCompanyNum);
			for(Product pro : list) {
					System.out.println(" " + pro.showList());
			}
			System.out.println("<1.상품등록><2.상품정보수정><3.등록상품삭제><4.종료>");
			System.out.println("--------------------------------------------");
			
			int num = Integer.parseInt(scanner.nextLine());
			
			if(num == 1) {
								
				System.out.println("<상품 등록>");
				System.out.print("상품코드 : ");
				String productCode = scanner.nextLine();
				if(dao3.select(productCode) != null) {
					System.out.println("등록된 코드의 상품입니다");
					continue;
				}
				
				System.out.print("상품명 : ");
				String productName = scanner.nextLine();
				System.out.print("상품가격 : ");
				int price = Integer.parseInt(scanner.nextLine());
				System.out.print("상품회사 : ");
				String productCompany = scanner.nextLine();
				
				Company company = new Company(loggedInCompanyNum);
				Product product = new Product(company, productCode, productName, price, productCompany);
				
				if(dao3.insert(product)) {
					System.out.println("정상등록");
				} else {
					System.out.println("등록예외");
				}
				
			} else if(num == 2) {
				
				while(true) {
					
					Product product = new Product();
					
					System.out.print("수정할 상품의 코드릅 입력하세요 : ");
					String productCode = scanner.nextLine();

					if(productCode.isBlank()) {
						System.out.println("상품코드를 반드시 입력하세요");
						continue;
					}
					
					System.out.print("상품명 수정 : ");
					String updateProductName = scanner.nextLine();
					System.out.print("상품가격 수정 : ");
					int updateProductPrice = Integer.parseInt(scanner.nextLine());		
					System.out.print("상품회사 수정 : ");
					String updateProductCompany = scanner.nextLine();
					
					
					product.setProductCode(productCode);
					product.setProductName(updateProductName);
					product.setPrice(updateProductPrice);					
					product.setProductCompany(updateProductCompany);
					
					if(dao3.update(product)) {
						System.out.println("수정성공");
					} else {
						System.out.println("구매자가 존재하여 수정할 수 없습니다");
					}
					break;
				}
					
			} else if(num == 3) {
				
				System.out.print("삭제할 상품의 코드를 입력하세요 : ");
				String deleteProduct = scanner.nextLine();
				
				if(deleteProduct.isBlank()) {
					System.out.println("상품코드를 반드시 입력하세요");
					continue;
				}
				
				
				if(dao3.delete(deleteProduct)) {
					System.out.println("삭제성공");
				} else {
					System.out.println("구매자가 존재하여 삭제할 수 없습니다");
				}
				
			} else if(num == 4) {
				
				System.out.println("종료합니다");
				company = false;
				break;
			} else {
				System.out.println("다시 입력하세요");
			}
		}	
	}
	
	
	public void loginTotal() {
		
		while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("1.사용자 2.판매자");
			System.out.println("--------------------------------------------");
			int menu = Integer.parseInt(scanner.nextLine());
			
			if (menu == 1) {
				System.out.println("--------------------------------------------");
				System.out.println("<사용자>");
				System.out.println("1.로그인 2.회원가입");
				System.out.println("--------------------------------------------");
				int num1 = Integer.parseInt(scanner.nextLine());
				
				if(num1 == 1)  {
					projectMain.userLogin();
					if(projectMain.getLoggedInUserId() == null) {
						continue;
					} else {
						select = false;
						user = true;
						break;
					}
				} else if(num1 == 2) {
					projectMain.newUserAccount();
				}
			} else if(menu == 2) {
				System.out.println("--------------------------------------------");
				System.out.println("<판매자>");
				System.out.println("1.로그인 2.회원가입");
				System.out.println("--------------------------------------------");
				int num2 = Integer.parseInt(scanner.nextLine());
				
				if(num2 == 1) {
					projectMain.companyLogin();
					if(projectMain.getLoggedInCompanyNum() == null) {
						continue;
					} else {
						select = false;
						company = true;
						break;
					}
				} else if(num2 == 2) {
					projectMain.newCompanyAccount();
				}
			} else {
				System.out.println("다시 입력하세요");
			}
		}
		
	}
	
	public String getLoggedInUserId() { // 사용자 아이디 정보
		return this.userId;
	}
	
	public String getLoggedInCompanyNum() { // 판매자 사업자 번호 정보
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
	
	
	public void start() {
		
		while(select) {
			projectMain.loginTotal();
		}
		
		while(user) {
			projectMain.userProductSystem();
		}

		while(company) {
			projectMain.companyProductSystem();
		}
		
	}
}	


