package com.xworkz.zomato.runner;

import com.xworkz.zomato.dao.ZomatoDao;
import com.xworkz.zomato.dao.ZomatoImpl;

public class ZomatoRunner {

    private  static ZomatoDao zomatoDao =new ZomatoImpl();
    public static void main(String[] args) {
//        zomatoDao.save(0,"amruthadare","Zee",4.3,5,"kannada");
        zomatoDao.getDataById(3);
        int updated=zomatoDao.UpdateDataByFields(2,"bindu","Female",39);
        System.out.println("updated :"+updated);
    }
}

