package com.controller;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.google.gson.Gson;
import com.util.BKbook;
import com.util.Balance;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/backBook")
public class BackBook extends HttpServlet {

    TeacherDao td=new TeacherDao();
    StudentDao sd=new StudentDao();
    Person pson=new Person();
    BKbook bKbook=new BKbook();
    Balance balance=new Balance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String id =req.getParameter("id");
        String uid=req.getParameter("uid");
        String flag=req.getParameter("flag");
        System.out.println(uid+"   "+flag);
        String fff=balance.getMoneys(flag,uid);
        HttpSession session=req.getSession();
        session.setAttribute("fff",fff);
//        System.out.println("还书 uid:"+uid+" ,flag:"+flag);
//        List<Object>mes=bKbook.Bkbook(id,uid);
//        HttpSession session=req.getSession();
//        List<SelfMessage> list=pson.toMessage(flag,uid);
//        String money=balance.getMoneys(flag,uid);
//        session.setAttribute("money",money);
//        try{
//            session.setAttribute("time",mes.get(0));
//            session.setAttribute("subm",mes.get(1));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        session.setAttribute("list",list);
//        req.getRequestDispatcher("/jsp/homepage.jsp").forward(req,resp);
        resp.sendRedirect("/jsp/homepage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
//        resp.setContentType("application/json;charset=utf-8");
        String id[]=req.getParameterValues("id");
        String ids =req.getParameter("id");
        String uid=req.getParameter("uid");
        String flag=req.getParameter("flag");
        HttpSession session=req.getSession();
        Gson gson=new Gson();
        List<Object> fuck=new ArrayList<>();
        try{
            for (int i=0;i<id.length;i++){
                List<Object>mes=bKbook.Bkbook(id[i],uid);//获取图书id
                session.setAttribute("time",mes.get(0));
                session.setAttribute("subm",mes.get(1));
                fuck.add(mes.get(0));
                fuck.add(mes.get(1));
            }
            String str=gson.toJson(fuck);//转换成json类型
            PrintWriter out=resp.getWriter();
            List<SelfMessage> list=pson.toMessage(flag,uid);//获取个人借书信息
            session.setAttribute("list",list);
            String money=balance.getMoneys(flag,uid);
            session.setAttribute("money",money);
            out.write(str);//返回给Ajax的success方法中的data
        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("/jsp/homepage.jsp").forward(req,resp);
        }
//        req.getRequestDispatcher("/jsp/homepage.jsp").forward(req,resp);//容易泄露数据，导致表单重复提交
        resp.sendRedirect("/jsp/homepage.jsp");
        }


}
