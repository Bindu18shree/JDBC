package com.xworkz.jdbc.runner;

import java.sql.*;

public class University {

    public static void main(String[] args) {

        //import
        //load the driver
        //establish connection
        //create statement
        //execute statement
        //process the result
        //close the connection

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Jdbc found");

           String url =  "jdbc:mysql://localhost:3306/school";
           String userName = "root";
           String password = "root";

       connection =  DriverManager.getConnection(url,userName,password);

            System.out.println("Connection successfull");

            //create statement

            String insert = "insert into school_info values (0 , 'Manasa', 22)";

            String insert1 = "insert into school_info values (0 , 'Lavanya', 21)";

            String insert2 = "insert into school_info values (0 , 'Garima', 23)";

            String insert3 = "insert into school_info values (0 , 'Kalash', 24)";

            String insert4 = "insert into school_info values (0 , 'Aditya', 23)";
            Statement statement = connection.createStatement();

            statement.addBatch(insert);
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);

            int[] row = statement.executeBatch();

            System.out.println("no of rows inserted :" +row.length);
        } catch (ClassNotFoundException | SQLException classNotFoundException){

            System.out.println("Jdbc not found :" +classNotFoundException.getMessage());
        }

        finally {
            try{

                connection.close();
            } catch (SQLException e){

                System.out.println(e.getMessage());
            }

        }
    }
}
