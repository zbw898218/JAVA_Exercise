package com.charles.service;

import com.charles.dao.PetDao;
import com.charles.dao.UserDao;
import com.charles.entity.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles on 2017/6/28
 */
public class PetService {
    static PetDao pd=new PetDao() ;
    public static List<Pet> selectPets(){
        List<Pet> pets=new ArrayList<>();
        pets=pd.selectAllPets();
        return pets;
    }
}
