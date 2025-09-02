package com.otago.practical4backend.controller;

import com.otago.practical4backend.model.Attendant;
import com.otago.practical4backend.service.AttendantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Attendant REST Controller
 * Handles HTTP requests for attendant-related operations
 * Implements RESTful API endpoints for CRUD operations
 */
@RestController
@RequestMapping("/api/attendants")
@CrossOrigin(origins = "*") // Allow cross-origin requests from React frontend
public class AttendantController {

    private final AttendantService attendantService;

    /**
     * Constructor injection for AttendantService
     * @param attendantService Service layer for attendant operations
     */
    @Autowired
    public AttendantController(AttendantService attendantService) {
        this.attendantService = attendantService;
    }

    /**
     * GET endpoint to retrieve all attendants
     * @return List of all attendants with HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Attendant>> getAllAttendants() {
        List<Attendant> attendants = attendantService.getAllAttendants();
        return ResponseEntity.ok(attendants);
    }

    /**
     * GET endpoint to retrieve a specific attendant by ID
     * @param id Attendant ID to retrieve
     * @return Attendant if found (200 OK) or 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Attendant> getAttendantById(@PathVariable Long id) {
        Optional<Attendant> attendant = attendantService.getAttendantById(id);

        if (attendant.isPresent()) {
            return ResponseEntity.ok(attendant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * POST endpoint to create a new attendant
     * @param attendant Attendant object from request body
     * @return Created attendant with HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<?> createAttendant(@RequestBody Attendant attendant) {
        try {
            Attendant createdAttendant = attendantService.createAttendant(attendant);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAttendant);
        } catch (IllegalArgumentException e) {
            // Return validation errors with 400 Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * PUT endpoint to update an existing attendant
     * @param id Attendant ID to update
     * @param attendantDetails Updated attendant details from request body
     * @return Updated attendant (200 OK) or 404 Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAttendant(@PathVariable Long id, @RequestBody Attendant attendantDetails) {
        try {
            Attendant updatedAttendant = attendantService.updateAttendant(id, attendantDetails);

            if (updatedAttendant != null) {
                return ResponseEntity.ok(updatedAttendant);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            // Return validation errors with 400 Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * DELETE endpoint to remove an attendant
     * @param id Attendant ID to delete
     * @return 204 No Content if deleted, 404 Not Found if not exists
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendant(@PathVariable Long id) {
        boolean deleted = attendantService.deleteAttendant(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET endpoint to find attendant by email
     * @param email Email address to search
     * @return Attendant if found or 404 Not Found
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<Attendant> getAttendantByEmail(@PathVariable String email) {
        Optional<Attendant> attendant = attendantService.getAttendantByEmail(email);

        if (attendant.isPresent()) {
            return ResponseEntity.ok(attendant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET endpoint to search attendants by name
     * @param keyword Search keyword
     * @return List of matching attendants
     */
    @GetMapping("/search")
    public ResponseEntity<List<Attendant>> searchAttendants(@RequestParam String keyword) {
        List<Attendant> attendants = attendantService.searchAttendantsByName(keyword);
        return ResponseEntity.ok(attendants);
    }
}