package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.Doctor;
import com.deerwalk.model.Healthinstitute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HealthinstituteService {

    public boolean insertHealthinstitute(Healthinstitute healthinstitute) {
        boolean isInserted = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "insert into healthinstitute(healthinstitute_id,healthinstitute_name,htype,address,phone) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, healthinstitute.getHid());
            ps.setString(2, healthinstitute.getName());
            ps.setString(3, healthinstitute.getType());
            ps.setString(4, healthinstitute.getAddress());
            ps.setString(5, healthinstitute.getPhone());

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


    public List<Healthinstitute> getAllHealthinstitutes() {
        List<Healthinstitute> healthinstituteList = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from healthinstitute";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Healthinstitute healthinstitute = new Healthinstitute();
                healthinstitute.setId(Integer.parseInt(rs.getString("id")));
                healthinstitute.setHid(rs.getString("healthinstitute_id"));
                healthinstitute.setName(rs.getString("healthinstitute_name"));
                healthinstitute.setType(rs.getString("htype"));
                healthinstitute.setAddress(rs.getString("address"));
                healthinstitute.setPhone(rs.getString("phone"));


                healthinstituteList.add(healthinstitute);
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

        return healthinstituteList;
    }

    public static List<Healthinstitute> list() {
        List<Healthinstitute> healthinstitutelist = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select healthinstitute_name from healthinstitute";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Healthinstitute healthinstitute = new Healthinstitute();
                healthinstitute.setName(rs.getString("healthinstitute_name"));

                healthinstitutelist.add(healthinstitute);
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

        return healthinstitutelist;
    }


    public Healthinstitute getHealthinstituteById(String id) {
        Healthinstitute healthinstitute = null;

        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from healthinstitute where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                healthinstitute = new Healthinstitute();
                healthinstitute.setId(rs.getInt("id"));
                healthinstitute.setHid(rs.getString("healthinstitute_id"));
                healthinstitute.setName(rs.getString("healthinstitute_name"));
                healthinstitute.setType(rs.getString("htype"));
                healthinstitute.setAddress(rs.getString("address"));
                healthinstitute.setPhone(rs.getString("phone"));
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

        return healthinstitute;
    }

    public void deleteHealthinstituteById(String id) {
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "Delete from healthinstitute where id=?";
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


    public boolean updateHealthinstitute(Healthinstitute healthinstitute) {
        boolean isUpdated = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "UPDATE  healthinstitute set healthinstitute_id=?,healthinstitute_name=?,htype=?,address=?,phone=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, healthinstitute.getHid());
            ps.setString(2, healthinstitute.getName());
            ps.setString(3, healthinstitute.getType());
            ps.setString(4, healthinstitute.getAddress());
            ps.setString(5, healthinstitute.getPhone());
            ps.setInt(6, healthinstitute.getId());

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
}






