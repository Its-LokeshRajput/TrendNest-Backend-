package com.FinalEcommerce.Main.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.FinalEcommerce.Main.Entities.Seller;
import com.FinalEcommerce.Main.Services.OrderService;
import com.FinalEcommerce.Main.Services.ProductService;
import com.FinalEcommerce.Main.Services.SellerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService obj;
	
	@Autowired
	SellerService sellerService;
	
	
//	@GetMapping("/getSellerByProductId/{productId}")
//	public Seller getSellerByProductId(@PathVariable(name="productId") int productId) {
//		return sellerService.getSellerByProductId(productId);
//	}

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		
		Seller seller = sellerService.getSellerById(product.getSeller().getSellerId());
		product.setSeller(seller);
		
		return ResponseEntity.ok(obj.addProduct(product));
	}
	
	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "productId") int productId) {
		return ResponseEntity.ok(obj.getProductById(productId));
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(obj.getAllProducts());
	}
	
	@GetMapping("/getAllProductBySellerId/{sellerId}")
	public ResponseEntity<List<Product>> getProductBySellerId(@PathVariable(name = "sellerId") int sellerId) {
		return ResponseEntity.ok(obj.getProductsBySellerId(sellerId));
	}
	
	@GetMapping("/getAllProductByCategroy/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable(name = "category") String category) {
		return ResponseEntity.ok(obj.getProductsByCategory(category));
	}
	
	@GetMapping("/getAllProductBySubCategroy/{subCategory}/{suitableFor}")
	public ResponseEntity<List<Product>> getProductsBySubCategory(@PathVariable(name = "subCategory") String subCategory,@PathVariable(name = "suitableFor") String suitableFor) {
		return ResponseEntity.ok(obj.getProductsBySubCategory(subCategory, suitableFor));
	}
	
	@GetMapping("/getProductsByDistinctCategory/{suitableFor}")
	public ResponseEntity<List<Product>> getProductsByDistinctCategory(@PathVariable(name="suitableFor") String suitableFor) {
		return ResponseEntity.ok(obj.getProductsByDistinctCategory(suitableFor));
	}
	
	@DeleteMapping("/deleteProductById/{productId}")
	public void deleteProductById(@PathVariable(name="productId") int productId) {
		obj.deleteProductById(productId);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product newProduct) {
		return ResponseEntity.ok(obj.updateProduct(newProduct));
	}
}
