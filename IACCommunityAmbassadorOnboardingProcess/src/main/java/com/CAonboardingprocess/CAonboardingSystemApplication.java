package com.CAonboardingprocess;

import org.springframework.beans.factory.annotation.Autowired;			
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.CAonboardingprocess.Service.CommunityAmbassadorService;
import com.CAonboardingprocess.Util.EmailService;

                     //  # Main class (Spring Boot starter)

// Marks this as a Spring Boot application with auto-configuration, component scanning
@SpringBootApplication

// Enables JPA repositories in the specified package
@EnableJpaRepositories(basePackages = "com.CAonboardingprocess.Repository")

// Tells Spring where to scan for @Entity classes
@EntityScan(basePackages = "com.CAonboardingprocess.Model")
public class CAonboardingSystemApplication implements CommandLineRunner {

	 //  Injects EmailService to send test email
    @Autowired
    private EmailService emailService;

    //  Injects CA service to register sample data
    @Autowired
    private CommunityAmbassadorService caService;

 //  Main method: Application starts here
    public static void main(String[] args) {
        SpringApplication.run(CAonboardingSystemApplication.class, args);
    }

 // This method is run after the application starts
    @Override
    public void run(String... args) throws Exception {
    	
        // Sends test email on startup 
        emailService.sendTestEmail();  

        //  Register a sample CA record automatically on app start with all necessary fields
        caService.registerCA(
            "Rajkumar", 
            "rajkumar.gugul1@gmail.com", 
            "123 Sample Address, City, Country",  // Example address
            "JNTU University",  // Example college/university
            "9876543210"  // Example phone number
        );
        
        System.out.println("✅ Sample CA inserted into database.");
    }
}
