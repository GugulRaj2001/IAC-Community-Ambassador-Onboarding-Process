package com.CAonboardingprocess.Service;

import java.util.List;	
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.CAonboardingprocess.Model.CommunityAmbassador;
import com.CAonboardingprocess.Repository.CommunityAmbassadorRepository;


// Marks this class as a service component in Spring's context
@Service
public class CommunityAmbassadorService {

    @Autowired
    private CommunityAmbassadorRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    // Email format validation using regex
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");

    // Registers a new Community Ambassador after validation
    public CommunityAmbassador registerCA(String name, String email, String address, String college, String phoneNumber) {

        // Validate email format
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }

        // Check for duplicate (Check if email already exists)
        Optional<CommunityAmbassador> existing = repository.findByEmail(email);
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Email already registered: " + email);
        }

        // Create new CA record
        CommunityAmbassador ca = new CommunityAmbassador();
        ca.setName(name);
        ca.setEmail(email);
        ca.setUtmLink(generateUTMLink(email));  // UTM link generation
        ca.setSignups(0);
        ca.setAddress(address);
        ca.setCollegeOrUniversity(college);
        ca.setPhone(phoneNumber);

        // Save to database
        repository.save(ca);

        // Send welcome mail with UTM link
        sendWelcomeEmail(email, ca.getUtmLink());

        return ca;
    }

    // (increment) Updates sign up count for a CA
    public void updateSignups(String email) {
        Optional<CommunityAmbassador> caOpt = repository.findByEmail(email);
        if (caOpt.isPresent()) {
            CommunityAmbassador ca = caOpt.get();
            ca.setSignups(ca.getSignups() + 1);
            repository.save(ca);
        } else {
            throw new IllegalArgumentException("CA not found with email: " + email);
        }
    }

     // Returns list of all CAs (for performance dash board)
    public List<CommunityAmbassador> getAllCAsPerformance() {
        return repository.findAll();
    }

    // Gets a specific CA by ID
    public Optional<CommunityAmbassador> getCAById(Long id) {
        return repository.findById(id);
    }

    // Generates a UTM link for tracking
    private String generateUTMLink(String email) {
        String baseLink = "https://yourplatform.com/api/cas/redirect/" + email;
        return baseLink;
    }

    //  Sends a custom welcome email with UTM link
    private void sendWelcomeEmail(String email, String utmLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to the Community Ambassador Program!");
        message.setText(
            "Dear Ambassador,\n\n" +
            "Welcome to the Community Ambassador Program! We're excited to have you onboard.\n\n" +
            "Here is your unique UTM tracking link:\n" +
            utmLink + "\n\n" +
            "Please begin sharing this link to help track your outreach efforts. We look forward to seeing the impact you’ll make!\n\n" +
            "Best regards,\nTeam Industry Academia Community");

        mailSender.send(message);
    }
}

