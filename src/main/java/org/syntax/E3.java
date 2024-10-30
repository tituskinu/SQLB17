package org.syntax;

import java.sql.*;

public class E3 {
    public static void main(String[] args) {


        try (
                Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD)) {
            Statement statement = connection.createStatement();
            String query = "Select * from employee";
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println(resultSetMetaData.getColumnCount());
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.print(resultSetMetaData.getColumnName(i) + " ");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
