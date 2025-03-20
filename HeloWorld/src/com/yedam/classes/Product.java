package com.yedam.classes;

import java.io.Serializable;

public class Product implements Serializable{ // Serializable 을 상속받으므로 Product는 직렬화, 역직렬화가 가능해졌다
	
	private String productCode;
	private String productName;
	private int price;
	
	public Product() {}
	public Product( String pc, String pn, int price) {
		productCode = pc;
		productName = pn;
		this.price = price;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String showList() {
		return productCode + " " + productName + " " + price;	
	}
}
