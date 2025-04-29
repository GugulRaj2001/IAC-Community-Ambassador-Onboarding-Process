package com.CAonboardingprocess.Config;

import org.springframework.context.annotation.Bean;	
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Marks this as a Spring configuration class
@Configuration

// Enables Spring Security support for the application
@EnableWebSecurity
public class SecurityConfig {

	// Defines the custom security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
     // Disables CSRF protection (use caution in production)
            .csrf(csrf -> csrf.disable())
            
         // Define which URLs are accessible without authentication
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/cas/register",  // Registration end point
                    "/api/cas/performance",  // Public view for performance
                    "/api/cas/track-signup",  // UTM link tracking
                    "/",
                    "/register.html",
                    "/dashboard.html",
                    "/styles.css",
                    "/register.js"
                ).permitAll() // These are publicly accessible
                .anyRequest().authenticated() // All other end points require login
            )
            .formLogin(login -> login //  Use form-based login and redirect to dash board after login
                .defaultSuccessUrl("/dashboard.html", true)
            )
            .httpBasic(Customizer.withDefaults());  // Enable HTTP Basic Authentication as well

        return http.build();
    }

    // Add this CORS configuration
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5500"); //Put frontend port
            }
        };
    }
}
