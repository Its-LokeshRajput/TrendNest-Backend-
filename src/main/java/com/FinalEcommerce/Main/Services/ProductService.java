package com.FinalEcommerce.Main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalEcommerce.Main.Entities.Product;
import com.FinalEcommerce.Main.Repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo obj;
	
	public Product addProduct(Product product) {
		System.out.println(product.toString());
		return obj.save(product);
	}
	public Product getProductById(int id) {
		return obj.findById(id).orElse(null);
	}
	
	public List<Product> getAllProducts() {
		return obj.findAll();
	}
	
	public void deleteProductById(int id) {
		obj.deleteById(id);
	}
	
	public List<Product> getProductsBySellerId(int sellerId) {
		return obj.getProductsBySellerId(sellerId);
	}
	
	public List<Product> getProductsByCategory(String category) {
		return obj.getProductsByCategory(category);
	}
	
	public List<Product> getProductsBySubCategory(String subCategory,String suitableFor) {
		return obj.getProductsBySubCategory(subCategory,suitableFor);
	}
	
	public List<Product> getProductsByDistinctCategory(String suitableFor) {
		return obj.getProductsByDistinctCategory(suitableFor);
	}
	
	public Product updateProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return obj.save(newProduct);
	}
}
