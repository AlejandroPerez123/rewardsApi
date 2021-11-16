package com.retail.rewardapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardsCalculationResponse {


    private int customerId;

    private int rewardPoints;

    private Map<String,Integer> rewardRecord;
}
