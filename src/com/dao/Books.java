package com.dao;

import com.vo.User;
import com.util.DBdao;
import com.vo.BookMager;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Books {
    PreparedStatement ps=null;
    Connection con=null;
    List<Object> lists=new ArrayList<>();
    //用于模糊查询，效果显著
    public List<BookMager> allBook(String indexs, String name, String writer,  String subject){
    String sql="select * from book where 1=1";//where 1=1 防止不传参的情况报错，不传参则全部查询
        List<BookMager> list=new ArrayList<>();
       if(!StringUtils.isEmpty(indexs)){//判断索引是否为空，不为空则加入查询条件
           sql=sql+" and indexs like ?";
           lists.add("%"+indexs+"%");
       }
       if(!StringUtils.isEmpty(name)){//同上
           sql=sql+" and bkname like ?";
           lists.add("%"+name+"%");
       }
       if(!StringUtils.isEmpty(writer)){
           sql=sql+" and writer like ?";
           lists.add("%"+writer+"%");
       }
       if (!StringUtils.isEmpty(subject)){
           sql=sql+" and subject like ?";
           lists.add("%"+subject+"%");
       }
        try {
            con= DBdao.getConnection();
            ps=con.prepareStatement(sql);
            for(int i=0;i<lists.size();i++){//根据参数的长度逐个取出，再加入到sql语句
                ps.setObject(i+1,lists.get(i));//注意 i+1
            }
            ResultSet re = ps.executeQuery();
            while (re.next()){
                BookMager bk=new BookMager();
                bk.setId(re.getInt(1));
                bk.setBkname(re.getString("bkname"));
                bk.setBkid(re.getString("bkid"));
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
                list.add(bk);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        list.forEach(a-> System.out.println(a));// lambda 表达式，输出所有信息
        return list;
    }
    public List<User> SearchAll(String sql){
        con= DBdao.getConnection();//建立链接
        List<User> list=new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                User use = new User();
                //                use.setId(re.getString("stuid"));
                use.setName(re.getString("name"));
                use.setPass(re.getString("pass"));
                //                use.setClasses(re.getString("classes"));
                use.setPhone(re.getString("phone"));
                use.setSex(re.getString("sex"));
                list.add(use);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
//    @Test
//    public void TestAs(){
//        Books ks=new Books();
//        List<BookMager> fuck=ks.allBook(null,"java",null,null);
//        fuck.forEach(a-> System.out.println(a));
//    }
}
