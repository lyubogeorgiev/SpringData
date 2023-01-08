package com.jdbcdemo;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DemoConnection {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "123456");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        String query = "SELECT " +
                "u.user_name," +
                "u.first_name," +
                "u.last_name," +
                "COUNT(u.id) AS games_played " +
                "FROM users as u " +
                "JOIN users_games AS ug " +
                "ON u.id= ug.user_id " +
                "GROUP BY u.id " +
                "HAVING u.user_name = ?";


        PreparedStatement stmt = connection.prepareStatement(query);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();


        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            String currentUsername = rs.getString("user_name");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int gamesPlayed = rs.getInt("games_played");
            System.out.printf("%s | %s %s | %d%n", currentUsername, firstName, lastName, gamesPlayed);
        }else{
            System.out.println("No such user exists");
        }

        connection.close();
    }
}
