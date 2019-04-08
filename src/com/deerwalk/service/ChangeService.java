package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.PasswordChange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeService {
    public boolean changePassword(PasswordChange change) {
        boolean isUpdated = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "UPDATE user SET password=? where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, change.getPass());
            ps.setString(2, change.getName());


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
