package com.deerwalk.controller;

import com.deerwalk.model.Doctor;
import com.deerwalk.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DoctorServlet")
public class DoctorServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("doctorList")) {
            List<Doctor> doctorList = new DoctorService().getAllDoctors();

            request.setAttribute("dlist", doctorList);
            request.getRequestDispatcher("/doctor/listdoc.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("createDoctor")) {

            request.getRequestDispatcher("createdoc.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("editDoctor")) {
            String id = request.getParameter("id");
            Doctor doctor = new DoctorService().getDoctorById(id);
            request.setAttribute("d", doctor);
            request.getRequestDispatcher("/doctor/editdoc.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("doctorSchedule")) {

            String nmcCode = request.getParameter("nmcCode");
            List<Doctor> doctorschedule = new DoctorService().getDoctorByNmcCode(nmcCode);
            if (doctorschedule.size() > 0) {
                request.setAttribute("dslist", doctorschedule);
                request.setAttribute("dname", doctorschedule.get(0).getDocName());
                request.getRequestDispatcher("/doctor/docschedule.jsp").forward(request, response);
            } else {
                System.out.println("No schedule for the doctor");
                request.getRequestDispatcher("/doctor/docschedule.jsp").forward(request, response);
            }

        } else if (page.equalsIgnoreCase("deleteDoctor")) {

            String id = request.getParameter("id");
            new DoctorService().deleteDoctorById(id);

            List<Doctor> doctorList = new DoctorService().getAllDoctors();

            request.setAttribute("dlist", doctorList);
            request.getRequestDispatcher("/doctor/listdoc.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("updateDoctor")) {
            String doctorNmccode, doctorFname, doctorLname, doctorSpeciality, doctorDegree, doctorPassedyear;
            String id = request.getParameter("id");
            doctorNmccode = request.getParameter("nmcCode");
            doctorFname = request.getParameter("firstName");
            doctorLname = request.getParameter("lastName");
            doctorSpeciality = request.getParameter("speciality");
            doctorDegree = request.getParameter("degree");
            doctorPassedyear = request.getParameter("passedYear");


            Doctor doctor = new Doctor();
            doctor.setId(Integer.parseInt(id));
            doctor.setNmcCode(doctorNmccode);
            doctor.setFirstName(doctorFname);
            doctor.setLastName(doctorLname);
            doctor.setSpeciality(doctorSpeciality);
            doctor.setDegree(doctorDegree);
            doctor.setPassedYear(doctorPassedyear);

            boolean isUpdated = new DoctorService().updateDoctor(doctor);
            if (isUpdated) {
                System.out.println("Value updated");

                List<Doctor> doctorList = new DoctorService().getAllDoctors();

                request.setAttribute("dlist", doctorList);
                request.getRequestDispatcher("/doctor/listdoc.jsp").forward(request, response);
            }
        } else if (page.equalsIgnoreCase("createDoctor")) {
            String doctorNmccode, doctorFname, doctorLname, doctorSpeciality, doctorDegree, doctorPassedyear;
            doctorNmccode = request.getParameter("nmcCode");
            doctorFname = request.getParameter("firstName");
            doctorLname = request.getParameter("lastName");
            doctorSpeciality = request.getParameter("speciality");
            doctorDegree = request.getParameter("degree");
            doctorPassedyear = request.getParameter("passedYear");


            Doctor doctor = new Doctor();
            doctor.setNmcCode(doctorNmccode);
            doctor.setFirstName(doctorFname);
            doctor.setLastName(doctorLname);
            doctor.setSpeciality(doctorSpeciality);
            doctor.setDegree(doctorDegree);
            doctor.setPassedYear(doctorPassedyear);

            boolean isInserted = new DoctorService().insertDoctor(doctor);
            if (isInserted) {
                System.out.println("Value inserted");

                List<Doctor> doctorList = new DoctorService().getAllDoctors();

                request.setAttribute("dlist", doctorList);
                request.getRequestDispatcher("/doctor/listdoc.jsp").forward(request, response);
            }
        }
    }
}