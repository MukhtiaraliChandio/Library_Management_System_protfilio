package com.pojos;

public class EmployeePojo {

	private int employeeId;
	private String employeeName;
	private String fName;
	private String surname;
	private String cnic;
	private String contactNo;
	private String emailId;
	private String gender;
	private String userName;
	private String password;
	private String remarks;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "EmployeePojo [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", fName=" + fName + ", surname=" + surname
				+ ", cnic=" + cnic + ", contactNo=" + contactNo + ", emailId="
				+ emailId + ", gender=" + gender + ", userName=" + userName
				+ ", password=" + password + ", remarks=" + remarks + "]";
	}
	
	


	
	
	
	
	
	
	
	
}