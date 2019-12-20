package com.dao;

import com.util.DBdao;
import com.vo.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao {
    PreparedStatement ps=null;
    Connection con=null;
    public List<Schedule> getSchedule(){
        List<Schedule> list= new ArrayList<>();
        String sql="select * from schedule";//查询日程
        con= DBdao.getConnection();
        try {
            ps=con.prepareStatement(sql);
            ResultSet re=ps.executeQuery();
            while (re.next()){
                Schedule sd=new Schedule();
                sd.setMsg(re.getString("msg"));
                sd.setTime(re.getString("time"));
                sd.setId(re.getInt(1));
                list.add(sd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
