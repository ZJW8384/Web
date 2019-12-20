package com.dao;

import com.util.DBdao;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdeBooks {
    PreparedStatement pst=null;
    Connection con=null;
    public  void DOup(String bkid,String bkname,String ISBN,String price,String writer,String subject,String press,String language,String place,String date,String indexs, String classify,String number){

        try{
            con= DBdao.getConnection();
            con.setAutoCommit(false);//sql事务，取消自动提交
            String sql="update book set bkname='"+bkname+"',ISBN='"+ISBN+"',price='"+price+"',writer='"+writer+"',press='"+press+"',language='"+language+"',subject='"+subject+"',place='"+place+"',date='"+date+"',indexs='"+indexs+"',classify='"+classify+"',number='"+number+"' where bkid='"+bkid+"'";
            pst=con.prepareStatement(sql);
            pst.executeUpdate();
            String sql2="update loan set bkname='"+bkname+"' where bkid='"+bkid+"'";
            pst=con.prepareStatement(sql2);
            pst.executeUpdate();
            con.commit();;
        }catch (Exception e){
            try {
                con.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }
    public void DeleteBook( String bkid){
        con= DBdao.getConnection();
        String sql="delete from book where bkid='"+bkid+"'";
        try {
            pst=con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
