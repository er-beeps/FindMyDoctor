package com.deerwalk.controller;

import com.deerwalk.model.User;
import com.deerwalk.service.EmailDispatcher;
import com.deerwalk.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmailDispatcherServlet")
public class EmailDispatcherServlet extends HttpServlet {

    private EmailDispatcher mailSender;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String toEmail = request.getParameter("email");
        String link = "http://localhost:8080/reset?page=resetpassword&email="+toEmail;


       User user  = new UserService().findUserByEmail(toEmail);
       if(user!=null){
           String subject = "Password Reset";
           String message = "Hi " +user.getUname()+ " <br><br>"+
                   "You (or someone pretending to be you) requested that your password be reset." + " <br><br>"+
                   "If you didn't make this request then ignore the email; no changes have been made." + " <br><br>"+
                   "If you did make the request, then click <a href="+link+">Here</a> to reset your password.";


           String fromEmail = "deskforfindmydoc@gmail.com";
           String username = "deskforfindmydoc@gmail.com";
           String password = "Findmydoc@help";

               mailSender = new EmailDispatcher();
               mailSender.sendEmail(fromEmail, username, password, toEmail, subject, message);

               out.print("Mail sent Successfully");
               request.getRequestDispatcher("/login.jsp").forward(request, response);
       }else{
           request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);

       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
