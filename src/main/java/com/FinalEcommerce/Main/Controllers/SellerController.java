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
import com.FinalEcommerce.Main.Entities.Seller;
import com.FinalEcommerce.Main.Entities.User;
import com.FinalEcommerce.Main.Services.SellerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	SellerService obj;
	
	@PostMapping("/addSeller")
	public ResponseEntity<Seller> addSeller(@Valid @RequestBody Seller seller) {
		return ResponseEntity.ok(obj.addSeller(seller));
	}
	
	@GetMapping("/getSellerById/{sellerId}")
	public ResponseEntity<Seller> getSellerById(@PathVariable(name="sellerId") int sellerId) {
		return ResponseEntity.ok(obj.getSellerById(sellerId));
	}
	
	@GetMapping("/getAllSellers")
	public ResponseEntity<List<Seller>> getAllSellers() {
		return ResponseEntity.ok(obj.getAllSellers());
	}
	
	@DeleteMapping("/deleteSellerById/{sellerId}")
	public void deleteSellerById(@PathVariable(name = "sellerId") int sellerId) {
		 obj.deleteSellerById(sellerId);
	}
	
	@GetMapping("/{sellerName}/{password}")
	public ResponseEntity<Seller> signInSeller(@PathVariable(name = "sellerName") String sellerName, @PathVariable(name = "password") String password) {
		return ResponseEntity.ok(obj.signInSeller(sellerName,password));
	}
	
	@PutMapping("/updateSeller")
	public ResponseEntity<Seller> updateSeller(@RequestBody Seller newSeller) {
		return ResponseEntity.ok(obj.updateSeller(newSeller));
	}
}
