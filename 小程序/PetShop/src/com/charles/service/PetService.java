package com.charles.service;

import com.charles.dao.PetDao;
import com.charles.dao.PetTypeDao;
import com.charles.entity.Account;
import com.charles.entity.Pet;
import com.charles.entity.PetType;

import java.util.Iterator;
import java.util.List;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
 * Created by Charles on 2017/6/28
 */
public class PetService {
    /**
     * 返回正在出售的宠物组成的集合
     * @return
     */
    public static List<Pet> selecetPetOnSell(){
        List<Pet> petList= PetDao.selectPets();
        Iterator<Pet> it= petList.iterator();
        while(it.hasNext()){
            if(it.next().getOnSell()==0){
                //去除不在销售中的宠物
                it.remove();
            }
        }
        return petList;
    }

    public static List<Pet> selecetNeedPet(String petType){
        List<Pet> petTypeList= PetDao.selectPets();
        List<PetType> petTypes= PetTypeDao.selectPetType();
        int petTypeID=0;
        PetType pt=null;
        Iterator<PetType> it=petTypes.iterator();
        while(it.hasNext()){
            pt=it.next();
            if(pt.getPetTypeName().equals(petType)){
                petTypeID=pt.getPetTypeID();
                break;
            }
        }
        Iterator<Pet> its= petTypeList.iterator();
        while(its.hasNext()){
            //去除类型不一致的宠物
            if(its.next().getTypeID()!=petTypeID){
                its.remove();
            }
        }
        return petTypeList;
    }

    public static Pet selecetOnePet(int perID){
        Pet pet=null;
        List<Pet> petList= PetDao.selectPets();
        Iterator<Pet> its= petList.iterator();
        while(its.hasNext()){
            //去除类型不一致的宠物
            Pet temp=its.next();
            if(temp.getPetID()==perID&&temp.getOnSell()!=0){
                pet=temp;//找到正在出售的目标宠物，跳出循环
                break;
            }
        }
        return pet;
    }

    /**
     * 刷新宠物表，更新信息
     * 将被交易的宠物信息修改后再写入表中
     */
    public static void updatePetInfo(Account account,Pet pet){
        List<Pet> petList= PetDao.selectPets();
        petList.remove(pet);//将购买前宠物信息删除
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pet.setMasterID(account.getAccountID());
        pet.setOnSell(0);
        petList.add(pet);
        PetDao.updatePetInfo(petList);
    }
}
