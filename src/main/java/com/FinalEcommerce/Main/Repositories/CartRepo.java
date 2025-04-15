package com.FinalEcommerce.Main.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FinalEcommerce.Main.Entities.Cart;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	@Query("SELECT c FROM Cart c WHERE c.user.userId = :userId")
	public List<Cart> getCartByUserId(@Param("userId") int userId);
	
	@Modifying
	@Query("DELETE FROM Cart c WHERE c.product.id = :productId")
	public void deleteCartByProductId(@Param("productId") int productId);
}
