package com.xworkz.zomato.dao;

import java.sql.*;

public class ZomatoImpl implements ZomatoDao{

    String URL = "jdbc:mysql://localhost:3306/school";
    String USER = "root";
    String PASS = "root";

    Connection connection = null;
    PreparedStatement preparedStatemet = null;

    @Override
    public int save(int id, String teacher_Name, String gender, int age) {



        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            preparedStatemet = connection.prepareStatement("insert into teacher_info values(?,?,?,?,?,?)");
            preparedStatemet.setInt(1, 0);
            preparedStatemet.setString(2, teacher_Name);
            preparedStatemet.setString(3, gender);
            preparedStatemet.setInt(4, age);



            int row = preparedStatemet.executeUpdate();
            System.out.println("no of rows inserted: " + row);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                } else if (preparedStatemet != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return 0;

    }

    @Override
    public ResultSet getDataById(int id) {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement("select * from  teacher_info where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String teacher_Name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                int age = resultSet.getInt(4);
                System.out.println(" ID:  " + ID + "   Name:  " + teacher_Name + "  Gender :  " + gender + "   Age :  " + age);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int UpdateDataByFields(int id, String teacher_Name, String gender, int age) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update teacher_info set  teacher_Name=?,gender=? where id=? AND age=?");
            statement.setInt(3, id);
            statement.setString(1,teacher_Name);
            statement.setString(2,gender);
            statement.setInt(4,age);


            int row = statement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }

            System.out.println(e.getMessage());
        }
        return 0;
    }
    }

