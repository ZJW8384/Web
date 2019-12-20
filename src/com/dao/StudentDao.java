package com.dao;

import com.util.DBdao;
import com.vo.Student;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    PreparedStatement ps=null;
    Connection con=null;
    public List<Student> StuMessage(){
        List<Student> slist=new ArrayList<>();
        con= DBdao.getConnection();
        String sql="select * from student";
        try{
            ps=con.prepareStatement(sql);
            ResultSet re=ps.executeQuery();
            while(re.next()){
                Student stu=new Student();
                stu.setId(re.getInt(1));
                stu.setSid(re.getString("sid"));
                stu.setName(re.getString("name"));
                stu.setPass(re.getString("pass"));
                stu.setAge(re.getString("age"));
                stu.setSex(re.getString("sex"));
                stu.setPhone(re.getString("phone"));
                stu.setClasses(re.getString("class"));
                stu.setUnits(re.getString("units"));
                stu.setPass(re.getString("phone"));
                stu.setBalance(re.getString("balance"));
                stu.setMax(re.getString("max"));
                slist.add(stu);
            }
//            slist.forEach(a-> System.out.println(a));
        }catch (Exception e){
            e.printStackTrace();
        }
        return slist;
    }
}
