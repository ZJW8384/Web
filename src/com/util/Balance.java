package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Balance {
    PreparedStatement ps=null;
    Connection con=null;

    public String getMoneys(String flag,String uid){
        String money=null;
        String sql;
        if(flag.equals("2")){//判断用户标识
            con=DBdao.getConnection();
            try{
                sql="select balance from student where sid='"+uid+"'";//查询余额
                ps = con.prepareStatement(sql);
                ResultSet re = ps.executeQuery();
                while (re.next()){
                    money=re.getString("balance");
                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(flag.equals("3")){
            try{
                con=DBdao.getConnection();
                sql="select balance from teacher where tid='"+uid+"'";
                ps = con.prepareStatement(sql);
                ResultSet re = ps.executeQuery();
                while (re.next()){
                    money=re.getString("balance");
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return money;
    }
}
