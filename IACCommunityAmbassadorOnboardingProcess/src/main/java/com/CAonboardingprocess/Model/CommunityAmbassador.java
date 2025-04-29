 package com.CAonboardingprocess.Model;

import java.sql.Timestamp;			
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Marks this class as a JPA entity mapped to a database table
@Entity

// Specifies the database table name
@Table(name = "Community_Ambassadors")
public class CommunityAmbassador {

	//  Primary key with auto-increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String utmLink; //  Auto-generated UTM link
    private int signups;    // Tracks number of signups

    
    // Automatically sets timestamp when record is created
    @CreationTimestamp
    private Timestamp createdAt;
 
    //  Additional details
    private String address;  // New field for address
    private String collegeOrUniversity;  // New field for college/university
    private String phone;  // New field for phone number

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUtmLink() {
        return utmLink;
    }

    public void setUtmLink(String utmLink) {
        this.utmLink = utmLink;
    }

    public int getSignups() {
        return signups;
    }

    public void setSignups(int signups) {
        this.signups = signups;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollegeOrUniversity() {
        return collegeOrUniversity;
    }

    public void setCollegeOrUniversity(String collegeOrUniversity) {
        this.collegeOrUniversity = collegeOrUniversity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}