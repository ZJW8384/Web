package com.util;

import com.vo.SelfMessage;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CountTime {

    public  Date isTime(String times) throws ParseException {
        SelfMessage sm=new SelfMessage();
        Date date=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化输出
        date=dateFormat.parse(times);//转换成时间类型
        return date;
    }

    public int  Day(String times) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s=sdf.format((new Date()));//获取当前日期
        CountTime cs=new CountTime();
        SelfMessage sm=new SelfMessage();
//        Date date=null;
        Date date=sdf.parse(times);//将字符串转换成日期
//        Date t=cs.isTime("2019-4-8 8:30:09");
        Date k=cs.isTime(s);
//        System.out.println(date);
//        System.out.println(k);
        long sk=date.getTime()-k.getTime();//获取时间差
        int day=(int)(sk/(1000 * 60 * 60 * 24));//转换成天数
        return  day;
    }
//    @Test
//    public void ts(){
//        CountTime cs=new CountTime();
//        try {
//            int day=cs.Day("2019-12-16 21:12:8");
//            System.out.println(day);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

}
