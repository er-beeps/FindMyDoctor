package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    public boolean insertMember(Member member) {
        boolean isInserted = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "insert into member(username,firstname,lastname,gender,dateofbirth,email,phone,address,province,zone,district) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, member.getUserName());
            ps.setString(2, member.getFirstName());
            ps.setString(3, member.getLastName());
            ps.setString(4, member.getGender());
            ps.setString(5, member.getDob());
            ps.setString(6, member.getEmail());
            ps.setString(7, member.getPhone());
            ps.setString(8, member.getAddress());
            ps.setString(9, member.getProvince());
            ps.setString(10, member.getZone());
            ps.setString(11, member.getDistrict());

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

    public List<Member> getAllMembersByUserName(String userName) {
        List<Member> memberList = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from member where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setFirstName(rs.getString("firstname"));
                member.setLastName(rs.getString("lastname"));
                member.setUserName(rs.getString("username"));
                member.setGender(rs.getString("gender"));
                member.setDob(rs.getString("dateofbirth"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setProvince(rs.getString("province"));
                member.setZone(rs.getString("zone"));
                member.setDistrict(rs.getString("district"));

                memberList.add(member);

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
        return memberList;
    }

    public List<Member> getAllMembers() {
        List<Member> memberList = new ArrayList<>();
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from member";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("id"));
                member.setFirstName(rs.getString("firstname"));
                member.setLastName(rs.getString("lastname"));
                member.setUserName(rs.getString("username"));
                member.setGender(rs.getString("gender"));
                member.setDob(rs.getString("dateofbirth"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setProvince(rs.getString("province"));
                member.setZone(rs.getString("zone"));
                member.setDistrict(rs.getString("district"));


                memberList.add(member);

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
        return memberList;
    }

    public Member getMemberById(int id) {
        Member member=null;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "select * from member where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                member = new Member();
                member.setFirstName(rs.getString("firstname"));
                member.setLastName(rs.getString("lastname"));
                member.setUserName(rs.getString("username"));
                member.setGender(rs.getString("gender"));
                member.setDob(rs.getString("dateofbirth"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setProvince(rs.getString("province"));
                member.setZone(rs.getString("zone"));
                member.setDistrict(rs.getString("district"));

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
        return member;
    }
    }



