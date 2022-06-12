package com.nduonglong02.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertQuery {

    /**
     * Test connect database SQL Server
     * 25/05/2022
     */

    public static void main(String[] args) {
//        port default: 1433
        String dbUrl = "jdbc:sqlserver://localhost:1888;databaseName=javaLop;" +
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
