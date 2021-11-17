package com.retail.rewardapi.service.impl;

import com.retail.rewardapi.model.Transaction;
import com.retail.rewardapi.model.RewardsCalculation;
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

    List<RewardsCalculation> rewards = new LinkedList<>();



    @Override
    public List<RewardsCalculation> calculateRewardsFromTransactions(List<Transaction> transactionList) {
        for (Transaction transaction :transactionList) {
            createPurchase(transaction);
        }
        return this.rewards;
    }




    private List<RewardsCalculation> createPurchase(Transaction purchase) {

        int pointsEarned = Calculations.calculateRewardPoints(purchase.getAmount());
        String monthOfTransaction = DateUtils.getMonthName(purchase.getDate());
        boolean customerRegistered = false;
        if(!rewards.isEmpty()) {
            for (RewardsCalculation reward : rewards) {
                if (reward.getCustomerId() == purchase.getCustomerId()) {
                    reward.setRewardPoints(reward.getRewardPoints() + pointsEarned);
                    if(reward.getRewardRecord().get(monthOfTransaction)==null){
                        reward.getRewardRecord().put(monthOfTransaction, pointsEarned);
                    }else{
                        reward.getRewardRecord().put(monthOfTransaction,reward.getRewardRecord().get(monthOfTransaction)+pointsEarned);
                    }
                    customerRegistered = true;
                }
            }
            if (!customerRegistered) {
                rewards.add(createRewardsCalculationRecord(purchase));
            }
        }else {
            rewards.add(createRewardsCalculationRecord(purchase));
        }

        return rewards;
    }

    private RewardsCalculation createRewardsCalculationRecord(Transaction transaction){
        int pointsEarned = Calculations.calculateRewardPoints(transaction.getAmount());
        String monthOfTransaction = DateUtils.getMonthName(transaction.getDate());
        RewardsCalculation calculationResponse = new RewardsCalculation();
        calculationResponse.setRewardPoints(pointsEarned);
        if (calculationResponse.getRewardRecord() == null) {
            Map<String, Integer> record = new HashMap<>();
            calculationResponse.setRewardRecord(record);
        }
            calculationResponse.setCustomerId(transaction.getCustomerId());
            calculationResponse.getRewardRecord().put(monthOfTransaction, pointsEarned);
        return calculationResponse;
    }




}
