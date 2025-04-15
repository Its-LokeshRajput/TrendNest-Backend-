package com.FinalEcommerce.Main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.FinalEcommerce.Main.Entities.OrderEntity;
import com.FinalEcommerce.Main.Repositories.OrderRepo;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	@Autowired
	OrderRepo obj;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	public OrderEntity addOrder(OrderEntity order) {
		return obj.save(order);
	}
	public OrderEntity getOrderById(int orderId) {
		return obj.findById(orderId).orElse(null);
	}
	public List<OrderEntity> getAllOrders() {
		return obj.findAll();
	}
	public void deleteOrderById(int orderId) {
		obj.deleteById(orderId);;
	}
	public List<OrderEntity> getOrdersByUserId(int userId) {
		return obj.getOrdersByUserId(userId);
	}
	
	public List<OrderEntity> getOrdersBySellerId(int sellerId) {
		return obj.getOrdersBySellerId(sellerId);
	}
	
	@Transactional
	public void deleteOrderByProductId(int productId) {
		obj.deleteOrderByProductId(productId);
		cartService.deleteCartByProductId(productId);
		productService.deleteProductById(productId);
	}
	
	public OrderEntity updateOrderDeliveryStatus(OrderEntity newOrder) {
		return obj.save(newOrder);
	}
}
