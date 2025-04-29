package com.CAonboardingprocess.Service;

import java.util.Optional;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CAonboardingprocess.Model.CommunityAmbassador;
import com.CAonboardingprocess.Repository.CommunityAmbassadorRepository;

// Marks this class as a service component managed by Spring
@Service
public class SignupTrackingService {

	// Injects the CommunityAmbassadorRepository to perform DB operations
    @Autowired
    private CommunityAmbassadorRepository repository;

    // Method to update signups counts
    public void updateSignups(String email) {
        Optional<CommunityAmbassador> ca = repository.findByEmail(email);
        if (ca.isPresent()) {
            CommunityAmbassador ambassador = ca.get();
            ambassador.setSignups(ambassador.getSignups() + 1); // Increment the signup count
            repository.save(ambassador);   // Save the updated CA record
        }
    }
}