package com.otago.practical4backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main Spring Boot Application class
 * Extends SpringBootServletInitializer to support WAR deployment
 *
 * @author Student Name
 * Course: IX608001 Intermediate Application Development Concepts
 */
@SpringBootApplication
public class Practical4BackendApplication extends SpringBootServletInitializer {

    /**
     * Main method to run the Spring Boot application
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Practical4BackendApplication.class, args);
        System.out.println("==============================================");
        System.out.println("Practical 4 Backend Application Started Successfully!");
        System.out.println("API Base URL: http://localhost:8080/practical4-backend/api");
        System.out.println("H2 Console: http://localhost:8080/practical4-backend/h2-console");
        System.out.println("==============================================");
    }

    /**
     * Configure the application for WAR deployment
     * @param application SpringApplicationBuilder
     * @return SpringApplicationBuilder configured for WAR deployment
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Practical4BackendApplication.class);
    }
}