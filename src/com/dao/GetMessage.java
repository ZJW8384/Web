package com.dao;

import com.util.DBdao;
import com.vo.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetMessage {
    Connection con=null;
    PreparedStatement ps=null;
    public List<Message> getMessage(){
        List<Message> list=new ArrayList<>();
        String sql="select * from message";//查询留言
        try {
            con = DBdao.getConnection();
            ps=con.prepareStatement(sql);
            ResultSet re=ps.executeQuery();
            while (re.next()){
                Message mg=new Message();
                mg.setBkname(re.getString("bknama"));
                mg.setId(re.getInt(1));
                mg.setUid(re.getString("uid"));
                mg.setMes(re.getString("msg"));
                mg.setTime(re.getString("time"));
                list.add(mg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
