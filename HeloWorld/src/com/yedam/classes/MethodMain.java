package com.yedam.classes;

public class MethodMain {
	
	public static void main(String[] args) {
		
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
	}
}
