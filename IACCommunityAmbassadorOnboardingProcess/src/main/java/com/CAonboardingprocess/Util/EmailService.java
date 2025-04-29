package com.CAonboardingprocess.Util;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// Marks this class as a Spring-managed service component
@Service
public class EmailService {

	// Injects the JavaMailSender bean configured in MailConfig
    @Autowired
    private JavaMailSender mailSender;

 // Sends a test email when the application starts (can be used for diagnostics)
    public void sendTestEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("rishi.gugul3@gmail.com");  // Change to the recipient's email
        message.setSubject("Test Email");
        message.setText("This is a test email sent from Spring Boot.");
        mailSender.send(message);
        System.out.println("✅ Email Sent Successfully!");
    }
}