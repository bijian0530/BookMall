package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //检查验证码是否正确
        if("abcde".equalsIgnoreCase(code)){
            if(userService.existUsername(username)){
                System.out.println("用户名"+username+"已经存在");
                //把回显的信息保存到Request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else {
            System.out.println("验证码"+code+"输入错误");

            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
