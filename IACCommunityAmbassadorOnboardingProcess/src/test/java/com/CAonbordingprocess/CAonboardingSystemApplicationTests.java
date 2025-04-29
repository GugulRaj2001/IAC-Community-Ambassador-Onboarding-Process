package com.CAonbordingprocess;

import static org.junit.jupiter.api.Assertions.assertEquals;		
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.CAonboardingprocess.Model.CommunityAmbassador;
import com.CAonboardingprocess.Repository.CommunityAmbassadorRepository;
import com.CAonboardingprocess.Service.CommunityAmbassadorService;


// Marks this class as a Spring Boot test
@SpringBootTest
public class CAonboardingSystemApplicationTests {

	// Injects the service to be tested
    @Autowired
    private CommunityAmbassadorService service;

    // Injects the repository to clean up after testing
    @Autowired
    private CommunityAmbassadorRepository repository;

    // Test method to verify the registerCA() logic
    @Test
    public void testRegisterCA() {
        String name = "Test CA";
        String email = "test_" + System.currentTimeMillis() + "@example.com";
        String address = "Test Address";
        String college = "Test College";
        String phone = "9876543210";

        CommunityAmbassador ca = service.registerCA(name, email, address, college, phone);

        assertNotNull(ca.getId());
        assertEquals(name, ca.getName());
        assertEquals(email, ca.getEmail());
        assertTrue(ca.getUtmLink().contains(email));

        // cleanup after test
        repository.delete(ca);
    }
}


 
