
package com.example.svclp.service;

import com.example.svclp.model.Transaction;
import com.example.svclp.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private LoyaltyPointsService loyaltyPointsService;

    @Override
    public Transaction processTransaction(Transaction transaction) {
        double transactionAmount = transaction.getTransactionAmount();
        double loyaltyPointsEarned = 0;
        
        
        if("Card".equals(transaction.getTransactionType()) || "Loyalty Deposits".equals(transaction.getTransactionType()))
        {
	        switch (transaction.getTransactionType()) 
	        {
	            case "Card":
	                loyaltyPointsEarned = transactionAmount * 0.05; 
	                break;
	            case "Loyalty Deposits":
	                loyaltyPointsEarned = transactionAmount * 0.10; 
	                break;
	     	
	        }


	        transaction.setLoyaltyPoints((int) loyaltyPointsEarned);

        
	        if ("Credit".equals(transaction.getTransactionDirection())) 
	        {
	            loyaltyPointsService.updateLoyaltyPoints(transaction.getAccountNumberFrom(), loyaltyPointsEarned);
	        }
	        else 
	        {
	        	loyaltyPointsService.updateLoyaltyPoints(transaction.getAccountNumberTo(), loyaltyPointsEarned);
	        }
        }
        else if("Loyalty Share".equals(transaction.getTransactionType()))
        {
        	loyaltyPointsEarned = (double)transaction.getLoyaltyPoints();
        	if("Credit".equals(transaction.getTransactionDirection())){
        	
        	loyaltyPointsService.updateLoyaltyPoints(transaction.getAccountNumberFrom(), -loyaltyPointsEarned);
        	loyaltyPointsService.updateLoyaltyPoints(transaction.getAccountNumberTo(), loyaltyPointsEarned);
        	}else if("Debit".equals(transaction.getTransactionDirection())) {

            	loyaltyPointsService.updateLoyaltyPoints(transaction.getAccountNumberFrom(), loyaltyPointsEarned);
            	loyaltyPointsService.updateLoyaltyPoints(transaction.getAccountNumberTo(), -loyaltyPointsEarned);
        		
        	}
        }
        	
        transaction = transactionRepository.save(transaction);
        
        return transaction;
    }


    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        return optionalTransaction.orElse(null);
    }
}
