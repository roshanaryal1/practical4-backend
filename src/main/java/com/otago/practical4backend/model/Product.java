package com.otago.practical4backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Product Entity Class
 * Represents a product in the inventory system
 * Maps to the 'products' table in the database
 */
@Entity
@Table(name = "products")
public class Product {

    /**
     * Primary key - auto-generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Product name - required field
     */
    @Column(nullable = false)
    private String name;

    /**
     * Product price - stored as BigDecimal for precision
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Product category for classification
     */
    @Column(nullable = false)
    private String category;

    /**
     * Current stock quantity
     */
    @Column(nullable = false)
    private Integer stock;

    /**
     * Detailed product description
     */
    @Column(length = 500)
    private String description;

    // Default constructor required by JPA
    public Product() {
    }

    // Constructor with all fields except ID
    public Product(String name, BigDecimal price, String category, Integer stock, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.description = description;
    }

    // Getters and Setters with documentation

    /**
     * Get the product ID
     * @return Product ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the product ID
     * @param id Product ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the product name
     * @return Product name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the product name
     * @param name Product name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the product price
     * @return Product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Set the product price
     * @param price Product price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Get the product category
     * @return Product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the product category
     * @param category Product category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get the stock quantity
     * @return Stock quantity
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Set the stock quantity
     * @param stock Stock quantity to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Get the product description
     * @return Product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the product description
     * @param description Product description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * String representation of the Product object
     * @return String containing all product details
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                '}';
    }
}