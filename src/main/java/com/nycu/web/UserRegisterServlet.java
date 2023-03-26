package com.nycu.web;

import com.nycu.pojo.User;
import com.nycu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    private UserService userService= new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isAdmin = request.getParameter("isAdmin");

        System.out.println(Boolean.parseBoolean(isAdmin));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAdmin(isAdmin);
        System.out.println(Boolean.parseBoolean(isAdmin));
//        user.setDatetime(Timestamp.);
        boolean flag = userService.register(user);
        if(flag){
            request.setAttribute("register_msg","成功");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","失敗");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }
}
