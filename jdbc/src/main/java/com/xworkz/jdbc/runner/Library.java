package com.xworkz.jdbc.runner;

import java.sql.*;

public class Library {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Jdbc found");

            String url = "jdbc:mysql://localhost:3306/applicaton";

            String userName = "root";

            String password = "root";

            DriverManager.getConnection(url, userName,password);

            System.out.println("Connection successfull....!");
        }
        catch (ClassNotFoundException | SQLException exception){

            System.out.println("Jdbc not found : " +exception.getMessage());
        }
    }
}
