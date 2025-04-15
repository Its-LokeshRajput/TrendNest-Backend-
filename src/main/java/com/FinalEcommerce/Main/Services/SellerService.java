package com.FinalEcommerce.Main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalEcommerce.Main.Entities.Seller;
import com.FinalEcommerce.Main.Entities.User;
import com.FinalEcommerce.Main.Repositories.SellerRepo;

@Service
public class SellerService {
	@Autowired
	SellerRepo obj; 
	
	public Seller addSeller(Seller seller) {
		return obj.save(seller);
	}
	
//	public Seller getSellerByProductId(int productId) {
//		return obj.getSellerByProductId(productId);
//	}
	
	public Seller getSellerById(int sellerId) {
		return obj.findById(sellerId).orElse(null);
	}
	
	public List<Seller> getAllSellers() {
		return obj.findAll();
	}
	
	public void deleteSellerById(int sellerId) {
		obj.deleteById(sellerId);
	}
	
	public Seller updateSeller(Seller newSeller) {
		return obj.save(newSeller);
	}
	
	public Seller signInSeller(String sellerName, String password) {
	    List<Seller> sellers = getAllSellers(); 

	    if (sellers == null || sellers.isEmpty()) {
	        System.out.println("Seller list is null or empty!");
	        return null;
	    }

	    System.out.println("Sellers in the database:");
	    for (Seller seller : sellers) {
	        System.out.println("Username: [" + seller.getSellerName() + "], Password: [" + seller.getPassword() + "]");
	    }

	    for (Seller seller : sellers) {
	        if (seller.getSellerName().trim().equals(sellerName.trim()) &&
	            seller.getPassword().trim().equals(password.trim())) {
	            System.out.println("Seller found: " + seller);
	            return seller;
	        }
	    }

	    System.out.println("No matching Seller found!");
	    return null;
	}
}
