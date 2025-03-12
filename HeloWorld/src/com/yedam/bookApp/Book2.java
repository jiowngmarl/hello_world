package com.yedam.bookApp;

public class Book2 {
	
	private String title;
	private String author;
	private String compony;
	private int price;
	
	public Book2(String title, String author, String compony, int price) {
		this.title = title;
		this.author = author;
		this.compony = compony;
		this.price = price;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void set() {
		System.out.println("수정");
		System.out.println("수정");
	}
}
