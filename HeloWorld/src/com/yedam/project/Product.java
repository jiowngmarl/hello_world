package com.yedam.project;

public class Product {

	String companyNum;
	String productCode;
	String productName;
	int price;
	String productCompany;

	
	public Product() {}
	
	public Product(String companyNum, String productCode, String prodcutName, int price, String productCompany ) {
		this.companyNum = companyNum;
		this.productCode = productCode;
		this.productName = prodcutName;
		this.price = price;
		this.productCompany = productCompany;

	}

	public String getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
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

	public String getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String showList() {
		return companyNum + " " + productCode + " " + productName + " " + price + " " + productCompany;
	}
	
}
