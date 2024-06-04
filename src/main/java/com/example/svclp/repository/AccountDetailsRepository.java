package com.example.svclp.repository;

import com.example.svclp.model.AccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetail, Long> {

   
    List<AccountDetail> findByCustomerAccountNumberAndCardNumber(Long customerAccountNumber, Long cardNumber);
}
