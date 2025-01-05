package com.xworkz.blinkit.jdbc.dao;

import java.sql.ResultSet;

public interface ThingsDao {

    int save(String deptName, int noOfStudents, int noOfTeachers);

    ResultSet getId(int id);




}
