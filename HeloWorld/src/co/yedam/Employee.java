package co.yedam;

public class Employee {

	private String empNo;
	private String name;
	private String phoneNo;
	private String date;
	private int salary;
	
	public Employee() {}
	
	public Employee(String empNo, String name, String phoneNo, String date, int salary) {
		this.empNo = empNo;
		this.name = name;
		this.phoneNo = phoneNo;
		this.date = date;
		this.salary = salary;
		
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
