package com.xworkz.blinkit.jdbc.runner;

import com.xworkz.blinkit.jdbc.dao.ThingsDao;
import com.xworkz.blinkit.jdbc.dao.ThingsDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThingsRunner {

    private static ThingsDaoImpl thingsDao = new ThingsDaoImpl();

    public static void main(String[] args) {

//        thingsDao.save("Robotics", 50, 18);

        ResultSet resultSet = thingsDao.getAll();
        try {

            if (resultSet.isFirst() == false) {

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int noOfStudents = resultSet.getInt(3);
                    int noOfTeachers = resultSet.getInt(4);

                    System.out.println("Id is : " + id + " ; name : " + name + " ; No of students : " + noOfStudents + " ; No of teachers : " + noOfTeachers);
                }
            } else {
                System.out.println("Database not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
