package com.xworkz.zomato.dao;

import java.sql.ResultSet;

public interface ZomatoDao {

    int save(int id,String teacher_Name,String gender,int age);
    ResultSet getDataById(int id);
    int UpdateDataByFields(int id,String teacher_Name,String gender,int age);
}
