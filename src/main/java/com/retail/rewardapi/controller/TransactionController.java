package com.retail.rewardapi.controller;


import com.retail.rewardapi.model.Transaction;
import com.retail.rewardapi.model.RewardsCalculation;
import com.retail.rewardapi.service.TransactionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {



    @Autowired
    private TransactionServiceI transactionServiceI;


    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> calculateRewardsFromRecords(@RequestBody List<Transaction> transactionList){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(transactionServiceI.calculateRewardsFromTransactions(transactionList));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not process transactions.");
        }


    }



}
