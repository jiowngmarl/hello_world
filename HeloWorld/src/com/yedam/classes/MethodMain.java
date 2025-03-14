package com.yedam.classes;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class MethodMain {
	
	private String code;
	private String name;
	private int price;
	
	public MethodMain(String code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static void main(String[] args) {

		officeApp();	
	}
	
	static void officeApp() {
		
		// 기능을 정의
		MethodExe2 m2 = new MethodExe2();
		Product[] lists = new Product[10];
		
		// 사용자의 입력을 받아서 기능을 구현 (1.목록 / 2.추가 / 3.수정 / 4.삭제 / 9.종료)  
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1.목록 / 2.추가 / 3.수정 / 4.삭제 / 9.종료");
		System.out.print("번호 입력 : ");
		int num = Integer.parseInt(scanner.nextLine());  
		boolean start = true;
		
		while(start) {
			
			switch(num) {
			case 1 :
				break;
			case 2 :
				System.out.println("추가 코드:");
				String code = scanner.nextLine();
				System.out.println("추가 이름:");
				String name = scanner.nextLine();
				System.out.println("추가 가격:");
				String price = scanner.nextLine();
				
				MethodMain m = new MethodMain(code, name, Integer.parseInt(price));
				
				break;
			case 3 :
				
				m2.productList(null);
				break;
			case 4 :
				System.out.print("삭제할 코드 입력 : ");
				m2.remove(null);
				
				break;
			case 9 :
				System.out.println("종료합니다");
				start = false;
				break;
			}
			
		}
		
	}
		
		public void method4() {
			
			MethodExe4 m4= new MethodExe4();
			m4.main();
		}
	
		public void method3() {
			
			MethodExe3 gugudan = new MethodExe3();
			System.out.println(gugudan.gugudan(3, 7));
			gugudan.printStar(4, "*");
			gugudan.printCard();
		}
	
	
		public void method2() {
			MethodExe2 m2 = new MethodExe2();

//			Product prod = new Product("A001", null, 500);
//			if(m2.modify(prod)) {
//				System.out.println("수정성공");
//			}
			
			if(m2.add(new Product("M001", "만연필", 10000))) { // add가 boolean값을 반환하여 true or false를 받기 때문에 if문에 들어가는것이 가능
				System.out.println("등록완료");
			}
			Product search = new Product();
			search.setProductName("지우개");
			search.setPrice(700);
			
			Product[] list = m2.productList(search);
			for(int i = 0;  i < list.length; i++) {
				if(list[i] != null) {
					System.out.println(list[i].showList());
				}
			}
			
			if(m2.remove("A001")) {
				System.out.println("삭제완료");
			}
			
		}
	

	
	public void method1() {
		
		MethodExe1 m1 = new MethodExe1();
//		System.out.println(m1); // MethodExe1의 주소값을 답은 m1를 출력하면 출력값 또한 주소값이 나온다.
		
		int n = 3;
		m1.printString(n, "*"); // MethodExe1에 객체인 printString을 가져와서 인스턴스로 사용하여 출력
		double result = m1.sum(n, 40.5);
		System.out.println(result);
		
		int sum1 = m1.sum(new int[] {10, 20, 30});
		System.out.println(sum1);
		
		double sum2 = m1.sum(new double[] {10, 10.5, 20.5});
		System.out.println(sum2);
		
		System.out.println("수정");
	}
}
