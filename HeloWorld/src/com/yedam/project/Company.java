package com.yedam.project;

public class Company {

	String companyNum;
	String companyId;
	String companyPw;
	
	public Company() {}
	
	public Company(String companyNum, String companyId, String companyPw) {
		this.companyNum = companyNum;
		this.companyId = companyId;
		this.companyPw = companyPw;
	}

	public String getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyPw() {
		return companyPw;
	}

	public void setCompanyPw(String companyPw) {
		this.companyPw = companyPw;
	}
}
