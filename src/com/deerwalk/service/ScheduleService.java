package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleService {
    public boolean insertSchedule(Schedule schedule){
        boolean isInserted = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "insert into schedule(nmc_code,doctor_name,healthinstitute_id,healthinstitute_name,healthinstitute_type,sday,start_time,end_time) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, schedule.getNmcCode());
            ps.setString(2, schedule.getDocName());
            ps.setString(3, schedule.getHiId());
            ps.setString(4, schedule.getHiName());
            ps.setString(5, schedule.getHiType());
            ps.setString(6, schedule.getDay());
            ps.setString(7, schedule.getStartTime());
            ps.setString(8, schedule.getEndTime());

            int affectedRows = ps.executeUpdate();
            if(affectedRows > 0) {
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

    public List<Schedule> getAllSchedule() {
        List<Schedule> scheduleList = new ArrayList<>();;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from schedule";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Schedule schedule = new Schedule();
                schedule.setId(Integer.parseInt(rs.getString("id")));
                schedule.setNmcCode(rs.getString("nmc_code"));
                schedule.setDocName(rs.getString("doctor_name"));
                schedule.setHiId(rs.getString("healthinstitute_id"));
                schedule.setHiName(rs.getString("healthinstitute_name"));
                schedule.setHiType(rs.getString("healthinstitute_type"));
                schedule.setDay(rs.getString("sday"));
                schedule.setStartTime(rs.getString("start_time"));
                schedule.setEndTime(rs.getString("end_time"));

                scheduleList.add(schedule);
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
        return scheduleList;
    }


    public Schedule getScheduleById(String id) {
        Schedule schedule=null;

        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from schedule where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                schedule = new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setNmcCode(rs.getString("nmc_code"));
                schedule.setDocName(rs.getString("doctor_name"));
                schedule.setHiId(rs.getString("healthinstitute_id"));
                schedule.setHiName(rs.getString("healthinstitute_name"));
                schedule.setHiType(rs.getString("healthinstitute_type"));
                schedule.setDay(rs.getString("sday"));
                schedule.setStartTime(rs.getString("start_time"));
                schedule.setEndTime(rs.getString("end_time"));

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

        return schedule;
    }

    public void deleteScheduleById(String id) {
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "Delete from schedule where id=?";
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

    public boolean updateSchedule(Schedule schedule) {
            boolean isUpdated = false;
            Connection conn = new DbConnection().getDbConnection();
            try {
                String sql = "update schedule set nmc_code=?,doctor_name=?,healthinstitute_id=?,healthinstitute_name=?,healthinstitute_type=?,sday=?,start_time=?,end_time=? where id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, schedule.getNmcCode());
                ps.setString(2, schedule.getDocName());
                ps.setString(3, schedule.getHiId());
                ps.setString(4, schedule.getHiName());
                ps.setString(5, schedule.getHiType());
                ps.setString(6, schedule.getDay());
                ps.setString(7, schedule.getStartTime());
                ps.setString(8, schedule.getEndTime());
                ps.setInt(9,schedule.getId());

                int affectedRows = ps.executeUpdate();
                if(affectedRows > 0) {
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





