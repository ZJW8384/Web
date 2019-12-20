package com.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Decision {
    PreparedStatement ps=null;
    Connection con=null;
    //获取图书馆藏
    public int  bookNumber(String id){
        int number=0;
        con=DBdao.getConnection();
        try {
            String sql="select number from book where id='"+id+"'";
            ps=con.prepareStatement(sql);
            ResultSet re=ps.executeQuery();
            while (re.next()){
                number=re.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return number;
    }
    public int bookMax(String uid){
        int number=0;
            con=DBdao.getConnection();
            String sql="select sum(number) from loan where reader='"+uid+"'";//查询用户借书数量的总和
            try{
                ps=con.prepareStatement(sql);
                ResultSet re=ps.executeQuery();
                while (re.next()){
                    number=re.getInt(1);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        return number;
    }
}
