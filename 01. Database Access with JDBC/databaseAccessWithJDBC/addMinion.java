package com.databaseAccessWithJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class addMinion {
    final private static String TOWN_BY_NAME = "SELECT `name` FROM `towns` WHERE `name` = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        Scanner scanner = new Scanner(System.in);

        String minionInfo = scanner.nextLine();
        String villainName = scanner.nextLine().split("\\s+")[1];

        String[] minionTokens = minionInfo.split("\\s+");

        String minionName = minionTokens[1];
        int minionAge = Integer.parseInt(minionTokens[2]);
        String minionCity = minionTokens[3];

        //first check if the town exists
        PreparedStatement townStatement = connection.prepareStatement(TOWN_BY_NAME);
        townStatement.setString(1, minionCity);

        ResultSet townSet = townStatement.executeQuery();

        if (!townSet.next()){
            //update table to add the town
            
        }
    }
}
