package com.example.svclp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoyaltyPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String loyaltyPointsNumber; // Auto-generated
    private Long customerAccountNumber;
    private int loyaltyPoints;
    
    public LoyaltyPoints() {
    	this.loyaltyPoints= 150;

    }

   

    public LoyaltyPoints(String loyaltyPointsNumber, Long customerAccountNumber, int loyaltyPoints) {
		
		this.loyaltyPointsNumber = loyaltyPointsNumber;
		this.customerAccountNumber = customerAccountNumber;
		this.loyaltyPoints = 150;
	}



	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoyaltyPointsNumber() {
        return loyaltyPointsNumber;
    }

    public void setLoyaltyPointsNumber(String loyaltyPointsNumber) {
        this.loyaltyPointsNumber = loyaltyPointsNumber;
    }

    

    public Long getCustomerAccountNumber() {
		return customerAccountNumber;
	}



	public void setCustomerAccountNumber(Long customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}



	public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
