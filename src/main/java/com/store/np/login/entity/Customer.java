package com.store.np.login.entity;

import java.util.Date;

public class Customer {
	private int id;
	private String fullname;
	private String gender;
	private Date date_of_birth;
	private String user_name;
	private String email;
	private String password;
	private String phone_number;
	private String address;
	private String img_profile;
	private String role;
	
	public Customer(int id, String fullname, String gender, Date date_of_birth, String user_name, String email,
			String password, String phone_number, String address, String img_profile, String role) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.address = address;
		this.img_profile = img_profile;
		this.role = role;
	}
	
	
	/*_________________________________________________________________________________________________
	 * NOTE: Entity không được chứa setter, chỉ được dùng constructor.
	 *       Trong việc add 1 cái gì đó, có thể khởi tạo đối tượng để add vô DB thông qua constructor
	 *       
	 *       ==> Đây là nguyên tắc, tránh việc hư hỏng dữ liệu 
	 *_________________________________________________________________________________________________
	 */
	public int getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getGender() {
		return gender;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public String getAddress() {
		return address;
	}

	public String getImg_profile() {
		return img_profile;
	}

	public String getRole() {
		return role;
	}
	
}
