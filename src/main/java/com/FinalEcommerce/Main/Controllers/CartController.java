package com.FinalEcommerce.Main.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FinalEcommerce.Main.Entities.Cart;
import com.FinalEcommerce.Main.Entities.Product;
import com.FinalEcommerce.Main.Entities.User;
import com.FinalEcommerce.Main.Services.CartService;
import com.FinalEcommerce.Main.Services.ProductService;
import com.FinalEcommerce.Main.Services.userService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService obj;
	@Autowired
	userService userService;
	@Autowired
	ProductService productService;
	
	@PostMapping("/addCart")
	public ResponseEntity<Cart> addcart(@Valid @RequestBody Cart cart) {
		
		User user = userService.getUserById(cart.getUser().getUserId());
		cart.setUser(user);
		
		Product product = productService.getProductById(cart.getProduct().getId());
		cart.setProduct(product);
		
		return ResponseEntity.ok(obj.addCart(cart));
	}
	
	@GetMapping("/getCartById/{cartId}")
	public ResponseEntity<Cart> getcartById(@PathVariable(name="cartId") int cartId) {
		return ResponseEntity.ok(obj.getCartById(cartId));
	}
	
	@GetMapping("/getAllCarts")
	public ResponseEntity<List<Cart>> getAllcarts() {
		return ResponseEntity.ok(obj.getAllCarts());
	}
	
	@GetMapping("/getCartByUserId/{userId}")
	public ResponseEntity<List<Cart>> getCartByUserId(@PathVariable(name="userId") int userId) {
		return ResponseEntity.ok(obj.getCartByUserId(userId));
	}
	
	@DeleteMapping("/deleteCartById/{cartId}")
	public void deletecartById(@PathVariable(name="cartId") int cartId) {
		obj.deleteCartById(cartId);
	}
	
	@DeleteMapping("/deleteCartByProductId/{productId}")
	public void deleteCartByProductId(@PathVariable(name="productId") int productId) {
		obj.deleteCartByProductId(productId);
	}

//	@DeleteMapping("/deleteCartByProductId/{productId}")
//	public void deleteCartByProductId(@PathVariable(name="productId") int productId) {
//		obj.deleteCartByProductId(productId);
//	}
}
