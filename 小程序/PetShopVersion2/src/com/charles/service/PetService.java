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
    
    /**
     * 获取准备上架的宠物对象
     * @param perID
     * @return
     */
    public static Pet selecetInSellPet(int perID){
        Pet pet=null;
        List<Pet> petList= PetDao.selectPets();
        Iterator<Pet> its= petList.iterator();
        while(its.hasNext()){
            //去除类型不一致的宠物
            Pet temp=its.next();
            if(temp.getPetID()==perID){
                pet=temp;//找到目标宠物，跳出循环
                break;
            }
        }
        return pet;
    }
    
    /**
     * 获取正在销售中的目标宠物对象
     * @param perID
     * @return
     */
    public static Pet selecetOnSellPet(int perID){
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
     * 将新宠物追加到pet表中
     * @param newPetInfo
     */
    public static void updatePetInfo(String newPetInfo){
        PetDao.updatePetInfo(newPetInfo);
    }
    /**
     * 刷新宠物表，更新信息
     * 将被交易的宠物信息修改后再写入表中
     */
    public static void updatePetInfo(int petID,int newMasterID){
        List<Pet> petList= PetDao.selectPets();
        Iterator<Pet> its= petList.iterator();
        while(its.hasNext()){
            //去除类型不一致的宠物
            Pet temp=its.next();
            if(temp.getPetID()==petID){//找到交易的宠物，修改信息
                temp.setOnSell(0);
                temp.setMasterID(newMasterID);
                break;
            }
        }
        PetDao.updatePetInfo(petList);
    }
    public  static int sellPet(int petID,int price,int masterID){
        int isOK=0;//1:没有该宠物 2：已经上架 3：上架成功
        List<Pet> petList= PetDao.selectPets();
        Iterator<Pet> its= petList.iterator();
        while(its.hasNext()){
            Pet tmp= its.next();
            //找到目标宠物，校验是否属于自己，及是否已经上架
            if(tmp.getPetID()==petID){
                if(tmp.getMasterID()==masterID){
                    if(tmp.getOnSell()!=1){
                        isOK=3;
                        tmp.setOnSell(1);
                        break;
                    }else{
                        isOK=2;
                        break;
                    }
                }else{
                    isOK=1;
                    break;
                }
            }
        }
        if(isOK==3){//校验成功，才会更新pet表
            PetDao.updatePetInfo(petList);
        }
        return isOK;
    }

    /**
     * 生成新id
     * @return
     */
    public static int getNewPetID(){
        int newPetID=0;
        List<Pet> petList= PetDao.selectPets();
        if(petList.size()==0){
            newPetID=1;
        }else{
            newPetID=petList.get(petList.size()-1).getPetID()+1;
        }
        return newPetID;
    }
}
