package com.imooc.domain.servlet;

import com.imooc.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TangTian on 2018/7/26.
 */
@WebServlet(name = "InitServlet")
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 创建一个List集合用于保存用户注册的信息:
        List<User> list = new ArrayList<User>();
        // 将list保存到ServletContext作用域中:
        this.getServletContext().setAttribute("list", list);
    }
}
