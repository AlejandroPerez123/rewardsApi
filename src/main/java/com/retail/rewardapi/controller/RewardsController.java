package com.retail.rewardapi.controller;


import com.retail.rewardapi.entity.Transaction;
import com.retail.rewardapi.service.RewardServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reward")
public class RewardsController {

    @Autowired
    private RewardServiceI rewardServiceI;

    @GetMapping("/")
    public void calculateRewardsPerCustomer(@RequestBody List<Transaction> transactionList){
        rewardServiceI.calculateRewardPoints(transactionList);

    }
}
