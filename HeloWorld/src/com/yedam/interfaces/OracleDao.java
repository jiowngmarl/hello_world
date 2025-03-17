package com.yedam.interfaces;

public class OracleDao implements Dao{

	@Override
	public void insert() {
		System.out.println("oracle 용 등록");
	}
	
	@Override
	public void update() {
		System.out.println("oracle 용 수정");
	}
	
	@Override
	public void delete() {
		System.out.println("oracle 용 삭제");
	}
}
