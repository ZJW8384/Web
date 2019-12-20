package com.util;

import java.sql.*;

public class Borrow {
    PreparedStatement ps=null;
    Connection con=null;
    public int Brow(String bkid,String bkname,String uid){
        Borrow bw=new Borrow();
        con= DBdao.getConnection();
        int sing=bw.getNNumber(uid);//获取用户借书总量
        try{
//            CallableStatement proc = null;//调用存储过程
            con.setAutoCommit(false);
            if(sing!=0){
                String sql="insert into loan(bkid,bkname,reader) values(?,?,?)";
                DBdao.SQLment(sql,bkid,bkname,uid);
                String  sql2="select time from loan where bktime is null";
                String bid=null;
                String time=null;
                ps=con.prepareStatement(sql2);
                ResultSet rs=ps.executeQuery();
                while (rs.next()){
//                    bid=rs.getString("id");
                    time=rs.getString("time");
                }
                String sql3="update loan set bktime=DATE_ADD('"+time+"',INTERVAL 30 DAY ) where bkname='"+bkname+"'";
                ps=con.prepareStatement(sql3);
                ps.executeUpdate();
                String sql4="select number from book where bkid='"+bkid+"'";
                String b=null;//图书剩余数量
                int c=0;
                ps=con.prepareStatement(sql4);
                ResultSet re=ps.executeQuery();
                while (re.next()){
                    b=re.getString("number");
                }
                c=Integer.parseInt(b);
                if(c>0){
                    c=c-1;//借书，库存减少
                    String sql5="update book set number='"+c+"' where bkid='"+bkid+"'";
                    ps=con.prepareStatement(sql5);
                }else {
                    String sql6="update book set state=0 where bkid='"+bkid+"'";
                    ps=con.prepareStatement(sql6);
                }
                ps.executeUpdate();
//                proc=con.prepareCall("{call time_add(?)}");
//                proc.setInt(1,a);
                con.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sing;
    }
    private  int  getNNumber(String uid){
        con= DBdao.getConnection();
        int number=0;//用户借书总数
        String flag=null;//判断用户类型
        String less=null;//书的库存数
        String sql="select flag from user where uid='"+uid+"'";;
        String sql2="select sum(number) from loan where reader='"+uid+"'";
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement(sql);
            ResultSet re=ps.executeQuery();
            while (re.next()){
                flag=re.getString("flag");
            }
            ps=con.prepareStatement(sql2);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                number=rs.getInt(1);
            }
//            int num=Integer.parseInt(number);
            if(flag.equals("2")){
                if(number>2){
                    number=0;
                }
                else {
                    number=3;
                }
            }
            if(flag.equals("3")){
                if(number>4){
                   number=0;
                }else {
                    number=5;
                }
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }
}
