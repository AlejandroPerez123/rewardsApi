package com.retail.rewardapi.service.impl;

import com.retail.rewardapi.entity.Transaction;
import com.retail.rewardapi.model.RewardsCalculationResponse;
import com.retail.rewardapi.service.TransactionServiceI;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService implements TransactionServiceI {
    @Override
    public RewardsCalculationResponse createPurchase(Transaction purchase) {

        System.out.println("purchase created.");
        RewardsCalculationResponse calculationResponse = new RewardsCalculationResponse();
        calculationResponse.setRewardPoints(500);
        if(calculationResponse.getRewardRecord()==null){
            Map<String,Integer> record = new HashMap<>();
            calculationResponse.setRewardRecord(record);
        }
        calculationResponse.getRewardRecord().put("Test",100);
        return calculationResponse;
    }
}
