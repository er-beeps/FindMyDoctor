package com.deerwalk.service;

import com.deerwalk.connection.DbConnection;
import com.deerwalk.model.PasswordReset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetService {

    public boolean resetPassword(PasswordReset reset) {
        boolean isUpdated = false;
        Connection conn = new DbConnection().getDbConnection();
        try {
            String sql = "UPDATE user SET password=? where email=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reset.getPass());
            ps.setString(2, reset.getEmail());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdated;
    }
}
