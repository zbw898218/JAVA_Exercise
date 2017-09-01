package com.charles.JDBC;

import com.charles.dao.PetDao;
import com.charles.entity.Pet;

import java.util.List;

/**
 * 数据管理类：
 * 提供增删改查方法
 * Created by Charles on 2017/6/30
 */
public class ManagerData {
    public static void main(String[] args){
        List<Pet> list= PetDao.selectPets();
        PetDao.updatePetTable(list);
    }
}
