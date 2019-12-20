package com.controller;

import com.dao.BookSearch;
import com.dao.UpdeBooks;
import com.vo.BookMager;
import org.hamcrest.core.Is;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/upBook")
public class UpBook extends HttpServlet {
    UpdeBooks ub=new UpdeBooks();
    BookSearch bsh=new BookSearch();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bkid=req.getParameter("bkid");
        ub.DeleteBook(bkid);
        String id=req.getParameter("id");
//        List<BookMager> list=bsh.Public("select * from book where id='"+id+"'");
        HttpSession session=req.getSession();
        List<BookMager> lista=bsh.Public("select * from book");//所有图书
        session.setAttribute("list2",lista);
//        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/Operation.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
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
        String number=req.getParameter("number");//每次都重新插入，图书id不变
        ub.DOup(bkid,bkname, ISBN,price,writer,subject,press,language,place,date,indexs,classify,number);
        String id=req.getParameter("id");
        int a=Integer.parseInt(id);
        List<BookMager> list=bsh.Public("select * from book where id='"+a+"'");
        HttpSession session=req.getSession();
        session.setAttribute("list2",list);
//        req.getRequestDispatcher("/jsp/Operation.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/Operation.jsp");
    }
}
