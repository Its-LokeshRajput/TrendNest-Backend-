package com.FinalEcommerce.Main.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sellerId;
	
	@NotNull
	private String sellerName;
	
	@Size(min=10)
	private String sellerAddress;
	
	@NotNull
	private String storeName;
	
	@Size(min=50, max = 300)
	private String storeDesc;
	
	@Size(min=8)
	private String password;
	
	@Size(min=10,max=10)
	private String sellerMobNumber;
	
	@Size(min=15)
	private String gstinNumber;
	
	@OneToMany(mappedBy="seller", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	List<Product> products;
	
//	public List<Product> getProducts() {
//		return products;
//	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	public String getSellerMobNumber() {
		return sellerMobNumber;
	}
	public void setSellerMobNumber(String sellerMobNumber) {
		this.sellerMobNumber = sellerMobNumber;
	}
	public String getGstinNumber() {
		return gstinNumber;
	}
	public void setGstinNumber(String gstinNumber) {
		this.gstinNumber = gstinNumber;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreDesc() {
		return storeDesc;
	}
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}