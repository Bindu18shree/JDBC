package com.xworkz.blinkit.jdbc.runner;

import java.sql.*;

public class Vegetables {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Jdbc found");

            String url = "jdbc:mysql://localhost:3306/school";

            String userName = "root";

            String password = "root";

            connection = DriverManager.getConnection(url, userName,password);

            System.out.println("Connection successfull....!");

            statement = connection.createStatement();

            String query = "select * from teacher_info where id=4";

            ResultSet resultSet =  statement.executeQuery(query);

            while (resultSet.next()){

                int id = resultSet.getInt(1);
                String teacherName = resultSet.getString(2);
                String gender = resultSet.getString(3);
                int age = resultSet.getInt(4);

                System.out.println("id : "+id+" ; Teacher Name : "+teacherName+" ; Gender : "+gender+" ; Age : " +age);
            }
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }

                if(statement!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
