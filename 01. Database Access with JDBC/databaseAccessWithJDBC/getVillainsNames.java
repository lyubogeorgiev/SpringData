package com.databaseAccessWithJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getVillainsNames {
    final private static String GET_VILLAIN_COUNT_QUERY = "SELECT v.`name`, COUNT(DISTINCT mv.`minion_id`) AS 'minion_count'" +
            " FROM `villains` AS v" +
            " JOIN `minions_villains` AS mv" +
            " ON v.id = mv.villain_id" +
            " GROUP BY mv.`villain_id`" +
            " HAVING `minion_count` > ?" +
            " ORDER BY `minion_count` DESC";

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        int countOfMinions = 15;

        PreparedStatement villainsCountStatement = connection.prepareStatement(GET_VILLAIN_COUNT_QUERY);
        villainsCountStatement.setInt(1, countOfMinions);

        ResultSet villains = villainsCountStatement.executeQuery();

        while(villains.next()){
            String villainName = villains.getString("name");
            int minionCount = villains.getInt("minion_count");

            System.out.printf("%s %d%n", villainName, minionCount);
        }

        connection.close();
    }
}
