package com.dao;

import com.util.DBdao;
import com.vo.BookMager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookSearch {
    PreparedStatement ps=null;
    Connection con=null;

    public List<BookMager> Public(String sql){
        List<BookMager> list=new ArrayList<>();
        con= DBdao.getConnection();//建立连接
        try {
            ps=con.prepareStatement(sql);
            ResultSet re=ps.executeQuery();
            while(re.next()) {
                BookMager bk=new BookMager();
                bk.setId(re.getInt(1));
                bk.setBkid(re.getString("bkid"));
                bk.setBkname(re.getString("bkname"));
                bk.setISBN(re.getString("ISBN"));
                bk.setPrice(re.getString("price"));
                bk.setPress(re.getString("press"));
                bk.setLanguage(re.getString("language"));
                bk.setTime(re.getString("time"));
                bk.setWriter(re.getString("writer"));
                bk.setSubject(re.getString("subject"));
                bk.setState(re.getString("state"));
                bk.setPlace(re.getString("place"));
                bk.setDate(re.getString("date"));
                bk.setIndexs(re.getString("indexs"));
                bk.setBarcode(re.getString("barcode"));
                bk.setCollection(re.getString("collection"));
                bk.setCollections(re.getString("collections"));
                bk.setType(re.getString("type"));
                bk.setClassify(re.getString("classify"));
                bk.setNumber(re.getString("number"));
                list.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
