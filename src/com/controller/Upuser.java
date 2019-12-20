package com.controller;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.util.DBdao;
import com.util.FindUser;
import com.vo.Student;
import com.vo.Teacher;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/upuser")
public class Upuser extends HttpServlet {
    FindUser fd=new FindUser();
    TeacherDao td=new TeacherDao();
    StudentDao sd=new StudentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid=req.getParameter("tid");
        String sid=req.getParameter("sid");
        List<Student> slist;
        HttpSession session=req.getSession();
        if(sid!=null){
            slist=fd.findStudent(sid);//获取学生个人信息
            session.setAttribute("listff",slist);
            req.getRequestDispatcher("/jsp/alterStudent.jsp").forward(req,resp);
        }
        if(tid!=null){
            List<Teacher> tlist=fd.findTeacher(tid);//教师个人信息
            session.setAttribute("listff",tlist);
            req.getRequestDispatcher("/jsp/alterTeacher.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id=req.getParameter("id");
        req.setCharacterEncoding("utf-8");
        String uid=req.getParameter("uid");
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        String age=req.getParameter("age");
        String sex=req.getParameter("sex");
        String units=req.getParameter("units");
        String classes=req.getParameter("classes");
        String phone=req.getParameter("phone");
        HttpSession session=req.getSession();
        if(!StringUtils.isEmpty(classes)){//判断班级是否为空，教师没有班级
            String sql="update student set name=?,pass=?,age=?,sex=?,units=?,class=?,phone=? where sid=?";
            DBdao.SQLment(sql,name,pass,age,sex,units,classes,phone,uid);
            List<Student> slist=sd.StuMessage();//获取学生信息
            session.setAttribute("slist",slist);
        }else{
            String sql="update teacher set name=?,pass=?,age=?,sex=?,units=?,phone=? where tid=?";
            DBdao.SQLment(sql,name,pass,age,sex,units,phone,uid);
            List<Teacher> tlist=td.TerMessage();//获取老师信息
            session.setAttribute("tlist",tlist);
        }
//        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/admin.jsp");
    }
}
