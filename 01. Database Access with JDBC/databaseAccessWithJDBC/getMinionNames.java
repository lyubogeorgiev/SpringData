package com.databaseAccessWithJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getMinionNames {
    final private static String GET_MINIONS_NAMES = "SELECT name, age" +
            " FROM minions" +
            " JOIN minions_villains mv on minions.id = mv.minion_id" +
            " WHERE villain_id = ?";
    final private static String GET_VILLAIN_NAME = "SELECT name" +
            " FROM villains" +
            " WHERE id = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        System.out.println("Enter villain id: ");
        int villainId = new Scanner(System.in).nextInt();

        PreparedStatement minionsNames = connection.prepareStatement(GET_MINIONS_NAMES);
        minionsNames.setInt(1, villainId);

        PreparedStatement villainNameStatement = connection.prepareStatement(GET_VILLAIN_NAME);
        villainNameStatement.setInt(1, villainId);

        ResultSet villainSet = villainNameStatement.executeQuery();

        if(!villainSet.next()){
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }
        String villainName = villainSet.getString("name");

        ResultSet minionsSet = minionsNames.executeQuery();

        List<String> minions = new ArrayList<>();

        while(minionsSet.next()){
            String currentMinion = minionsSet.getString("name")
                    + " "
                    + minionsSet.getInt("age");

            minions.add(currentMinion);
        }

        System.out.printf("Villain: %s%n", villainName);

        for (int i = 0; i < minions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, minions.get(i));
        }
    }
}
