package ics.course.java;

public class Employee {
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String address;
	private String phone;
	
	public Employee(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
}