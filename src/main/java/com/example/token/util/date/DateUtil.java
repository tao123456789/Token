package com.example.token.util.date;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public String getNowFormat1(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(date);
    }

    public String getNowFormat2(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
