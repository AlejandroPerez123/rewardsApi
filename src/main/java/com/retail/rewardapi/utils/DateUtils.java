package com.retail.rewardapi.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {


    public static String getMonthName(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return  localDate.getMonth().name();

    }
}
