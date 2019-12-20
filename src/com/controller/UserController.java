package com.controller;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.util.DBdao;
import com.vo.Student;
import com.vo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/userController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 2L;

    TeacherDao td=new TeacherDao();
    StudentDao sd=new StudentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid=req.getParameter("tid");
        String sid=req.getParameter("sid");
        String sql="delete from user where uid=?";
        String sql2="delete from teacher where id=?";
        String sql3="delete from user where uid=?";
        if(sid!=null){
            DBdao.SQLment(sql,sid);//删除学生，学id是登入表uid的外键
        }
        if(tid!=null){
            DBdao.SQLment(sql3,tid);//删除教师表的信息
            DBdao.SQLment(sql2,tid);//删除登入表的信息
        }
        List<Student> slist=sd.StuMessage();//更新数据
        List<Teacher> tlist=td.TerMessage();
        HttpSession session=req.getSession();
        session.setAttribute("tlist",tlist);
        session.setAttribute("slist",slist);
//        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/admin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String user=req.getParameter("user");
        String pass=req.getParameter("pass");
        String name=req.getParameter("name");
        String age=req.getParameter("age");
        String sex=req.getParameter("sex");
        String units=req.getParameter("units");
        String classes=req.getParameter("class");
        String phone=req.getParameter("phone");
        String flag=req.getParameter("flag");
        try {
            DBdao.Transaction(user,name,pass,age,sex,units,classes,phone,flag);//新增用户
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Student> slist=sd.StuMessage();
        List<Teacher> tlist=td.TerMessage();
        HttpSession session=req.getSession();
        session.setAttribute("tlist",tlist);
        session.setAttribute("slist",slist);
        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        //String sid,String name,String pass,String age,String sex,String units,String classes,String phone,String flag
    }
}
