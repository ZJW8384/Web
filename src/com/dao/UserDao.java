package com.dao;

import com.util.DBdao;
import com.vo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    PreparedStatement ps=null;
    Connection con=null;
    Books books=new Books();
    public  List<User> Search(String name, String pass) {
        String sql = "select  * from user where uid='"+name+"' and pass='"+pass+"'";
        List<User> list=new ArrayList<>();
        con= DBdao.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                User use = new User();
                use.setId(re.getString("uid"));
                use.setPass(re.getString("pass"));
                use.setFlag(re.getString("flag"));
                list.add(use);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

//@Test
//    public void toLogin(){
//        UserDao ud=new UserDao();
//        List<User> list=ud.Search("admin","admin123456");
//        list.forEach(a-> System.out.println(a));
//    }

}
