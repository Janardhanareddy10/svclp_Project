package com.example.svclp.repository;

import com.example.svclp.model.LoyaltyPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPoints, Long> {
	LoyaltyPoints findByCustomerAccountNumber(Long customerAccountNumber);
}
