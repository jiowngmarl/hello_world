package com.yedam.project;

public class practice {

//	
//	
////	--상품코드를 입력받고 구매하기
////		System.out.print("구매할 상품의 코드를 입력하세요 : ");
//		String productCode = scanner.nextLine();
//		
//		
//		List<Product> list1 = dao1.userSearchList(productCode);
//		for(Product pro : list1) {
//			System.out.println(pro.userShowList());

//	
////	-- 코드를 검색한 상품의 구매여부 확인
//	Product selectProduct = null;
//	System.out.print("검색한 상품을 구매하시겠습니까 (Y/N) : ");
//	String answer = scanner.nextLine();
//	
//	if(answer.equals("y")) {
//		List<Product> list2 = dao1.userSearchList(productCode);
//		for(Product pro : list2) {
//			if(pro.getProductCode().equals(productCode)) {
//				selectProduct = pro;
//				break;
//			}
//		}
//		
//		if(selectProduct != null) {
//			selectProduct.setUserId(loggedInUserId);
//			dao1.userInsert(selectProduct);
//			System.out.println("구매완료");
//		} else if(answer.equals("n")) {
//			System.out.println("구매실패");
//		}	
//	
//	}
	
//	List<Product> list2 = dao3.userlist(loggedInUserId);
//	for(Product pro : list2) {
//		System.out.println(pro.purchaseList());
//	}
	
	


			
			

	
//	--메서드를 이용한 판매자 로그인 및 등록한 상품 목록을 출력

	

//	--판매자 상품 수정
//	System.out.print("수정할 상품의 코드릅 입력하세요 : ");
//	String productCode = scanner.nextLine();
//	System.out.print("상품명 수정 : ");
//	String updateProductName = scanner.nextLine();
//	System.out.print("상품가격 수정 : ");
//	String updateProductPrice = scanner.nextLine();
//	System.out.print("상품회사 수정 : ");
//	String updateProductCompany = scanner.nextLine();
//	
//	Product product = new Product();
//	product.setProductCode(productCode);
//	product.setProductName(updateProductName);
//	product.setPrice(Integer.parseInt(updateProductPrice));
//	product.setProductCompany(updateProductCompany);
//	
//	if(dao3.update(product)) {
//		System.out.println("수정성공");
//	} else {
//		System.out.println("수정예외");
//	}
	
//	--판매자 상품 삭제
//	System.out.print("삭제할 상품의 코드를 입력하세요 : ");
//	String deleteProduct = scanner.nextLine();
//	
//	if(dao3.delete(deleteProduct)) {
//		System.out.println("삭제성공");
//	} else {
//		System.out.println("삭제예외");
//	}
	
//	--판매자 상품등록
//	while(true) {
//		
//		System.out.println("<상품 등록>");
//		System.out.print("상품코드 : ");
//		String productCode = scanner.nextLine();
//		if(dao3.select(productCode) != null) {
//			System.out.println("등록된 코드의 상품입니다");
//			continue;
//		}
//		
//		System.out.print("상품명 : ");
//		String productName = scanner.nextLine();
//		System.out.print("상품가격 : ");
//		int price = Integer.parseInt(scanner.nextLine());
//		System.out.print("상품회사 : ");
//		String productCompany = scanner.nextLine();
//		
//		Product product = new Product(loggedInCompanyNum ,productCode, productName, price, productCompany);
//		
//		if(dao3.insert(product)) {
//			System.out.println("정상등록");
//		} else {
//			System.out.println("등록예외");
//		}
//	}
	




//while (run) {
//
//Scanner scanner = new  Scanner(System.in);
//System.out.println("------------------------------");
//System.out.println("1.사용자 2.판매자");
//System.out.println("------------------------------");
//String num = scanner.nextLine();
//
//switch (Integer.parseInt(num)) {
//case 1 :
//	System.out.print("ID입력 : ");
//	String id1 = scanner.nextLine();
//	System.out.print("PW입력 : ");
//	String pw1 = scanner.nextLine();
//	run = false;
//	break;
//case 2 :
//	System.out.print("ID입력 : ");
//	String id2 = scanner.nextLine();
//	System.out.print("PW입력 : ");
//	String pw2 = scanner.nextLine();
//	run = false;
//	break;
//default : 
//	System.out.println("다시 입력하세요");
//}
//}
	
	
}
