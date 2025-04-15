package com.FinalEcommerce.Main.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String productDescription;
	
	@NotNull
	private double actualPrice;
	
	@NotNull
	private int discout;
	
	@NotNull
	private double sellingPrice;
	
	@NotNull
	private int stockQuantity;
	
	@NotNull
	private String frontImageUrl;
	
	@NotNull
	private String backImageUrl;
	
	@NotNull
	private String categoryType;
	
	@NotNull
	private String imageUrl;
	
	@NotNull
	private String suitableFor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="seller_id", referencedColumnName="sellerId")
	private Seller seller;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderEntity> orders;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<Cart> carts;

	public String getFrontImageUrl() {
		return frontImageUrl;
	}

	public void setFrontImageUrl(String frontImageUrl) {
		this.frontImageUrl = frontImageUrl;
	}

	public String getBackImageUrl() {
		return backImageUrl;
	}

	public void setBackImageUrl(String backImageUrl) {
		this.backImageUrl = backImageUrl;
	}
	
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	
	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSuitableFor() {
		return suitableFor;
	}

	public void setSuitableFor(String suitableFor) {
		this.suitableFor = suitableFor;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productDescription=" + productDescription + ", actualPrice="
				+ actualPrice + ", discout=" + discout + ", sellingPrice=" + sellingPrice + ", stockQuantity="
				+ stockQuantity + ", frontImageUrl=" + frontImageUrl + ", backImageUrl=" + backImageUrl
				+ ", categoryType=" + categoryType + ", imageUrl=" + imageUrl + ", suitableFor=" + suitableFor
				+ ", seller=" + seller + ", orders=" + orders + ", carts=" + carts + "]";
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public int getDiscout() {
		return discout;
	}

	public void setDiscout(int discout) {
		this.discout = discout;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
}
