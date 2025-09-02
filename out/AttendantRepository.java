package com.otago.practical4backend.repository;

import com.otago.practical4backend.model.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Attendant Repository Interface
 * Extends JpaRepository to provide CRUD operations for Attendant entity
 * Spring Data JPA will automatically provide implementation at runtime
 */
@Repository
public interface AttendantRepository extends JpaRepository<Attendant, Long> {

    /**
     * Find attendant by email address
     * @param email Email address to search for
     * @return Optional containing attendant if found
     */
    Optional<Attendant> findByEmail(String email);

    /**
     * Find attendants by name containing a keyword (case-insensitive)
     * @param keyword Keyword to search in attendant names
     * @return List of attendants with names containing the keyword
     */
    List<Attendant> findByNameContainingIgnoreCase(String keyword);

    /**
     * Find attendant by mobile number
     * @param mobile Mobile number to search for
     * @return Optional containing attendant if found
     */
    Optional<Attendant> findByMobile(String mobile);

    /**
     * Check if an attendant exists by email
     * @param email Email to check
     * @return true if attendant exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Check if an attendant exists by mobile
     * @param mobile Mobile number to check
     * @return true if attendant exists, false otherwise
     */
    boolean existsByMobile(String mobile);
}