package com.xworkz.jdbc.runner;

import java.sql.*;

public class Department {

    public static void main(String[] args) {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Jdbc found");

            String url = "jdbc:mysql://localhost:3306/school";

            String userName = "root";

            String password = "root";

            connection = DriverManager.getConnection(url, userName,password);

            System.out.println("Connection successfull....!");

            String insert = "insert into teacher_info values(0,'Chandan','Male',47)";

            Statement statement = connection.createStatement();

            int row = statement.executeUpdate(insert);

            System.out.println("no of rows inserted : " +row);
        }
        catch (ClassNotFoundException | SQLException exception){

            System.out.println("Jdbc not found : " +exception.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
    }
}
