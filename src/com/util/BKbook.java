package com.util;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BKbook {
    public static List<Object> Bkbook(String id, String uid){
        Connection con=null;
        PreparedStatement pst=null;
        List<Object> msg=new ArrayList<>();
        try {
            con = DBdao.getConnection();
            con.setAutoCommit(false);//取消自动提交
            String sql="select * from loan where reader='"+uid+"'";
            pst=con.prepareStatement(sql);
            String time=null;
            String bktime=null;
            String bkid=null;
            String reader=null;
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                bktime=rs.getString("bktime");
                time=rs.getString("time");
                bkid=rs.getString("bkid");
                reader=rs.getString("reader");
            }
            String sql2="select flag from user where uid='"+uid+"'";
            pst=con.prepareStatement(sql2);
            String flag=null;
            ResultSet re=pst.executeQuery();
            while (re.next()){
                flag=re.getString("flag");
            }
            CountTime cs=new CountTime();
            int day=cs.Day(bktime);//还书时间
            int now=cs.Day(time);//借书时间
//            System.out.println("还书时间"+now);
            msg.add(now);
            if(flag.equals("2")){
//                int days=30-day;
                if(day>=0){//学生还书
                    msg.add(0);
                    String sql3="delete from loan where bkid='"+id+"' and reader='"+uid+"'";
                    pst=con.prepareStatement(sql3);
                    pst.executeUpdate();
                    String sql4="insert into back(bkid,reader,money) values('"+bkid+"','"+reader+"','0')";
                    pst=con.prepareStatement(sql4);
                    pst.executeUpdate();
                }else {
                    String sql3="delete from loan where bkid='"+id+"' and reader='"+uid+"'";
                    pst=con.prepareStatement(sql3);
                    pst.executeUpdate();
                    String sql5="select balance from student where sid='"+reader+"'";
                    String mon;
                    BigDecimal money;
                    BigDecimal m = null;
                    pst=con.prepareStatement(sql5);
                    ResultSet res=pst.executeQuery();
                    while (res.next()){
                        mon=res.getString("balance");
                        m=new BigDecimal(mon);//防止精度损失
                    }
                    BigDecimal a=BigDecimal.valueOf(Math.abs(30-day)*0.1);//扣费
                    msg.add(Math.abs(30-day)*0.1);
//                    System.out.println(a);
                    money=m.subtract(a);
                    System.out.println("扣钱"+Math.abs(30-day)*0.1);
                    System.out.println("原额"+m);
                    System.out.println("余额"+money);
                    String sql6="update student set balance='"+money+"' where sid='"+uid+"'";
                    pst=con.prepareStatement(sql6);
                    pst.executeUpdate();
                    String sql4="insert into back(bkid,reader,money) values('"+bkid+"','"+reader+"','"+a+"')";
                    pst=con.prepareStatement(sql4);
                    pst.executeUpdate();
                }
            }

            if(flag.equals("3")){//教师还书
                int days=45-day;
                if(day>0){
                    String sql3="delete from loan where bkid='"+id+"'";
                    pst=con.prepareStatement(sql3);
                    pst.executeUpdate();
                    String sql4="insert into back(bkid,reader,money) values('"+bkid+"','"+reader+"','0')";
                    pst=con.prepareStatement(sql4);
                    pst.executeUpdate();
                }else {
                    String sql3="delete from loan where bkid='"+id+"' and reader='"+uid+"'";
                    pst=con.prepareStatement(sql3);
                    pst.executeUpdate();
                    String sql4="insert into back(bkid,reader,money) values('"+bkid+"','"+reader+"','0')";
                    pst=con.prepareStatement(sql4);
                    pst.executeUpdate();
                    String sql5="select balance from teacher where tid='"+reader+"'";
                    String mon=null;
                    double money;
                    double k=0;
                    pst=con.prepareStatement(sql5);
                    ResultSet res=pst.executeQuery();
                    while (res.next()){
                        mon=res.getString("balance");
                        k=Double.parseDouble(mon);
                    }
                    money=k-Math.abs(45-days)*0.1;
                    String sql6="update teacher set balance='"+money+"' where tid='"+uid+"'";
                    pst=con.prepareStatement(sql6);
                    pst.executeUpdate();
                }
            }
            String num=null;
            int number;
            String sql7="select number from book where bkid='"+bkid+"'";
            pst=con.prepareStatement(sql7);
            ResultSet res=pst.executeQuery();
            while (res.next()){
                num=res.getString("number");
            }
            number=Integer.parseInt(num)+1;
            String sql8="update book set number='"+number+"' where bkid='"+bkid+"'";
            pst=con.prepareStatement(sql8);
            String sql9="update book set state=1 where bkid='"+bkid+"'";
            pst=con.prepareStatement(sql9);
            pst.executeUpdate();
            con.commit();
        }catch (Exception e){
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            DBdao.getConnection();
            e.printStackTrace();
        }
        return msg;
    }
}
