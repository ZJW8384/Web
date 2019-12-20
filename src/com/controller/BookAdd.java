package com.controller;

import com.dao.BookSearch;
import com.util.DBdao;
import com.vo.BookMager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/bookAdd")
public class BookAdd extends HttpServlet {
    BookSearch bsh=new BookSearch();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String bkid=req.getParameter("bkid");
        String bkname=req.getParameter("bkname");
        String ISBN=req.getParameter("ISBN");
        String price=req.getParameter("price");
        String writer=req.getParameter("writer");
        String subject=req.getParameter("subject");
        String press=req.getParameter("press");
        String language=req.getParameter("language");
        String place=req.getParameter("place");
        String date=req.getParameter("date");
        String indexs=req.getParameter("indexs");
        String classify=req.getParameter("classify");
        String type=req.getParameter("type");
        String barcode=req.getParameter("barcode");
        String collection=req.getParameter("collection");
        String collections=req.getParameter("collections");
        String number=req.getParameter("number");
        String sql="insert into book(bkid,bkname,ISBN,price,writer,press,language,subject,place,date,indexs,classify,type," +
                "barcode,collection,collections,number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int a=DBdao.SQLment(sql,bkid,bkname,ISBN,price,writer,press,language,subject,place,date,indexs,classify,type,barcode,collection,collections,number);
        List<BookMager> lista=bsh.Public("select * from book");//所有图书
        HttpSession session=req.getSession();
        session.setAttribute("list2",lista);
        PrintWriter out=resp.getWriter();
        out.print(a);
    }
}
