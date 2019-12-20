package com.util;

import com.vo.Student;
import com.vo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindUser {
    PreparedStatement ps=null;
    Connection con=null;
    public List<Teacher> findTeacher(String tid){
        List<Teacher> tlist=new ArrayList<>();
        String sql="select * from teacher where tid='"+tid+"'";
        con=DBdao.getConnection();
        try {
            ps=con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while(re.next()){

                    Teacher tea=new Teacher();
                    tea.setId(re.getInt(1));
                    tea.setTid(re.getString("tid"));
                    tea.setName(re.getString("name"));
                    tea.setPass(re.getString("pass"));
                    tea.setAge(re.getString("age"));
                    tea.setSex(re.getString("sex"));
                    tea.setUnits(re.getString("units"));
                    tea.setPhone(re.getString("phone"));
                    tea.setBalance(re.getString("balance"));
                    tea.setMax(re.getString("max"));
                    tlist.add(tea);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tlist;
    }
    public List<Student> findStudent(String sid){
        List<Student> slist=new ArrayList<>();
        String sql="select * from student where sid='"+sid+"'";
        con=DBdao.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
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
        }catch (Exception e){
            e.printStackTrace();
        }

        return slist;
    }
}
