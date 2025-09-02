package com.otago.practical4backend.model;

import jakarta.persistence.*;

/**
 * Attendant Entity Class
 * Represents an attendant/staff member in the system
 * Maps to the 'attendants' table in the database
 */
@Entity
@Table(name = "attendants")
public class Attendant {

    /**
     * Primary key - auto-generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Attendant's full name - required field
     */
    @Column(nullable = false)
    private String name;

    /**
     * Attendant's address
     */
    @Column(length = 255)
    private String address;

    /**
     * Attendant's mobile number
     */
    @Column(length = 20)
    private String mobile;

    /**
     * Attendant's email address
     */
    @Column(length = 100)
    private String email;

    /**
     * Additional comments or notes about the attendant
     */
    @Column(length = 500)
    private String comments;

    // Default constructor required by JPA
    public Attendant() {
    }

    // Constructor with all fields except ID
    public Attendant(String name, String address, String mobile, String email, String comments) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.comments = comments;
    }

    // Getters and Setters with documentation

    /**
     * Get the attendant ID
     * @return Attendant ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the attendant ID
     * @param id Attendant ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the attendant name
     * @return Attendant name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the attendant name
     * @param name Attendant name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the attendant address
     * @return Attendant address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the attendant address
     * @param address Attendant address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the attendant mobile number
     * @return Attendant mobile number
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set the attendant mobile number
     * @param mobile Attendant mobile number to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Get the attendant email
     * @return Attendant email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the attendant email
     * @param email Attendant email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the comments about the attendant
     * @return Comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Set the comments about the attendant
     * @param comments Comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * String representation of the Attendant object
     * @return String containing all attendant details
     */
    @Override
    public String toString() {
        return "Attendant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}