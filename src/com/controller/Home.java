package com.controller;

import com.dao.BookSearch;
import com.vo.BookMager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {
    BookSearch bsh=new BookSearch();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookMager> list=bsh.Public("select * from book");//所有书
        HttpSession session=req.getSession();
        session.setAttribute("list",list);
        req.setAttribute("list",list);
        req.getRequestDispatcher("jsp/success.jsp").forward(req,resp);
//        resp.sendRedirect("/jsp/homepage.jsp");
    }
}
