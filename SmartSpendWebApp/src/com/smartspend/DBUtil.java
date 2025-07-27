package com.smartspend;

import java.sql.*;

public class DBUtil {
    static Connection getConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:C:/path-to-db/SmartSpend.db");
    }
}