package com.retail.rewardapi.utils;

public class Calculations {

    public static int calculateRewardPoints(int purchaseAmount){
        int pointsEarned = 0;
        int amountOver100 = purchaseAmount-100;
        int amountOver50 = purchaseAmount-50;

        if(amountOver50>0){
            if(amountOver50<=50){
                pointsEarned = amountOver50;
            }else{
                pointsEarned = 50;
            }
        }
        if(amountOver100>0){
            pointsEarned=pointsEarned+(amountOver100*2);
        }
        return pointsEarned;
    }
}
