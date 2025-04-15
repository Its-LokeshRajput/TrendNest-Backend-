package com.FinalEcommerce.Main.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
//import lombok.Getter;
//import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
//@Getter
//@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull
	private String userName;
	
//	@NotNull
	@Email
	private String email;
	
	@Size(min=8)
	private String password;
	
	@NotNull
	private String address;
	
	@Size(min=10,max=10)
	private String mobileNumber;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<OrderEntity> orders;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Cart> carts;
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
