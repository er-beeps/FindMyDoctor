package com.deerwalk.loginvalidate;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.User;

import java.sql.*;

public class Validate {


     public static User checkUser(String userUname, String userPass)
         {

             User user = null;
             Connection conn = new DbConnection().getDbConnection();
             try {
                 PreparedStatement ps = conn.prepareStatement("select * from user where username=? and password=?");
                 ps.setString(1, userUname);
                 ps.setString(2, userPass);
                 ResultSet rs = ps.executeQuery();
                 while(rs.next()){
                     user = new User();
                     user.setId(rs.getInt("id"));
                 }


             } catch (Exception e) {
                 e.printStackTrace();
             }
             return user;
         }
     }
