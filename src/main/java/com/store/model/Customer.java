package com.store.model;

import java.sql.Date;


public class Customer {
	private int id;
	private String userName;
	private String fullName;
	private String gender;
	private Date dateOfBirth;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private String imgProfile;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImgProfile() {
		return imgProfile;
	}
	public void setImgProfile(String imgProfile) {
		this.imgProfile = imgProfile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Customer(int id, String userName, String fullName, String gender, Date dateOfBirth, String email,
			String password, String phoneNumber, String address, String imgProfile, String role) {
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.imgProfile = imgProfile;
		this.role = role;
	}
	public Customer() {

		super();
	}
	
	
	
}
	
	

	