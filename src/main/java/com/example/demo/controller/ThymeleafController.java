package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.MessageFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    /**
     * @author gacl
     * 获取客户端通过Form表单提交上来的参数
     */

    public class ThymeleafController extends HttpServlet {

        /**
         * 会传用户名，通过dopost返回密码，controller类不做判断(如果用户名不存在返回-1)
         */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            //客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
            request.setCharacterEncoding("UTF-8");

            /**
             * 用户名(文本框)：<input type="text" name="username" value="请输入用户名">
             */
            String username = request.getParameter("username");//获取填写的用户名
            /**
             * 密&nbsp;&nbsp;码(密码框)：<input type="password" name="userpass" value="请输入密码">
             */
           // String userpass = request.getParameter("userpass");//获取填写的密码
        }


        @RequestMapping(value = "/demo/doPost")
        public String doPost(HttpServletRequest request,int password){

            request.setAttribute("password",password);   //sta标记登录是否成功

            return "IoMain";
        }
    }

