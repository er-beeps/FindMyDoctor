package com.deerwalk.controller;

import com.deerwalk.model.PasswordChange;
import com.deerwalk.model.PasswordChange;
import com.deerwalk.service.ChangeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("changepassword.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String oldPass = request.getParameter("oldpass");
        String newPass = request.getParameter("newpass");
        String verPass = request.getParameter("verpass");

        HttpSession session = request.getSession();
        String currentPass = (String) session.getAttribute("pass");
        String userName = (String) session.getAttribute("uname");

        if (oldPass.equals(null)||oldPass ==""||newPass.equals(null)||newPass ==""||verPass.equals(null)||verPass =="")
        {
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ('Please','All fields are mandatory !!','info');");
            out.println("});");
            out.println("</script>");

            request.getRequestDispatcher("/changepassword.jsp").include(request, response);

        } else if (!newPass.equals(verPass)) {

            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ('Oops','Password  does  not match !','warning');");
            out.println("});");
            out.println("</script>");
            request.getRequestDispatcher("/changepassword.jsp").include(request, response);

        } else if (!currentPass.equals(oldPass)) {
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ('Oops','Old password is not corrrect !!','warning');");
            out.println("});");
            out.println("</script>");

            request.getRequestDispatcher("/changepassword.jsp").include(request, response);

        } else {
            PasswordChange change = new PasswordChange();
            change.setName(userName);
            change.setPass(newPass);

            boolean isUpdated = new ChangeService().changePassword(change);
            if (isUpdated) {

                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal ('Welcome','Password Successfully updated !!','success');");
                out.println("});");
                out.println("</script>");

                request.getRequestDispatcher("dashboard.jsp").include(request, response);

            }
        }

    }
}
