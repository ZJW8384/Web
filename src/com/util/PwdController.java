package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PwdController {
    //修改密码
    public static void Uppass(String name,String pass){
        PreparedStatement pst=null;
        Connection con=null;
        String flag=null;
        try{
            con= DBdao.getConnection();
            con.setAutoCommit(false);
            String sql="select flag from user where uid='"+name+"'";
            pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                flag=rs.getString("flag");
            }
            String sql2="update user set pass='"+pass+"' where uid='"+name+"'";
            pst=con.prepareStatement(sql2);
            pst.executeUpdate();
            if(flag.equals("2")){
                String sql3="update student set pass='"+pass+"' where sid='"+name+"'";
                pst=con.prepareStatement(sql3);
                pst.executeUpdate();
            }
            if(flag.equals("3")){
                String sql4="update teacher set pass='"+pass+"' where tid='"+name+"'";
                pst=con.prepareStatement(sql4);
                pst.executeUpdate();
            }
            con.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
