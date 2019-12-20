package com.controller;

import com.util.Borrow;
import com.util.Decision;
import com.util.Person;
import com.vo.SelfMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/borrowBook")
public class BorrowBook extends HttpServlet {
    Person pson=new Person();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String bkid=req.getParameter("bkid");
        String bkname=req.getParameter("bkname");
        String uid=req.getParameter("uid");
        String flag=req.getParameter("flag");
//        String id=req.getParameter("id");
        Borrow bw=new Borrow();
        System.out.println("借书 uid:"+uid+" ,flag:"+flag);
        HttpSession session=req.getSession();
        int sing=bw.Brow(bkid,bkname,uid);
        List<SelfMessage> list=pson.toMessage(flag,uid);
        session.setAttribute("list",list);
//        req.getRequestDispatcher("/jsp/homepage.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/homepage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String uid=req.getParameter("uid");

    }
}
