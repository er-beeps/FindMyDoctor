package com.deerwalk.controller;

import com.deerwalk.loginvalidate.Validate;
import com.deerwalk.model.Role;
import com.deerwalk.model.User;
import com.deerwalk.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("login")) {

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String userUname = request.getParameter("uname");
            String userPass = request.getParameter("pass");

            User user = Validate.checkUser(userUname, userPass);

            if (user != null) {
                Role role = new UserService().getUserRoleById(user.getId());

                HttpSession session = request.getSession();
                session.setAttribute("uname", userUname);
                session.setAttribute("pass", userPass);
                session.setAttribute("role", role.getAuthority());

                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Sorry, your Username or password is incorrect !!!');");
                out.println("location='login.jsp';");
                out.println("</script>");

            }
        }
        }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String page=request.getParameter("page");
        if(page.equalsIgnoreCase("login")){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

        }

        }
