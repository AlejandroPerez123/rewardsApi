package com.retail.rewardapi.service.impl;

import com.retail.rewardapi.entity.Transaction;
import com.retail.rewardapi.model.RewardsCalculationResponse;
import com.retail.rewardapi.service.TransactionServiceI;
import com.retail.rewardapi.utils.Calculations;
import com.retail.rewardapi.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService implements TransactionServiceI {

    List<RewardsCalculationResponse> rewards = new LinkedList<>();

    @Override
    public void createPurchase(Transaction purchase) {

        String monthOfTransaction = DateUtils.getMonthName(purchase.getDate());
        boolean customerRegistered = false;
        if(!rewards.isEmpty()) {
            for (RewardsCalculationResponse reward : rewards) {
                if (reward.getCustomerId() == purchase.getCustomerId()) {
                    reward.setRewardPoints(reward.getRewardPoints() + purchase.getAmount());
                    if(reward.getRewardRecord().get(monthOfTransaction)==null){
                        reward.getRewardRecord().put(monthOfTransaction, purchase.getAmount());
                    }else{
                        reward.getRewardRecord().put(monthOfTransaction,reward.getRewardRecord().get(monthOfTransaction)+purchase.getAmount());
                    }
                    customerRegistered = true;
                }
            }
            if (!customerRegistered) {
                rewards.add(createRewardsRecord(purchase));
            }
        }else {
            rewards.add(createRewardsRecord(purchase));
        }

    }

    private RewardsCalculationResponse createRewardsRecord(Transaction transaction){
        String monthOfTransaction = DateUtils.getMonthName(transaction.getDate());
        RewardsCalculationResponse calculationResponse = new RewardsCalculationResponse();
        calculationResponse.setRewardPoints(transaction.getAmount());
        if (calculationResponse.getRewardRecord() == null) {
            Map<String, Integer> record = new HashMap<>();
            calculationResponse.setRewardRecord(record);
        }
            calculationResponse.setCustomerId(transaction.getCustomerId());
            calculationResponse.getRewardRecord().put(monthOfTransaction, Calculations.calculateRewardPoints(transaction.getAmount()));
        return calculationResponse;
    }

    @Override
    public List<RewardsCalculationResponse> getCustomerPoints(List<Transaction> transactionList) {
        for (Transaction transaction :transactionList) {
           createPurchase(transaction);
        }
        return this.rewards;
    }


}
