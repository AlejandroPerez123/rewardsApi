package com.retail.rewardapi.service;

import com.retail.rewardapi.model.Transaction;
import com.retail.rewardapi.model.RewardsCalculation;

import java.util.List;

public interface TransactionServiceI {


    public List<RewardsCalculation> calculateRewardsFromTransactions(List<Transaction> transactionList);

}
