package com.example.svclp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account_Details")
public class AccountDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountDetailID;
    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnoreProperties("accountDetail") 
    private Customer customer;
    private Long customerAccountNumber;
    private Long cardNumber;
    private String loyaltyPointsNumber; 
    
    
    
    
    
	
	
	
	public String getLoyaltyPointsNumber() {
		return loyaltyPointsNumber;
	}


	public void setLoyaltyPointsNumber(String loyaltyPointsNumber) {
		this.loyaltyPointsNumber = loyaltyPointsNumber;
	}


	public AccountDetail() {
		
	}


    public AccountDetail(Long customerAccountNumber, Long cardNumber) {
        this.customerAccountNumber = customerAccountNumber;
        this.cardNumber = cardNumber;
    }



	public Long getAccountDetailID() {
		return accountDetailID;
	}


	public void setAccountDetailID(Long accountDetailID) {
		this.accountDetailID = accountDetailID;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Long getCustomerAccountNumber() {
		return customerAccountNumber;
	}


	public void setCustomerAccountNumber(Long customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}


	public Long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	


}