package com.deerwalk.controller;

import com.deerwalk.StaticFile;
import com.deerwalk.model.*;
import com.deerwalk.service.*;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("setAppointment")) {
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("uname");

            List<Doctor> doctorlist = DoctorService.list();
            request.setAttribute("doctorlist", doctorlist);

            List<Healthinstitute> healthinstitutelist = HealthinstituteService.list();
            request.setAttribute("healthinstitutelist", healthinstitutelist);

            List<Member> memberList = new MemberService().getAllMembersByUserName(userName);
            request.setAttribute("mlist", memberList);

            request.getRequestDispatcher("/appointment/setappointment.jsp").forward(request, response);

        }else if (page.equalsIgnoreCase("setmyAppointment")) {
            String id = request.getParameter("id");
            Schedule schedule = new ScheduleService().getScheduleById(id);
            request.setAttribute("s",schedule);

            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("uname");
            System.out.println("user name:  " +userName);
             User user = new UserService().getUserByUserName(userName);
            request.setAttribute("u", user);

            List<Member> memberList = new MemberService().getAllMembersByUserName(userName);
            request.setAttribute("mylist", memberList);

            request.getRequestDispatcher("/appointment/setmyappointment.jsp").forward(request, response);



        } else if (page.equalsIgnoreCase("viewAppointment")) {

            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("uname");

            List<Appointment> appointmentList = new AppointmentService().getAllAppointmentsByUserName(userName);
            request.setAttribute("alist", appointmentList);
            request.getRequestDispatcher("/appointment/viewappointment.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("viewAppointments")) {

            List<Appointment> appointmentsList = new AppointmentService().getAllAppointments();
            request.setAttribute("alist", appointmentsList);
            request.getRequestDispatcher("/appointment/viewappointment.jsp").forward(request, response);
        }
        else if (page.equalsIgnoreCase("getMember")){
            String id = request.getParameter("val");
            Member member=new MemberService().getMemberById(Integer.parseInt(id));
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            PrintWriter out = response.getWriter();

            //create Json Object
            JSONObject json = new JSONObject();
            try {
                json.put("fname",member.getFirstName());
                json.put("lname",member.getLastName());
                json.put("gender",member.getGender());
                json.put("dob",member.getDob());
                json.put("email",member.getEmail());
                json.put("phone",member.getPhone());
                json.put("address",member.getAddress());
                json.put("province",member.getProvince());
                json.put("zone",member.getZone());
                json.put("district",member.getDistrict());
                System.out.println("json.toString() = " + json.toString());
                out.print(json.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("uname");


        if (page.equalsIgnoreCase("setAppointment")||(page.equalsIgnoreCase("setmyAppointment"))) {
            String id = request.getParameter("id");
            String appointmentFirstname = request.getParameter("firstname");
            String appointmentLastname = request.getParameter("lastname");
            String appointmentGender = request.getParameter("gender");
            String appointmentDob = request.getParameter("dateofbirth");
            String appointmentEmail = request.getParameter("email");
            String appointmentPhone = request.getParameter("phone");
            String appointmentAddress = request.getParameter("address");
            String appointmentProvince = request.getParameter("province");
            String appointmentZone = request.getParameter("zone");
            String appointmentDistrict = request.getParameter("district");
            String appointmentSelecthealthinstitute = request.getParameter("selecthealthinstitute");
            String appointmentDepartment = request.getParameter("department");
            String appointmentAtype = request.getParameter("atype");
            String appointmentSelectdoctor = request.getParameter("selectdoctor");
            String appointmentDescription = request.getParameter("description");


            Appointment appointment = new Appointment();
            appointment.setId(id);
            appointment.setFirstName(appointmentFirstname);
            appointment.setLastName(appointmentLastname);
            appointment.setGender(appointmentGender);
            appointment.setDob(appointmentDob);
            appointment.setEmail(appointmentEmail);
            appointment.setPhone(appointmentPhone);
            appointment.setAddress(appointmentAddress);
            appointment.setProvince(appointmentProvince);
            appointment.setZone(appointmentZone);
            appointment.setSelectHealthinstitute(appointmentSelecthealthinstitute);
            appointment.setDistrict(appointmentDistrict);
            appointment.setDepartment(appointmentDepartment);
            appointment.setAtype(appointmentAtype);
            appointment.setSelectdoctor(appointmentSelectdoctor);
            appointment.setDescription(appointmentDescription);
            appointment.setStatus(StaticFile.Status.PENDING);
            appointment.setUserName(userName);


            boolean isInserted = new AppointmentService().insertAppointment(appointment);
            if (isInserted) {

                List<Appointment> appointmentList = new AppointmentService().getAllAppointmentsByUserName(userName);
                request.setAttribute("alist", appointmentList);
                request.getRequestDispatcher("/appointment/viewappointment.jsp").forward(request, response);

            } else {
                String errormsg = "The appointment request is not successfull !!";
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
        request.getRequestDispatcher("/appointment/setappointment.jsp").forward(request, response);
    }
}

