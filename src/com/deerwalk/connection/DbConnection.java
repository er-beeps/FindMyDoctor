package com.deerwalk.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    String URL = "jdbc:mysql://localhost:3306/findmydoc";
    String USERNAME = "root";
    String PASSWORD = "";

    Connection conn = null;
    public Connection getDbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
