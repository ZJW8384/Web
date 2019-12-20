package com.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.util.PwdController;


@WebServlet("/upDataPass")
public class UpDataPass extends HttpServlet {
    PwdController uppass=new PwdController();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("user");
        String pass=req.getParameter("pass");
        uppass.Uppass(name,pass);//更改密码
        resp.sendRedirect("index.jsp");//返回登入页面
    }

}
