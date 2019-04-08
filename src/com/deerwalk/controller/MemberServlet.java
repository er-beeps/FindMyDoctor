package com.deerwalk.controller;

import com.deerwalk.model.Member;
import com.deerwalk.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MemberServlet")
public class MemberServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("createMember")) {
            request.getRequestDispatcher("/members/createMember.jsp").forward(request, response);



        } else if (page.equalsIgnoreCase("viewMember")) {

            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("uname");

            List<Member> memberList = new MemberService().getAllMembersByUserName(userName);
            request.setAttribute("mlist", memberList);
            request.getRequestDispatcher("/members/viewMember.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("viewMembers")) {

            List<Member> membersList = new MemberService().getAllMembers();
            request.setAttribute("mlist", membersList);
            request.getRequestDispatcher("/members/viewMember.jsp").forward(request, response);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("uname");


        if (page.equalsIgnoreCase("createMember")) {
            String id = request.getParameter("id");
            String memberFirstname = request.getParameter("firstname");
            String memberLastname = request.getParameter("lastname");
            String memberGender = request.getParameter("gender");
            String memberDob = request.getParameter("dateofbirth");
            String memberEmail = request.getParameter("email");
            String memberPhone = request.getParameter("phone");
            String memberAddress = request.getParameter("address");
            String memberProvince = request.getParameter("province");
            String memberZone = request.getParameter("zone");
            String memberDistrict = request.getParameter("district");


            Member member = new Member();
            member.setId(id);
            member.setFirstName(memberFirstname);
            member.setLastName(memberLastname);
            member.setGender(memberGender);
            member.setDob(memberDob);
            member.setEmail(memberEmail);
            member.setPhone(memberPhone);
            member.setAddress(memberAddress);
            member.setProvince(memberProvince);
            member.setZone(memberZone);
            member.setDistrict(memberDistrict);
            member.setUserName(userName);


            boolean isInserted = new MemberService().insertMember(member);
            if (isInserted) {

                List<Member> memberList = new MemberService().getAllMembersByUserName(userName);
                request.setAttribute("mlist", memberList);
                request.getRequestDispatcher("/members/viewMember.jsp").forward(request, response);
            }
            else {
                String errormsg = "The member can't be added !!";
                request.setAttribute("msg", errormsg);
                alreadyExist(request, response);


            }
        }
    }

    protected void alreadyExist(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String errormsg = request.getParameter("msg");
        if (errormsg != null) {
            request.setAttribute("msg", errormsg);
        }
        request.getRequestDispatcher("/members/createMember.jsp").forward(request, response);
    }
}

