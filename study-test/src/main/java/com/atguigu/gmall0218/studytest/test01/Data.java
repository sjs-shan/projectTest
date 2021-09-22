package com.atguigu.gmall0218.studytest.test01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static void main(String[] args) throws ParseException {
        // 创建日期对象 输出当前的时间   Sat May 22 12:08:59 CST 2021

//        System.out.println(new Date());

        // 创建日期对象 把当前毫分秒转换为对象  //Thu Jan 01 08:00:00 CST 1970
//        System.out.println(new Date(0L));

//        Date date = new Date();
//        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
//        String format = simpleDateFormat.format(date);
//      String str=  simpleDateFormat="2018年12月11日";

//        Date parse = simpleDateFormat.parse(format);

//        System.out.println(date);
//        System.out.println(simpleDateFormat);
//        System.out.println(format);
//        System.out.println(parse);


//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年yy月dd日");
//        String str="2021年5月22日";
//        Date parse = simpleDateFormat.parse(str);
//        System.out.println(parse);
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder stringBuilder1 = stringBuilder.append("hello");

        System.out.println(stringBuilder);
        System.out.println(stringBuilder1);

    }


}
