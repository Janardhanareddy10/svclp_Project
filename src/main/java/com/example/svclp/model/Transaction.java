package com.example.svclp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private String transactionType;
    private Long accountNumberFrom;
    private Long accountNumberTo;
    private Long loyaltyPointsCreditTo;
    private Long loyaltyPointsDebitFrom;
    private int loyaltyPoints; 
    private double transactionAmount;
    private String transactionDirection;
   
    
    

    
    
    
    
    
    public Transaction() {
    }






	public Long getTransactionId() {
		return transactionId;
	}






	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}






	public String getTransactionType() {
		return transactionType;
	}






	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}






	public Long getAccountNumberFrom() {
		return accountNumberFrom;
	}






	public void setAccountNumberFrom(Long accountNumberFrom) {
		this.accountNumberFrom = accountNumberFrom;
	}






	public Long getAccountNumberTo() {
		return accountNumberTo;
	}






	public void setAccountNumberTo(Long accountNumberTo) {
		this.accountNumberTo = accountNumberTo;
	}






	public Long getLoyaltyPointsCreditTo() {
		return loyaltyPointsCreditTo;
	}






	public void setLoyaltyPointsCreditTo(Long loyaltyPointsCreditTo) {
		this.loyaltyPointsCreditTo = loyaltyPointsCreditTo;
	}






	public Long getLoyaltyPointsDebitFrom() {
		return loyaltyPointsDebitFrom;
	}






	public void setLoyaltyPointsDebitFrom(Long loyaltyPointsDebitFrom) {
		this.loyaltyPointsDebitFrom = loyaltyPointsDebitFrom;
	}






	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}






	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}






	public double getTransactionAmount() {
		return transactionAmount;
	}






	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}






	public String getTransactionDirection() {
		return transactionDirection;
	}






	public void setTransactionDirection(String transactionDirection) {
		this.transactionDirection = transactionDirection;
	}
	





	
    




	
	





	
     
	






	
    
    
    

}
