package com.yedam.classes;

public class MethodExe2 {
	
	//필드
	Product[] store;
	
	//생성자
	public MethodExe2() {
		store = new Product[10];
		store[0] = new Product("A001", "지우개", 500);
		store[1] = new Product("B001", "샤프1000", 1000);
		store[2] = new Product("C001", "연필500", 800);
		store[3] = new Product("D001", "지우개", 1000);
	}
	
	//메서드
	public boolean add(Product prd) {
		for(int i = 0; i < store.length; i++) {
			if(store[i] == null) {
				store[i] = prd;
				return true;
			}
		}
		return false;
	}
	
	public Product[] productList(Product prd) {
		Product[] list = new Product[10];
		int idx = 0;
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null) {
				if(prd.getProductName().equals("ALL") || store[i].getProductName().equals(prd.getProductName())) {
					if(store[i].getPrice() >= prd.getPrice()) {
						list[idx++] = store[i];	
					} 
				}
			}
		}
		return list;
	}
	
	public boolean remove(String code) {
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null && store[i].getProductCode().equals(code)) {
				store[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean modify(Product prod) {
		
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null && store[i].getProductCode().equals(prod.getProductCode())) {
				if(prod.getProductName() != null) {
					store[i].setProductName(prod.getProductName());
				}
				if(prod.getPrice() != 0) {
					store[i].setPrice(prod.getPrice());
				}
				return true;
			}
		}
		System.out.println("수정");
		return false;
	}
}
