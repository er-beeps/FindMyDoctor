package com.deerwalk.controller;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.User;
import com.deerwalk.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("register")) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userFname,userLname,userUname,userPass,userEmail,userPhone;
        userFname=request.getParameter("fname");
        userLname=request.getParameter("lname");
        userUname=request.getParameter("uname");
        userPass=request.getParameter("pass");
        userEmail=request.getParameter("email");
        userPhone=request.getParameter("phone");

        User user = new User();
        user.setFname(userFname);
        user.setLname(userLname);
        user.setUname(userUname);
        user.setPassword(userPass);
        user.setEmail(userEmail);
        user.setPhone(userPhone);



        boolean isInserted = new UserService().insertUser(user);
        if(isInserted){
            System.out.println("Value inserted");

            response.sendRedirect("dashboard.jsp");

        }else{
            System.out.println("Error");
            String errormsg = "The Username,E-mail or Phone you provide is already in use. Please enter the unique username, e-mail and phone number.";
            request.setAttribute("msg",errormsg);
            alreadyExist(request,response);
        }

    }

    protected void alreadyExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errormsg = request.getParameter("msg");
        if(errormsg!=null){
            request.setAttribute("msg",errormsg);
        }
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
}
