package com.otago.practical4backend.config;

import com.otago.practical4backend.model.Product;
import com.otago.practical4backend.model.Attendant;
import com.otago.practical4backend.repository.ProductRepository;
import com.otago.practical4backend.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * DataLoader Component
 * Initializes the database with sample data on application startup
 * Implements CommandLineRunner to execute after Spring Boot starts
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final AttendantRepository attendantRepository;

    /**
     * Constructor injection for repositories
     * @param productRepository Product repository
     * @param attendantRepository Attendant repository
     */
    @Autowired
    public DataLoader(ProductRepository productRepository, AttendantRepository attendantRepository) {
        this.productRepository = productRepository;
        this.attendantRepository = attendantRepository;
    }

    /**
     * Run method executed on application startup
     * Loads sample data into the database
     * @param args Command line arguments
     */
    @Override
    public void run(String... args) throws Exception {
        loadSampleProducts();
        loadSampleAttendants();

        System.out.println("==========================================");
        System.out.println("Sample data loaded successfully!");
        System.out.println("Products loaded: " + productRepository.count());
        System.out.println("Attendants loaded: " + attendantRepository.count());
        System.out.println("==========================================");
    }

    /**
     * Load sample products into the database
     * Creates at least 3 sample product records as required
     */
    private void loadSampleProducts() {
        // Check if products already exist to avoid duplicates
        if (productRepository.count() == 0) {
            // Product 1: Electronics
            Product product1 = new Product(
                    "Dell XPS 13 Laptop",
                    new BigDecimal("1299.99"),
                    "Electronics",
                    15,
                    "High-performance ultrabook with 13.3-inch display, Intel Core i7 processor, 16GB RAM, and 512GB SSD. Perfect for professionals and students."
            );
            productRepository.save(product1);

            // Product 2: Appliances
            Product product2 = new Product(
                    "Breville Espresso Machine",
                    new BigDecimal("299.50"),
                    "Appliances",
                    8,
                    "Premium espresso machine with 15-bar pump, milk frother, and adjustable temperature control. Make barista-quality coffee at home."
            );
            productRepository.save(product2);

            // Product 3: Books
            Product product3 = new Product(
                    "Java Programming Guide",
                    new BigDecimal("45.99"),
                    "Books",
                    25,
                    "Comprehensive guide to Java programming covering basics to advanced topics. Includes practical examples and exercises."
            );
            productRepository.save(product3);

            // Product 4: Sports
            Product product4 = new Product(
                    "Wilson Tennis Racket",
                    new BigDecimal("89.99"),
                    "Sports",
                    12,
                    "Professional-grade tennis racket with carbon fiber frame and comfortable grip. Suitable for intermediate to advanced players."
            );
            productRepository.save(product4);

            // Product 5: Furniture
            Product product5 = new Product(
                    "Ergonomic Office Chair",
                    new BigDecimal("349.00"),
                    "Furniture",
                    6,
                    "Adjustable office chair with lumbar support, breathable mesh back, and padded armrests. Promotes good posture during long work hours."
            );
            productRepository.save(product5);

            System.out.println("Sample products loaded successfully!");
        }
    }

    /**
     * Load sample attendants into the database
     * Creates at least 3 sample attendant records as required
     */
    private void loadSampleAttendants() {
        // Check if attendants already exist to avoid duplicates
        if (attendantRepository.count() == 0) {
            // Attendant 1
            Attendant attendant1 = new Attendant(
                    "John Smith",
                    "123 Queen Street, Auckland CBD, Auckland 1010",
                    "+64 21 123 4567",
                    "john.smith@company.co.nz",
                    "Senior attendant with 5 years experience. Specializes in electronics and IT products."
            );
            attendantRepository.save(attendant1);

            // Attendant 2
            Attendant attendant2 = new Attendant(
                    "Sarah Johnson",
                    "456 Ponsonby Road, Ponsonby, Auckland 1011",
                    "+64 22 234 5678",
                    "sarah.johnson@company.co.nz",
                    "Customer service specialist. Fluent in English and Mandarin. Available for morning shifts."
            );
            attendantRepository.save(attendant2);

            // Attendant 3
            Attendant attendant3 = new Attendant(
                    "Michael Brown",
                    "789 K Road, Newton, Auckland 1010",
                    "+64 21 345 6789",
                    "michael.brown@company.co.nz",
                    "Part-time attendant, available weekends. Experience in furniture and home appliances."
            );
            attendantRepository.save(attendant3);

            // Attendant 4
            Attendant attendant4 = new Attendant(
                    "Emma Wilson",
                    "321 Dominion Road, Mount Eden, Auckland 1024",
                    "+64 22 456 7890",
                    "emma.wilson@company.co.nz",
                    "Team leader with excellent organizational skills. Training coordinator for new staff."
            );
            attendantRepository.save(attendant4);

            System.out.println("Sample attendants loaded successfully!");
        }
    }
}