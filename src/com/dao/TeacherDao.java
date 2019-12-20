package com.dao;

import com.util.DBdao;
import com.vo.Teacher;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    PreparedStatement ps=null;
    Connection con=null;
    public List<Teacher> TerMessage(){
        List<Teacher> tlist=new ArrayList<>();
        con= DBdao.getConnection();
        String sql="select  * from teacher";
        try {
            ps = con.prepareStatement(sql);
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return tlist;
    }
//    @Test
//    public void tes(){
//        TeacherDao te=new TeacherDao();
//        List<Teacher> t=te.TerMessage();
//        t.forEach(a-> System.out.println(a));
//    }
}
