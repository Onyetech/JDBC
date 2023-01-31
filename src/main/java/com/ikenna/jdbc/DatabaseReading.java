package com.ikenna.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseReading {

    public static void main(String[] args) {

        String password = "password";
        String username = "root";
        String query = "select * from users";
        String url = "jdbc:mysql://localhost:3306/talkpi";


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                Connection con = DriverManager.getConnection(url, username, password);
                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(query);

                while (result.next()) {
                    String universityData ="";
                    for (int i = 0; i <= 6; ++i) {
                        universityData += result.getString(i) + ";";
                }
                    System.out.println(universityData);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }

}
