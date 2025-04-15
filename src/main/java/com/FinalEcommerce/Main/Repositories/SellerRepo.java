package com.FinalEcommerce.Main.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FinalEcommerce.Main.Entities.Seller;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Integer> {
//	@Query("SELECT s FROM Seller s JOIN s.products p WHERE p.id = :productId")
//	public Seller getSellerByProductId(int productId);
}
