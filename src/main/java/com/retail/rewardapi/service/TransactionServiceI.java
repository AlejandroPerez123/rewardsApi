package com.retail.rewardapi.service;

import com.retail.rewardapi.entity.Transaction;
import com.retail.rewardapi.model.RewardsCalculationResponse;

public interface TransactionServiceI {

    public RewardsCalculationResponse createPurchase(Transaction purchase);
}
