package com.retail.rewardapi.controller;

import com.retail.rewardapi.model.RewardsCalculation;
import com.retail.rewardapi.model.Transaction;
import com.retail.rewardapi.service.TransactionServiceI;
import com.retail.rewardapi.service.impl.TransactionService;
import com.retail.rewardapi.utils.Calculations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TransactionControllerTest {


    @Mock
    private TransactionService transactionService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateRewardsTest(){
        int expected = 90;

        RewardsCalculation rewardsCalculation = new RewardsCalculation();
        rewardsCalculation.setRewardPoints(Calculations.calculateRewardPoints(120));
        Assert.assertEquals(expected,rewardsCalculation.getRewardPoints());
    }

    @Test
    public void calculateRewardsTestUnder100(){
        int expected = 10;
        RewardsCalculation rewardsCalculation = new RewardsCalculation();
        rewardsCalculation.setRewardPoints(Calculations.calculateRewardPoints(60));
        Assert.assertEquals(expected,rewardsCalculation.getRewardPoints());
    }

    @Test
    public void calculateRewardsTestOver100(){
        int expected = 52;
        RewardsCalculation rewardsCalculation = new RewardsCalculation();
        rewardsCalculation.setRewardPoints(Calculations.calculateRewardPoints(101));
        Assert.assertEquals(expected,rewardsCalculation.getRewardPoints());
    }

}
