package com.FinalEcommerce.Main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalEcommerce.Main.Entities.Cart;
import com.FinalEcommerce.Main.Repositories.CartRepo;

import jakarta.transaction.Transactional;

@Service
public class CartService {
	@Autowired
	CartRepo obj;
	
	public Cart addCart(Cart cart) {
		return obj.save(cart);
	}
	public Cart getCartById(int cartId) {
		return obj.findById(cartId).orElse(null);
	}
	public List<Cart> getAllCarts() {
		return obj.findAll();
	}
	
	public List<Cart> getCartByUserId(int userId) {
		return obj.getCartByUserId(userId);
	}
	
	public void deleteCartById(int cartId) {
		obj.deleteById(cartId);;
	}
	
	@Transactional
	public void deleteCartByProductId(int productId) {
		obj.deleteCartByProductId(productId);
	}
}
