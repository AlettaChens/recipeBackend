package com.example.food.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public  static String getCurrentStringDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=df.format(new Date());
        return date;
    }
}
