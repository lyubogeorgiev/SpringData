package com.databaseAccessWithJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Utils {

    final private static String PROPERTY_USER_KEY = "user";
    final private static String PROPERTY_USER_VALUE = "root";
    final private static String PROPERTY_PASSWORD_KEY = "password";
    final private static String PROPERTY_PASSWORD_VALUE = "12adwxS12";

    final private static String DATABASE_URL = "jdbc:mysql://localhost:3306/minions_db";

    public static Connection getSQLConnection() throws SQLException {

        Properties props = new Properties();
        props.setProperty(PROPERTY_USER_KEY, PROPERTY_USER_VALUE);
        props.setProperty(PROPERTY_PASSWORD_KEY, PROPERTY_PASSWORD_VALUE);

        return DriverManager.getConnection(DATABASE_URL, props);
    }
}
