package com.retail.rewardapi.controller;


import com.retail.rewardapi.entity.Transaction;
import com.retail.rewardapi.model.RewardsCalculationResponse;
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



    @PostMapping("/{customerId}")
    public ResponseEntity<RewardsCalculationResponse> createPurchase(@RequestBody Transaction transaction){


        return ResponseEntity.status(HttpStatus.CREATED).body(transactionServiceI.createPurchase(transaction));
    }



}