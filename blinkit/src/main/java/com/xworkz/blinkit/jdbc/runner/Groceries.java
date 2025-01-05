package com.xworkz.blinkit.jdbc.runner;

import java.sql.*;

public class Groceries {

    public static void main(String[] args) {


        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Jdbc found");

            String url = "jdbc:mysql://localhost:3306/school";

            String userName = "root";

            String password = "root";

            connection = DriverManager.getConnection(url, userName, password);

            System.out.println("Connection successfull....!");

//            String insert = "insert into teacher_info values(0,'Chandan','Male',47)";

            statement = connection.createStatement();

            String query = "select * from teacher_info";

            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();

            System.out.println("id : " + resultSet.getInt(1) + " ; Teacher Name : " + resultSet.getString(2) + " ; Gender : " + resultSet.getString(3) + " ; age : " + resultSet.getInt(4));
        } catch (ClassNotFoundException | SQLException exception) {

            System.out.println("Jdbc not found : " + exception.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
    }
}
