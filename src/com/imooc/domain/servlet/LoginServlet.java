package com.imooc.domain.servlet;

import com.imooc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by TangTian on 2018/7/27.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> list = (List<User>) this.getServletContext().getAttribute("list");
        for (User user:list){
            //判断用户名是否正确
            if (username.equals(user.getUsername())){
                //密码正确
                if(password.equals(user.getPassword())) {
                    //密码也正确，登录成功
                    //判断复选框是否勾选
                    String remember = request.getParameter("remember");
                    if ("true".equals(remember)){
                        //完成记住用户名的功能：
                        Cookie cookie = new Cookie("username",user.getUsername());
                        //设置有效路径和有效时间
                        cookie.setPath("reg_login");
                        //设置有效时间
                        cookie.setMaxAge(60*60*24);
                        //将cookie 回写到浏览器中
                        response.addCookie(cookie);
                        //将用户信息保存在session中
                    }
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("/success.jsp");
                    return;
                }
            }
        }
        //登录失败
        request.setAttribute("msg","用户名或者密码错误");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
