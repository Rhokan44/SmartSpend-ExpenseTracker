package com.smartspend;

import java.sql.*;

public class DBUtil {
    static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/smartspend_db", 
            "root",                                      
            "your_password"                              
        );
    }
}

