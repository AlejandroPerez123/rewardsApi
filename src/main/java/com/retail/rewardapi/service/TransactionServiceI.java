package com.retail.rewardapi.service;

import com.retail.rewardapi.entity.Transaction;
import com.retail.rewardapi.model.RewardsCalculationResponse;

import java.util.List;

public interface TransactionServiceI {

    public void createPurchase(Transaction purchase);
    public List<RewardsCalculationResponse> getCustomerPoints(List<Transaction> transactionList);
}
