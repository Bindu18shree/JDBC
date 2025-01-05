package com.xworkz.blinkit.jdbc.runner;

import java.sql.*;

public class Fruits {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school";

        String userName = "root";

        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, userName, password);

            String query = "insert into school_info values(?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, 14);
            statement.setString(2, "Kevin");
            statement.setInt(3, 20);

            int rows = statement.executeUpdate();
            System.out.println("no of rows inserted : " + rows);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


}
