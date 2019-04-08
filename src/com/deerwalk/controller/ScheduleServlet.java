package com.deerwalk.controller;

import com.deerwalk.model.Doctor;
import com.deerwalk.model.Healthinstitute;
import com.deerwalk.model.Schedule;
import com.deerwalk.service.DoctorService;
import com.deerwalk.service.HealthinstituteService;
import com.deerwalk.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if(page.equalsIgnoreCase("scheduleList")){
            List<Schedule> scheduleList = new ScheduleService().getAllSchedule();
            request.setAttribute("slist", scheduleList);

            List<Doctor> doctorlist = DoctorService.list();
            request.setAttribute("doctorlist", doctorlist);

            List<Healthinstitute> healthinstitutelist = HealthinstituteService.list();
            request.setAttribute("healthinstitutelist", healthinstitutelist);

            request.getRequestDispatcher("/schedule/listschedule.jsp").forward(request, response);

        }else if(page.equalsIgnoreCase("createSchedule")){
            request.getRequestDispatcher("createschedule.jsp").forward(request, response);

        }else if(page.equalsIgnoreCase("editSchedule")){
            String id = request.getParameter("id");
            Schedule schedule = new ScheduleService().getScheduleById(id);
            request.setAttribute("s",schedule);
            request.getRequestDispatcher("/schedule/editschedule.jsp").forward(request, response);

        }else if(page.equalsIgnoreCase("deleteSchedule")){

            String id = request.getParameter("id");
            new ScheduleService().deleteScheduleById(id);

            List<Schedule> scheduleList = new ScheduleService().getAllSchedule();

            request.setAttribute("slist", scheduleList);
            request.getRequestDispatcher("/schedule/listschedule.jsp").forward(request, response);
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if(page.equalsIgnoreCase("updateSchedule")){
            String id = request.getParameter("id");
        String scheduleNmccode=request.getParameter("nmccode");
        String scheduleDocname=request.getParameter("docname");
        String scheduleHid=request.getParameter("hid");
        String scheduleHname=request.getParameter("hname");
        String scheduleHtype=request.getParameter("htype");
        String scheduleDay=request.getParameter("day");
        String scheduleStarttime=request.getParameter("starttime");
        String scheduleEndtime=request.getParameter("endtime");

        Schedule schedule = new Schedule();
        schedule.setId(Integer.parseInt(id));
        schedule.setNmcCode(scheduleNmccode);
        schedule.setDocName(scheduleDocname);
        schedule.setHiId(scheduleHid);
        schedule.setHiName(scheduleHname);
        schedule.setHiType(scheduleHtype);
        schedule.setDay(scheduleDay);
        schedule.setStartTime(scheduleStarttime);
        schedule.setEndTime(scheduleEndtime);

        boolean isUpdated = new ScheduleService().updateSchedule(schedule);
        if (isUpdated) {
            System.out.println("Value updated");
            List<Schedule> scheduleList = new ScheduleService().getAllSchedule();

            request.setAttribute("slist", scheduleList);
            request.getRequestDispatcher("/schedule/listschedule.jsp").forward(request, response);
        }
        }else if(page.equalsIgnoreCase("createSchedule")) {
            String scheduleNmccode=request.getParameter("nmccode");
            String scheduleDocname=request.getParameter("docname");
            String scheduleHid=request.getParameter("hid");
            String scheduleHname=request.getParameter("hname");
            String scheduleHtype=request.getParameter("htype");
            String scheduleDay=request.getParameter("day");
            String scheduleStarttime=request.getParameter("starttime");
            String scheduleEndtime=request.getParameter("endtime");

            Schedule schedule = new Schedule();
            schedule.setNmcCode(scheduleNmccode);
            schedule.setDocName(scheduleDocname);
            schedule.setHiId(scheduleHid);
            schedule.setHiName(scheduleHname);
            schedule.setHiType(scheduleHtype);
            schedule.setDay(scheduleDay);
            schedule.setStartTime(scheduleStarttime);
            schedule.setEndTime(scheduleEndtime);
            boolean isInserted = new ScheduleService().insertSchedule(schedule);
            if (isInserted) {
                System.out.println("Value inserted");
                List<Schedule> scheduleList = new ScheduleService().getAllSchedule();

                request.setAttribute("slist", scheduleList);
                request.getRequestDispatcher("/schedule/listschedule.jsp").forward(request, response);
            }
        }
    }
}
