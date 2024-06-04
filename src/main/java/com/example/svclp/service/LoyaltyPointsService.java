package com.example.svclp.service;

import com.example.svclp.model.LoyaltyPoints;
import com.example.svclp.repository.LoyaltyPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyPointsService {

    @Autowired
    private LoyaltyPointsRepository loyaltyPointsRepository;

    public LoyaltyPoints createLoyaltyPoints(LoyaltyPoints loyaltyPoints) {
        return loyaltyPointsRepository.save(loyaltyPoints);
    }
    public void updateLoyaltyPoints(Long customerAccountNumber, double loyaltyPointsEarned) {
        LoyaltyPoints loyaltyPoints = loyaltyPointsRepository.findByCustomerAccountNumber(customerAccountNumber);
        if (loyaltyPoints != null) {
            loyaltyPoints.setLoyaltyPoints(loyaltyPoints.getLoyaltyPoints() + (int)loyaltyPointsEarned);
        } else {
            loyaltyPoints = new LoyaltyPoints();
            loyaltyPoints.setCustomerAccountNumber(customerAccountNumber);
            loyaltyPoints.setLoyaltyPoints((int) loyaltyPointsEarned);
        }
        loyaltyPointsRepository.save(loyaltyPoints);
    }
}
