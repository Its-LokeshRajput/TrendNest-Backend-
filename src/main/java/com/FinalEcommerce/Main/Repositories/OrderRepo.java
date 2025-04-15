package com.FinalEcommerce.Main.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FinalEcommerce.Main.Entities.OrderEntity;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer>{

	@Query("SELECT o FROM OrderEntity o WHERE o.user.userId = :userId")
	public List<OrderEntity> getOrdersByUserId(@Param("userId") int userId);
	@Query("SELECT o FROM OrderEntity o WHERE o.product.seller.sellerId = :sellerId")
	public List<OrderEntity> getOrdersBySellerId(@Param("sellerId") int sellerId);
	
	@Modifying
	@Query("DELETE FROM OrderEntity o WHERE o.product.id = :productId")
	public void deleteOrderByProductId(@Param("productId") int productId);
}
