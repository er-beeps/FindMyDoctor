package com.deerwalk.controller;

import com.deerwalk.model.User;
import com.deerwalk.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet")
public class UsersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("userList")) {
            List<User> userList = new UserService().getAllUsers();

            request.setAttribute("ulist", userList);
            request.getRequestDispatcher("/listuser.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("deleteUser")) {

            String id = request.getParameter("id");
            new UserService().deleteUserById(id);

            List<User> userList = new UserService().getAllUsers();

            request.setAttribute("ulist", userList);
            request.getRequestDispatcher("/listuser.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
