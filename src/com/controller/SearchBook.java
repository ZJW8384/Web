package com.controller;

import com.dao.Books;
import com.google.gson.Gson;
import com.dao.UserDao;
import com.dao.BookSearch;
import com.util.Decision;
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
@WebServlet("/search")
public class SearchBook extends HttpServlet {
    UserDao userdo=new UserDao();
    BookSearch bsh=new BookSearch();
    Decision ds=new Decision();
    Gson gson=new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String uid=req.getParameter("uid");
        int a=Integer.parseInt(id);//不必转换也可以
        List<BookMager> list=bsh.Public("select * from book where id='"+a+"'");
        HttpSession session=req.getSession();
        int less=ds.bookMax(uid);//借书数量
        int number=ds.bookNumber(id);
        session.setAttribute("list2",list);
        session.setAttribute("less",less);
        session.setAttribute("number",number);
        req.getRequestDispatcher("/jsp/Operation.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");//  text/html 关键代码，解决返回值乱码！！！
        resp.setContentType("application/json;charset=utf-8");//注意UTF-8和utf-8的区别
        String bkname=req.getParameter("bookname");
        String writer=req.getParameter("writer");
        String indexs=req.getParameter("indexs");
        String subject=req.getParameter("subject");
        PrintWriter out=resp.getWriter();
        Books ks=new Books();
        List<BookMager> books=ks.allBook(indexs,bkname,writer,subject);//查询图书
        String list=gson.toJson(books);
        HttpSession session=req.getSession();
        session.setAttribute("books",books);
        out.print(list);
//        req.getRequestDispatcher("/jsp/inline.jsp").forward(req,resp);
    }

}
