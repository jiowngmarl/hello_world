package com.yedam.classes;

import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	
	//필드
	private List<Product> store;
	
	//생성자
	public MethodExe2() {
		store = new ArrayList<Product>(); // new Product[10];
		store.add(new Product("A001", "지우개", 500));
		store.add(new Product("B001", "샤프1000", 1000));
		store.add(new Product("C001", "연필500", 800));
		store.add(new Product("D001", "지우개", 1000));
	}
	
	//메서드
	public boolean add(Product prd) {
		boolean result = store.add(prd);
		return result;
	}
	
	public List<Product> productList(Product prd) {
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < store.size(); i++) {
			if(prd.getProductName().equals("ALL") || store.get(i).getProductName().equals(prd.getProductName())) {
				if(store.get(i).getPrice() >= prd.getPrice()) {
					list.add(store.get(i));	
				} 
			}
		}
		return list;
	}
	
	public boolean remove(String code) {
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(code)) {
				store.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean modify(Product prod) {
		
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(prod.getProductCode())) {
				if(prod.getProductName() != null) {
					store.get(i).setProductName(prod.getProductName());
				}
				if(prod.getPrice() != 0) {
					store.get(i).setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}
}
