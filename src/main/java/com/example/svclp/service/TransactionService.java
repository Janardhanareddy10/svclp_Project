
package com.example.svclp.service;

import java.util.List;

import com.example.svclp.model.Transaction;

public interface TransactionService {
    Transaction processTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    
    Transaction getTransactionById(Long transactionId);
}
