package com.yedam.bookApp;

public class Book2 {
	
	private String title;
	private String author;
	private String company;
	private int price;
	
	public Book2(String title, String author, String company, int price) {
		this.title = title;
		this.author = author;
		this.company = company;
		this.price = price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getCompany() {
		return company;
	}
	public int getPrice() {
		return price;
	}
}
