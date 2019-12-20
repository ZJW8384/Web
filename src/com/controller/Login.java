package com.controller;

import com.dao.*;
import com.google.gson.Gson;
import com.util.Balance;
import com.vo.User;
import com.dao.UserDao;
import com.util.Person;
import com.vo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 2L;
    UserDao userdo=new UserDao();
    Person pson=new Person();
    BookSearch bsh=new BookSearch();
    TeacherDao td=new TeacherDao();
    StudentDao sd=new StudentDao();
    Books ks=new Books();
    GetMessage gm=new GetMessage();
    ScheduleDao scd=new ScheduleDao();
    Balance balance=new Balance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Gson gson=new Gson();
        String name=req.getParameter("user");
        String pass=req.getParameter("pass");
        System.out.println(name);
        PrintWriter out=resp.getWriter();
        List<User> lists = userdo.Search(name, pass);
        String str=gson.toJson(lists);
        out.print(str);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String name=req.getParameter("user");
        String pass=req.getParameter("pass");
        List<BookMager> lista=bsh.Public("select * from book");//所有图书
        HttpSession session=req.getSession();
        List<User> lists = userdo.Search(name, pass);//用户登入信息
        String flags=lists.get(0).getFlag();
        String uid=lists.get(0).getId();
        List<SelfMessage> list=pson.toMessage(flags,uid);//个人借书信息
        List<Student> slist=sd.StuMessage();//获取学生信息
        List<Teacher> tlist=td.TerMessage();//获取老师信息
        List<Message> mlist=gm.getMessage();//获取留言
        List<Schedule> sdlist=scd.getSchedule();//查看日程
        String username=lists.get(0).getFlag();//获取用户标识
        String uer=lists.get(0).getId();//获取用户账号
        String fff=balance.getMoneys(username,uid);//获取账户余额
        String money;
        if(slist.get(0).getBalance()!=null){
            money=slist.get(0).getBalance();
        }else {
            money=tlist.get(0).getBalance();
        }
        //返回给前端用于身份验证等
        session.setAttribute("list2",lista);
        session.setAttribute("list",list);
        session.setAttribute("user",username);
        session.setAttribute("uid",uer);
        session.setAttribute("money",money);
        session.setAttribute("fff",fff);
        try{
            //获取身份标识
            String flag=lists.get(0).getFlag();
            session.setAttribute("flag",flag);
            if(flag.equals("3")||flag.equals("2")){
                //普通用户登入
                req.getRequestDispatcher("jsp/homepage.jsp").forward(req,resp);
            }else if(flag.equals("1")){//管理员登入
                session.setAttribute("slist",slist);
                session.setAttribute("tlist",tlist);
                session.setAttribute("mlist",mlist);
                session.setAttribute("sdlist",sdlist);
                req.getRequestDispatcher("jsp/admin.jsp").forward(req,resp);
            }else {
                resp.sendRedirect("index.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("index.jsp");
        }
        }
    }
