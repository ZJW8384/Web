package com.controller;

import com.util.DBdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delMessage")
public class DelMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String sql="delete from message where id=?";
        System.out.println(id);
        DBdao.SQLment(sql,id);
//        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/admin.jsp");
    }
}
