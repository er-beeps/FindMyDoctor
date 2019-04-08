package com.deerwalk.controller;

import com.deerwalk.model.Healthinstitute;
import com.deerwalk.service.HealthinstituteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HealthinstituteServlet")
public class HealthinstituteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("healthinstituteList")) {
            List<Healthinstitute> healthinstituteList = new HealthinstituteService().getAllHealthinstitutes();

            request.setAttribute("hlist", healthinstituteList);
            request.getRequestDispatcher("/healthinstitute/listhi.jsp").forward(request, response);

        } else if (page.equalsIgnoreCase("createHealthinstitute")) {
            request.getRequestDispatcher("createhi.jsp").forward(request, response);

       } else if (page.equalsIgnoreCase("editHealthinstitute")) {
            String id = request.getParameter("id");
          Healthinstitute healthinstitute = new HealthinstituteService().getHealthinstituteById(id);
                request.setAttribute("h", healthinstitute);
                request.getRequestDispatcher("/healthinstitute/edithi.jsp").forward(request, response);

      } else if (page.equalsIgnoreCase("deleteHealthinstitute")) {

           String id = request.getParameter("id");
          new HealthinstituteService().deleteHealthinstituteById(id);

            List<Healthinstitute> healthinstituteList = new HealthinstituteService().getAllHealthinstitutes();

            request.setAttribute("hlist", healthinstituteList);
            request.getRequestDispatcher("/healthinstitute/listhi.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("updateHealthinstitute")) {
            String id = request.getParameter("id");
            String healthinstituteHid = request.getParameter("hid");
            String healthinstituteName = request.getParameter("hname");
            String healthinstituteType = request.getParameter("htype");
            String healthinstituteAddress = request.getParameter("haddress");
            String healthinstitutePhone = request.getParameter("hphone");

            Healthinstitute healthinstitute = new Healthinstitute();
            healthinstitute.setId(Integer.parseInt(id));
            healthinstitute.setHid(healthinstituteHid);
            healthinstitute.setName(healthinstituteName);
            healthinstitute.setType(healthinstituteType);
            healthinstitute.setAddress(healthinstituteAddress);
            healthinstitute.setPhone(healthinstitutePhone);

            boolean isUpdated = new HealthinstituteService().updateHealthinstitute(healthinstitute);
            if (isUpdated) {
                System.out.println("Value updated");

                List<Healthinstitute> healthinstituteList = new HealthinstituteService().getAllHealthinstitutes();

                request.setAttribute("hlist", healthinstituteList);
                request.getRequestDispatcher("/healthinstitute/listhi.jsp").forward(request, response);
            }
        } else if (page.equalsIgnoreCase("createHealthinstitute")) {
            String healthinstituteHid = request.getParameter("hid");
            String healthinstituteName = request.getParameter("hname");
            String healthinstituteType = request.getParameter("htype");
            String healthinstituteAddress = request.getParameter("haddress");
            String healthinstitutePhone = request.getParameter("hphone");

            Healthinstitute healthinstitute = new Healthinstitute();
            healthinstitute.setHid(healthinstituteHid);
            healthinstitute.setName(healthinstituteName);
            healthinstitute.setType(healthinstituteType);
            healthinstitute.setAddress(healthinstituteAddress);
            healthinstitute.setPhone(healthinstitutePhone);

            boolean isInserted = new HealthinstituteService().insertHealthinstitute(healthinstitute);
            if (isInserted) {
                System.out.println("Value inserted");
                List<Healthinstitute> healthinstituteList = new HealthinstituteService().getAllHealthinstitutes();

                request.setAttribute("hlist", healthinstituteList);
                request.getRequestDispatcher("/healthinstitute/listhi.jsp").forward(request, response);
            }
        }
    }
}

