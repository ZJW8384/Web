package com.util;

import com.vo.SelfMessage;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Person {
    PreparedStatement ps=null;
    Connection con=null;
    CountTime ct=new CountTime();
    //获取用户借的所有书籍
    public List<SelfMessage> toMessage(String flag,String uid){
        String sql=null;
        List<SelfMessage>  meg=new ArrayList<>();
        List<SelfMessage>  msg=new ArrayList<>();;
        try {
            con= DBdao.getConnection();
        if(flag.equals("2")){
            sql="select * from loan,student where loan.reader='"+uid+"' and student.sid='"+uid+"'";
            ps = con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                SelfMessage sm=new SelfMessage();
                sm.setBkname(re.getString("bkname"));
                sm.setBkid(re.getString("bkid"));
                sm.setMoney(re.getString("balance"));
                sm.setNumber(re.getString("number"));
                sm.setTime(re.getString("time"));
                sm.setBktime(re.getString("bktime"));
                meg.add(sm);
            }
        }else if(flag.equals("3")){
            sql="select * from loan,teacher where loan.reader='"+uid+"' and teacher.tid='"+uid+"'";
            ps = con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                SelfMessage sm=new SelfMessage();
                sm.setBkname(re.getString("bkname"));
                sm.setBkid(re.getString("bkid"));
                sm.setMoney(re.getString("balance"));
                sm.setNumber(re.getString("number"));
                sm.setTime(re.getString("time"));
                sm.setBktime(re.getString("bktime"));
                meg.add(sm);
            }
        }



        }catch (Exception e){
            e.printStackTrace();
        }
        return meg;

    }

//    @Test
//    public void TestS(){
//        Person p=new Person();
//        List<SelfMessage> lp=p.toMessage();
//        lp.forEach(a-> System.out.println(a));
//        System.out.println(lp.size());
//    }

}
