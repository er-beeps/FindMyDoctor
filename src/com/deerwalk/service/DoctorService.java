package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    public boolean insertDoctor(Doctor doctor) {
        boolean isInserted = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "insert into doctor(nmc_code,first_name,last_name,speciality,degree,passed_year) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getNmcCode());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpeciality());
            ps.setString(5, doctor.getDegree());
            ps.setString(6, doctor.getPassedYear());


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


    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from doctor";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Doctor doctor = new Doctor();
                doctor.setId(Integer.parseInt(rs.getString("id")));
                doctor.setNmcCode(rs.getString("nmc_code"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setSpeciality(rs.getString("speciality"));
                doctor.setDegree(rs.getString("degree"));
                doctor.setPassedYear(rs.getString("passed_year"));

                doctorList.add(doctor);
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
        return doctorList;
    }

    public static List<Doctor> list() {
        List<Doctor> doctorlist = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select first_name,last_name from doctor";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));

                doctorlist.add(doctor);
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
        return doctorlist;
    }


    public Doctor getDoctorById(String id) {
        Doctor doctor = null;

        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from doctor where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setNmcCode(rs.getString("nmc_code"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setSpeciality(rs.getString("speciality"));
                doctor.setDegree(rs.getString("degree"));
                doctor.setPassedYear(rs.getString("passed_year"));
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
        return doctor;
    }


    public void deleteDoctorById(String id) {
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "Delete from doctor where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public boolean updateDoctor(Doctor doctor) {
        boolean isUpdated = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "UPDATE  doctor set nmc_code=?,first_name=?,last_name=?,speciality=?,degree=?,passed_year=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getNmcCode());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpeciality());
            ps.setString(5, doctor.getDegree());
            ps.setString(6, doctor.getPassedYear());
            ps.setInt(7, doctor.getId());


            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
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
        return isUpdated;
    }

    public List<Doctor> getDoctorByNmcCode(String nmcCode) {
        List<Doctor> doctorschedule = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from schedule where nmc_code=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nmcCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setNmcCode(rs.getString("nmc_code"));
                doctor.setDocName(rs.getString("doctor_name"));
                doctor.setHiId(rs.getString("healthinstitute_id"));
                doctor.setHiName(rs.getString("healthinstitute_name"));
                doctor.setHiType(rs.getString("healthinstitute_type"));
                doctor.setDay(rs.getString("sday"));
                doctor.setStartTime(rs.getString("start_time"));
                doctor.setEndTime(rs.getString("end_time"));

                doctorschedule.add(doctor);

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
        return doctorschedule;
    }
}



