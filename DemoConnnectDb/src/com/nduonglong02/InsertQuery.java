package com.nduonglong02;

import java.sql.*;
import java.util.Random;

public class InsertQuery {

    /**
     * Test connect database SQL Server
     * 25/05/2022
     */

    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=javaLop;" +
                "user=sa;password=123456;";
        double randomDouble = Math.random();
        randomDouble = randomDouble * 100 + 1;
        int randomInt = (int) randomDouble;
        String query = "insert into UserTb values (" + randomInt + ", 'long22')";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(dbUrl);
            System.out.println("Connected.");
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Insert success");
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
