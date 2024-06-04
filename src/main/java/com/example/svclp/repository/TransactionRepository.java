package com.example.svclp.repository;

import com.example.svclp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    List<Transaction> findByAccountNumberFromOrAccountNumberTo(Long accountNumberFrom, Long accountNumberTo);
}
