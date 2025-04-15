package com.FinalEcommerce.Main.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FinalEcommerce.Main.Entities.OrderEntity;
import com.FinalEcommerce.Main.Entities.Product;
import com.FinalEcommerce.Main.Entities.User;
import com.FinalEcommerce.Main.Services.CartService;
import com.FinalEcommerce.Main.Services.OrderService;
import com.FinalEcommerce.Main.Services.ProductService;
import com.FinalEcommerce.Main.Services.userService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService obj;
	
	@Autowired
	userService userService;
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderEntity> addOrder(@Valid @RequestBody OrderEntity order) {
		
		User user = userService.getUserById(order.getUser().getUserId());
		order.setUser(user);
		
		Product product = productService.getProductById(order.getProduct().getId());
		order.setProduct(product);
		
		System.out.println(order.getOrder_id());
		System.out.println(order.getDelivery_status());
		System.out.println(order.getDeliveryAddress());
		System.out.println(order.getOrder_date());
		System.out.println(order.getQuantity());
		System.out.println(order.getTotal_amt());
		System.out.println(order.getProduct().getId());
		System.out.println(order.getUser().getUserId());
		
		return ResponseEntity.ok(obj.addOrder(order));
	}
	
	@GetMapping("/getOrderById/{orderId}")
	public ResponseEntity<OrderEntity> getOrderById(@PathVariable(name="orderId") int orderId) {
		return ResponseEntity.ok(obj.getOrderById(orderId));
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderEntity>> getAllOrders() {
		return ResponseEntity.ok(obj.getAllOrders());
	}
	
	@GetMapping("/getOrdersByUserId/{userId}")
	public ResponseEntity<List<OrderEntity>> getOrdersByUserId(@PathVariable(name = "userId") int userId) {
		return ResponseEntity.ok(obj.getOrdersByUserId(userId));
	}
	
	@GetMapping("/getOrdersBySellerId/{sellerId}")
	public ResponseEntity<List<OrderEntity>> getOrdersBySellerId(@PathVariable(name = "sellerId") int sellerId) {
		return ResponseEntity.ok(obj.getOrdersBySellerId(sellerId));
	}
	
	@DeleteMapping("/deleteOrderById/{orderId}")
	public void deleteOrderById(@PathVariable(name="orderId") int orderId) {
		obj.deleteOrderById(orderId);
	}
	
	@DeleteMapping("/deleteOrderByProductId/{productId}")
	public void deleteOrderByProductId(@PathVariable(name="productId") int productId) {
		obj.deleteOrderByProductId(productId);
	}
	
	@PutMapping("/updateDeliveryStatusOfOrder")
	public ResponseEntity<OrderEntity> updateOrderDeliveryStatus(@RequestBody OrderEntity newOrder) {
		OrderEntity oldOrder = obj.getOrderById(newOrder.getOrder_id());
		
		oldOrder.setDelivery_status(newOrder.getDelivery_status());
		return ResponseEntity.ok(obj.updateOrderDeliveryStatus(newOrder));
	}
}
