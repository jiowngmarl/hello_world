package com.yedam.project;

public class Product {

	String userId;
	String companyNum;
	String productCode;
	String productName;
	int price;
	String productCompany;

	
	public Product() {}
	

	public Product(User user, String productCode, String productName, int price, String productCompany) {
	    this.userId = user.getUserId();
	    this.productCode = productCode;
	    this.productName = productName;
	    this.price = price;
	    this.productCompany = productCompany;
	}
	
	
	public Product(Company company, String productCode, String productName, int price, String productCompany ) {
		this.companyNum = company.getCompanyNum();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.productCompany = productCompany;
	}

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String userShowList() {
		return productCode + " " + productName + " " + price + " " + productCompany;
	}
	
	public String purchaseList() {
		return userId + " " + productCode + " " + productName + " " + price + " " + productCompany;
	}
	
}
