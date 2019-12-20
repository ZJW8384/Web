package com.controller;

import com.dao.GetMessage;
import com.dao.ScheduleDao;
import com.util.DBdao;
import com.vo.Message;
import com.vo.Schedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/scheduleController")
public class ScheduleController extends HttpServlet {
    GetMessage gm=new GetMessage();
    ScheduleDao scd=new ScheduleDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String sql="delete from schedule where id=?";//日程删除
        DBdao.SQLment(sql,id);
        List<Schedule> sdlist=scd.getSchedule();//查看日程
        HttpSession session=req.getSession();
        session.setAttribute("sdlist",sdlist);
//        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/admin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String msg=req.getParameter("msg");
        HttpSession session=req.getSession();
        String sql="insert into schedule(msg) values (?)";//新增日程
        DBdao.SQLment(sql,msg);
        List<Schedule> sdlist=scd.getSchedule();//查看日程
        session.setAttribute("sdlist",sdlist);
//        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/admin.jsp");
    }
}
