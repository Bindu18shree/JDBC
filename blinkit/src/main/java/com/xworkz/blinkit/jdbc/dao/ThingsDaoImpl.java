package com.xworkz.blinkit.jdbc.dao;

import java.sql.*;

public class ThingsDaoImpl implements ThingsDao{

   private String url = "jdbc:mysql://localhost:3306/school";

   private String userName = "root";

   private String password = "root";

    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public int save(String deptName, int noOfStudents, int noOfTeachers) {

        try {
           connection =  DriverManager.getConnection(url,userName,password);
           statement = connection.prepareStatement("insert into department_info values(?,?,?,?)");

           statement.setInt(1,0);
           statement.setString(2,deptName);
           statement.setInt(3,noOfStudents);
           statement.setInt(4,noOfTeachers);

           int row = statement.executeUpdate();
           return row;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }

                if(statement!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public ResultSet getAll() {

        try {
            connection = DriverManager.getConnection(url, userName, password);

            statement = connection.prepareStatement("Select * from department_info");

            ResultSet resultSet = statement.executeQuery();

            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getId(int id) {

        try {
          connection =   DriverManager.getConnection(url,userName,password);

          statement =  connection.prepareStatement("select * from department_info where id=?");
          statement.setInt(1,id);

         ResultSet resultSet = statement.executeQuery();


         return  resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

}
