package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    public boolean insertAppointment(Appointment appointment) {
        boolean isInserted = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "insert into appointment(username,firstname,lastname,gender,dateofbirth,email,phone,address,province,zone,district,healthinstitute,department,atype,selectdoctor,description,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, appointment.getUserName());
            ps.setString(2, appointment.getFirstName());
            ps.setString(3, appointment.getLastName());
            ps.setString(4, appointment.getGender());
            ps.setString(5, appointment.getDob());
            ps.setString(6, appointment.getEmail());
            ps.setString(7, appointment.getPhone());
            ps.setString(8, appointment.getAddress());
            ps.setString(9, appointment.getProvince());
            ps.setString(10, appointment.getZone());
            ps.setString(11, appointment.getDistrict());
            ps.setString(12, appointment.getSelectHealthinstitute());
            ps.setString(13, appointment.getDepartment());
            ps.setString(14, appointment.getAtype());
            ps.setString(15, appointment.getSelectdoctor());
            ps.setString(16, appointment.getDescription());
            ps.setString(17, appointment.getStatus());

            System.out.println("healthinstitute" +appointment.getSelectHealthinstitute());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                isInserted = true;
            } else {
                isInserted = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isInserted;
    }


    public List<Appointment> getAllAppointmentsByUserName(String userName) {
        List<Appointment> appointmentList = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from appointment where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setFirstName(rs.getString("firstname"));
                appointment.setLastName(rs.getString("lastname"));
                appointment.setUserName(rs.getString("username"));
                appointment.setGender(rs.getString("gender"));
                appointment.setDob(rs.getString("dateofbirth"));
                appointment.setEmail(rs.getString("email"));
                appointment.setPhone(rs.getString("phone"));
                appointment.setAddress(rs.getString("address"));
                appointment.setProvince(rs.getString("province"));
                appointment.setZone(rs.getString("zone"));
                appointment.setDistrict(rs.getString("district"));
                appointment.setSelectHealthinstitute(rs.getString("healthinstitute"));
                appointment.setDepartment(rs.getString("department"));
                appointment.setAtype(rs.getString("atype"));
                appointment.setSelectdoctor(rs.getString("selectdoctor"));
                appointment.setDescription(rs.getString("description"));
                appointment.setStatus(rs.getString("status"));

                appointmentList.add(appointment);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return appointmentList;
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointmentsList = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from appointment";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setFirstName(rs.getString("firstname"));
                appointment.setLastName(rs.getString("lastname"));
                appointment.setUserName(rs.getString("username"));
                appointment.setGender(rs.getString("gender"));
                appointment.setDob(rs.getString("dateofbirth"));
                appointment.setEmail(rs.getString("email"));
                appointment.setPhone(rs.getString("phone"));
                appointment.setAddress(rs.getString("address"));
                appointment.setProvince(rs.getString("province"));
                appointment.setZone(rs.getString("zone"));
                appointment.setDistrict(rs.getString("district"));
                appointment.setSelectHealthinstitute(rs.getString("healthinstitute"));
                appointment.setDepartment(rs.getString("department"));
                appointment.setAtype(rs.getString("atype"));
                appointment.setSelectdoctor(rs.getString("selectdoctor"));
                appointment.setDescription(rs.getString("description"));
                appointment.setStatus(rs.getString("status"));

                appointmentsList.add(appointment);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return appointmentsList;
    }

}




