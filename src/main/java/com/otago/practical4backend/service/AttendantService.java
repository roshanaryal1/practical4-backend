package com.otago.practical4backend.service;

import com.otago.practical4backend.model.Attendant;
import com.otago.practical4backend.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Attendant Service Class
 * Contains business logic for attendant operations
 * Implements service layer pattern to separate business logic from controllers
 */
@Service
@Transactional
public class AttendantService {

    private final AttendantRepository attendantRepository;

    // Email validation pattern
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    /**
     * Constructor injection for AttendantRepository
     * @param attendantRepository Repository for attendant data access
     */
    @Autowired
    public AttendantService(AttendantRepository attendantRepository) {
        this.attendantRepository = attendantRepository;
    }

    /**
     * Get all attendants from the database
     * @return List of all attendants
     */
    public List<Attendant> getAllAttendants() {
        return attendantRepository.findAll();
    }

    /**
     * Get a specific attendant by ID
     * @param id Attendant ID to search for
     * @return Optional containing attendant if found
     */
    public Optional<Attendant> getAttendantById(Long id) {
        return attendantRepository.findById(id);
    }

    /**
     * Create a new attendant
     * @param attendant Attendant object to save
     * @return Saved attendant with generated ID
     */
    public Attendant createAttendant(Attendant attendant) {
        // Validate attendant data before saving
        validateAttendant(attendant);

        // Check for duplicate email
        if (attendant.getEmail() != null && !attendant.getEmail().isEmpty()) {
            if (attendantRepository.existsByEmail(attendant.getEmail())) {
                throw new IllegalArgumentException("Email already exists");
            }
        }

        // Check for duplicate mobile
        if (attendant.getMobile() != null && !attendant.getMobile().isEmpty()) {
            if (attendantRepository.existsByMobile(attendant.getMobile())) {
                throw new IllegalArgumentException("Mobile number already exists");
            }
        }

        return attendantRepository.save(attendant);
    }

    /**
     * Update an existing attendant
     * @param id Attendant ID to update
     * @param attendantDetails Updated attendant details
     * @return Updated attendant or null if not found
     */
    public Attendant updateAttendant(Long id, Attendant attendantDetails) {
        Optional<Attendant> optionalAttendant = attendantRepository.findById(id);

        if (optionalAttendant.isPresent()) {
            Attendant attendant = optionalAttendant.get();

            // Check for duplicate email (excluding current attendant)
            if (attendantDetails.getEmail() != null &&
                    !attendantDetails.getEmail().equals(attendant.getEmail())) {
                if (attendantRepository.existsByEmail(attendantDetails.getEmail())) {
                    throw new IllegalArgumentException("Email already exists");
                }
            }

            // Check for duplicate mobile (excluding current attendant)
            if (attendantDetails.getMobile() != null &&
                    !attendantDetails.getMobile().equals(attendant.getMobile())) {
                if (attendantRepository.existsByMobile(attendantDetails.getMobile())) {
                    throw new IllegalArgumentException("Mobile number already exists");
                }
            }

            // Update attendant fields
            attendant.setName(attendantDetails.getName());
            attendant.setAddress(attendantDetails.getAddress());
            attendant.setMobile(attendantDetails.getMobile());
            attendant.setEmail(attendantDetails.getEmail());
            attendant.setComments(attendantDetails.getComments());

            // Validate before saving
            validateAttendant(attendant);

            return attendantRepository.save(attendant);
        }

        return null;
    }

    /**
     * Delete an attendant by ID
     * @param id Attendant ID to delete
     * @return true if deleted successfully, false if not found
     */
    public boolean deleteAttendant(Long id) {
        if (attendantRepository.existsById(id)) {
            attendantRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Find attendant by email
     * @param email Email to search for
     * @return Optional containing attendant if found
     */
    public Optional<Attendant> getAttendantByEmail(String email) {
        return attendantRepository.findByEmail(email);
    }

    /**
     * Search attendants by name
     * @param keyword Keyword to search in attendant names
     * @return List of matching attendants
     */
    public List<Attendant> searchAttendantsByName(String keyword) {
        return attendantRepository.findByNameContainingIgnoreCase(keyword);
    }

    /**
     * Validate attendant data
     * @param attendant Attendant to validate
     * @throws IllegalArgumentException if validation fails
     */
    private void validateAttendant(Attendant attendant) {
        if (attendant.getName() == null || attendant.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Attendant name is required");
        }

        // Validate email format if provided
        if (attendant.getEmail() != null && !attendant.getEmail().isEmpty()) {
            if (!EMAIL_PATTERN.matcher(attendant.getEmail()).matches()) {
                throw new IllegalArgumentException("Invalid email format");
            }
        }

        // Validate mobile number if provided (basic validation)
        if (attendant.getMobile() != null && !attendant.getMobile().isEmpty()) {
            // Remove spaces and hyphens for validation
            String cleanMobile = attendant.getMobile().replaceAll("[\\s-]", "");
            if (!cleanMobile.matches("^[0-9+]{7,15}$")) {
                throw new IllegalArgumentException("Invalid mobile number format");
            }
        }
    }
}