package com.otago.practical4backend.repository;

import com.otago.practical4backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Product Repository Interface
 * Extends JpaRepository to provide CRUD operations for Product entity
 * Spring Data JPA will automatically provide implementation at runtime
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find products by category
     * @param category Category name to search for
     * @return List of products in the specified category
     */
    List<Product> findByCategory(String category);

    /**
     * Find products by name containing a keyword (case-insensitive)
     * @param keyword Keyword to search in product names
     * @return List of products with names containing the keyword
     */
    List<Product> findByNameContainingIgnoreCase(String keyword);

    /**
     * Find products with stock less than specified amount
     * Useful for identifying products that need restocking
     * @param stockLevel Stock level threshold
     * @return List of products with stock below the threshold
     */
    List<Product> findByStockLessThan(Integer stockLevel);

    /**
     * Check if a product exists by name
     * @param name Product name to check
     * @return true if product exists, false otherwise
     */
    boolean existsByName(String name);
}