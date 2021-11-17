package com.retail.rewardapi.controller;


import com.retail.rewardapi.model.Transaction;
import com.retail.rewardapi.model.RewardsCalculation;
import com.retail.rewardapi.service.TransactionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {



    @Autowired
    private TransactionServiceI transactionServiceI;


    @PostMapping("/")
    public List<RewardsCalculation> calculateRewardsFromRecords(@RequestBody List<Transaction> transactionList){
        return transactionServiceI.calculateRewardsFromTransactions(transactionList);

    }



}
