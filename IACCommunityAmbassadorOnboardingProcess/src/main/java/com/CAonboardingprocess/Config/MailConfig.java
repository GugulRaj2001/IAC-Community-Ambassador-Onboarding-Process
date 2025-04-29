package com.CAonboardingprocess.Config;

import java.util.Properties;	

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

// Indicates this is a configuration class for Spring
@Configuration
public class MailConfig {

	// Bean to create and configure JavaMailSender
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        
        // (Set your email service credentials here) Using properties from application.properties
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);  // Port for Gmail's SMTP server

        mailSender.setUsername("rishi.gugul3@gmail.com");//email
        mailSender.setPassword("wxon aqbo itkw dfgx");  // Use generated app password here

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        return mailSender;
    }
}