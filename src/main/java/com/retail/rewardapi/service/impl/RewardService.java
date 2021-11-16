package com.retail.rewardapi.service.impl;

import com.retail.rewardapi.entity.Transaction;
import com.retail.rewardapi.service.RewardServiceI;
import com.retail.rewardapi.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class RewardService implements RewardServiceI {
    @Override
    public void calculateRewardPoints(List<Transaction> transactionList) {
        for (Transaction transaction :transactionList) {

            System.out.println("Month: "+ DateUtils.getMonthNumber(transaction.getDate()));
        }
    }
}
