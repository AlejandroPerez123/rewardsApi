package com.retail.rewardapi.service;

import com.retail.rewardapi.entity.Transaction;

import java.util.List;

public interface RewardServiceI {


    public void calculateRewardPoints(List<Transaction> transactionList);
}
