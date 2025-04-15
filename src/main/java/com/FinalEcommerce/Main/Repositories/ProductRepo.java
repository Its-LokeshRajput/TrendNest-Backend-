package com.FinalEcommerce.Main.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FinalEcommerce.Main.Entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.seller.id = :sellerId")
	List<Product> getProductsBySellerId(@Param("sellerId") int sellerId);
	
	@Query("SELECT p FROM Product p WHERE p.suitableFor = :category")
	List<Product> getProductsByCategory(@Param("category") String category);
	
	@Query("SELECT p FROM Product p WHERE p.categoryType = :subCategory AND p.suitableFor = :suitableFor")
	List<Product> getProductsBySubCategory(@Param("subCategory") String subCategory,@Param("suitableFor") String suitableFor);
	
	@Query(value = "SELECT * FROM ( " +
            "SELECT p.*, ROW_NUMBER() OVER (PARTITION BY p.category_type ORDER BY p.id) AS rn " +
            "FROM product p " +
            "WHERE p.suitable_for = :suitableFor " +  
            ") t WHERE rn = 1", 
    nativeQuery = true)
List<Product> getProductsByDistinctCategory(@Param("suitableFor") String suitableFor);

}
