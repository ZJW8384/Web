package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//配置参数
@WebFilter(filterName = "loginFilter",urlPatterns = {"/admin.jsp"},initParams = {@WebInitParam(name="encoding",value="utf-8"),@WebInitParam(name="loginPage",value="/")})
public class LoginFilter implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;//读取参数
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = config.getInitParameter("encoding");
        String loginPage = config.getInitParameter("loginPage");

        //设置request编码用的字符集
        servletRequest.setCharacterEncoding(encoding);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取客户请求的页面
        String requestPath = request.getServletPath();
        System.out.println("用户请求页面："+requestPath);
        //判断用户是否登录
        HttpSession session = request.getSession();
        //没有登录，且访问页面不是登录也页面
        if(session.getAttribute("user") == null && !requestPath.endsWith(loginPage)){
            //转发到登录页面
            request.getRequestDispatcher("/").forward(servletRequest,servletResponse);
        }else if(session.getAttribute("user") !="1"){//非管理员无法访问admin页面
            request.getRequestDispatcher("/jsp/homepage.jsp").forward(servletRequest,servletResponse);
        }else {
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
