package com.otago.practical4backend.service;

import com.otago.practical4backend.model.Product;
import com.otago.practical4backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Product Service Class
 * Contains business logic for product operations
 * Implements service layer pattern to separate business logic from controllers
 */
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructor injection for ProductRepository
     * @param productRepository Repository for product data access
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Get all products from the database
     * @return List of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get a specific product by ID
     * @param id Product ID to search for
     * @return Optional containing product if found
     */
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Create a new product
     * @param product Product object to save
     * @return Saved product with generated ID
     */
    public Product createProduct(Product product) {
        // Validate product data before saving
        validateProduct(product);
        return productRepository.save(product);
    }

    /**
     * Update an existing product
     * @param id Product ID to update
     * @param productDetails Updated product details
     * @return Updated product or null if not found
     */
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            // Update product fields
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setCategory(productDetails.getCategory());
            product.setStock(productDetails.getStock());
            product.setDescription(productDetails.getDescription());

            // Validate before saving
            validateProduct(product);

            return productRepository.save(product);
        }

        return null;
    }

    /**
     * Delete a product by ID
     * @param id Product ID to delete
     * @return true if deleted successfully, false if not found
     */
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Find products by category
     * @param category Category to search for
     * @return List of products in the category
     */
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    /**
     * Search products by name
     * @param keyword Keyword to search in product names
     * @return List of matching products
     */
    public List<Product> searchProductsByName(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    /**
     * Get products with low stock
     * @param threshold Stock level threshold
     * @return List of products with stock below threshold
     */
    public List<Product> getLowStockProducts(Integer threshold) {
        return productRepository.findByStockLessThan(threshold);
    }

    /**
     * Validate product data
     * @param product Product to validate
     * @throws IllegalArgumentException if validation fails
     */
    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required");
        }
        if (product.getPrice() == null || product.getPrice().doubleValue() < 0) {
            throw new IllegalArgumentException("Product price must be non-negative");
        }
        if (product.getStock() == null || product.getStock() < 0) {
            throw new IllegalArgumentException("Product stock must be non-negative");
        }
        if (product.getCategory() == null || product.getCategory().trim().isEmpty()) {
            throw new IllegalArgumentException("Product category is required");
        }
    }
}