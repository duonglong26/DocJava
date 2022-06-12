package com.nduonglong02;

import java.sql.*;

public class Insert {

    /**
     * Test connect database SQL Server
     * 20/05/2022
     */

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/javalop";
        String username = "root";
        String password = "123456";

        String query = "select * from UserTb";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected.");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("id") + " - " + rs.getString("username"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
