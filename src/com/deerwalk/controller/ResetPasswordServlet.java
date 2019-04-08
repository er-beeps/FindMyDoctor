package com.deerwalk.controller;

import com.deerwalk.model.PasswordReset;
import com.deerwalk.service.ResetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("reset")) {
            request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("resetpassword")) {
            String email = request.getParameter("email");
            request.setAttribute("email", email);
            request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String newPass = request.getParameter("newpass");
        String verPass = request.getParameter("verpass");


        if (newPass.equals(null) || newPass == " " || verPass.equals(null) || verPass == " ") {
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ('Please','All fields are mandatory !!','info');");
            out.println("});");
            out.println("</script>");

            request.getRequestDispatcher("resetpassword.jsp").include(request, response);

        } else if (!newPass.equals(verPass)) {

            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ('Oops','Password  does  not match !','warning');");
            out.println("});");
            out.println("</script>");

            request.getRequestDispatcher("resetpassword.jsp").include(request, response);

        } else {
            PasswordReset reset = new PasswordReset();
            reset.setEmail(email);
            reset.setPass(newPass);


            boolean isUpdated = new ResetService().resetPassword(reset);
            if (isUpdated) {

                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal ('Welcome','Password Successfully updated !!','success');");
                out.println("});");
                out.println("</script>");

                request.getRequestDispatcher("login.jsp").include(request, response);


            }
        }
    }
}
