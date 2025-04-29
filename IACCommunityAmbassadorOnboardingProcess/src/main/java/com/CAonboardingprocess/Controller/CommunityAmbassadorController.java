package com.CAonboardingprocess.Controller;

import java.io.IOException;	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CAonboardingprocess.Model.CommunityAmbassador;
import com.CAonboardingprocess.Service.CommunityAmbassadorService;
import jakarta.servlet.http.HttpServletResponse;


// This controller handles REST API requests related to Community Ambassadors,
// such as registration, performance tracking, and signup updates.

// Marks this class as a REST controller that returns JSON responses
@RestController

// Base path for all end points in this controller
@RequestMapping("/api/cas")
public class CommunityAmbassadorController {

    @Autowired
    private CommunityAmbassadorService caService;

    // Register a new Community Ambassador
    @PostMapping("/register")
    public ResponseEntity<CommunityAmbassador> register(@RequestBody CommunityAmbassador ca) {
        try {
            CommunityAmbassador savedCA = caService.registerCA(
                    ca.getName(),
                    ca.getEmail(),
                    ca.getAddress(),
                    ca.getCollegeOrUniversity(),
                    ca.getPhone()
            );
            return ResponseEntity.ok(savedCA);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Track sign-up count by POSTing email
    @PostMapping("/update-signup")
    public ResponseEntity<String> updateSignup(@RequestBody String email) {
        try {
            caService.updateSignups(email);
            return ResponseEntity.ok("Signup count updated successfully for: " + email);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("CA not found with email: " + email);
        }
    }

    // Get all Community Ambassadors
    @GetMapping("/performance")
    public List<CommunityAmbassador> getAllCAsPerformance() {
        return caService.getAllCAsPerformance();
    }

    // Get single CA by ID
    @GetMapping("/{id}")
    public ResponseEntity<CommunityAmbassador> getCA(@PathVariable Long id) {
        return ResponseEntity.of(caService.getCAById(id));
    }

    //OLD METHOD: Redirect via email in URL path (still kept if needed)
    @GetMapping("/redirect/{email:.+}")
    public void trackAndRedirect(@PathVariable("email") String email, HttpServletResponse response) throws IOException {
        try {
            caService.updateSignups(email);
            response.sendRedirect("https://www.industryacademiacommunity.com/");
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Community Ambassador not found for email: " + email);
        }
    }

    // NEW METHOD: Track UTM via query parameter (?utm_source=email)
    @GetMapping("/track-signup")
    public void trackSignupByQueryParam(@RequestParam("utm_source") String email, HttpServletResponse response) throws IOException {
        try {
            caService.updateSignups(email);
            response.sendRedirect("https://www.industryacademiacommunity.com/");
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "CA not found for email: " + email);
        }
    }
}
