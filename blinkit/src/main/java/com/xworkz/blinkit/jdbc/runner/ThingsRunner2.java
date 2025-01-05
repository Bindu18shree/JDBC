package com.xworkz.blinkit.jdbc.runner;

import com.xworkz.blinkit.jdbc.dao.ThingsDao;
import com.xworkz.blinkit.jdbc.dao.ThingsDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThingsRunner2 {

     private static ThingsDao thingsDao = new ThingsDaoImpl();
     private static boolean getId = true;

    public static void main(String[] args) {

        ResultSet resultSet = thingsDao.getId(100);


            try {
                while (resultSet.next()){

                    getId=false;
                    System.out.println("id : " +resultSet.getInt(1)+ " dept Name : " +resultSet.getString(2)+ " no of teachers : " +resultSet.getInt(3)+ " no of students : " +resultSet.getInt(4));

                }

                if (getId){

                    System.out.println("Data is not found");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
    }

