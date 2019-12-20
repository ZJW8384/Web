package com.util;

import com.vo.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotMessage {
    PreparedStatement pst=null;
    ResultSet re=null;
    Connection con=null;
    public List<Message> addNote(){
        con= DBdao.getConnection();
        String sql="select * from message ";//留言查询
        List<Message> mlist=new ArrayList<>();
        try {
            pst=con.prepareStatement(sql);
            re=pst.executeQuery();
            while(re.next()){
                Message mg=new Message();
                mg.setId(re.getInt(1));
                mg.setMes(re.getString("message"));
                mg.setUid(re.getString("uid"));
                mg.setTime(re.getString("time"));
                mlist.add(mg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  mlist;
    }
}
