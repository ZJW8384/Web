package com.controller;

import com.util.DBdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/evaluate")
public class Evaluate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uid=req.getParameter("user");
        String bkname=req.getParameter("bkid");
        String meg=req.getParameter("texts");
        String sql="insert into message(uid,bknama,msg) values(?,?,?)";
        DBdao.SQLment(sql,uid,bkname,meg);
//        req.getRequestDispatcher("/jsp/Operation.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/home.jsp");
    }
}
