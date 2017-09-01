package com.charles.dao;

import com.charles.entity.Pet;
import com.charles.tools.Tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles on 2017/6/27
 */
public class PetDao {
    /**
     * 查询单个宠物
     * @param p
     * @return
     */
    public boolean selectPet(Pet p){
        boolean isHave=false;
        BufferedReader br=null;
        try {
            br= Tools.reader(Tools.PET_FILE);
            String str="";
            while((str=br.readLine())!=null){
                String[] petInfo=str.split(",");
                if(Integer.parseInt(petInfo[0])==p.getPetID()&&petInfo[3].equals(p.getName())){
                    isHave=true;//找到目标宠物，修改标志位，退出循环
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isHave;
    }
    /**
     * 查询所有宠物信息，以集合的形式返回
     * @return
     */
    public List<Pet> selectAllPets() {
        List<Pet> petLists=new ArrayList<>();
        BufferedReader br= null;
        try {
            br=Tools.reader(Tools.PET_FILE);
            String str="";
            while((str=br.readLine())!=null){
                String[] petInfo=str.split(",");
                Pet pet=new Pet();
                pet.setPetID(Integer.parseInt(petInfo[0]));
                pet.setUserID(Integer.parseInt(petInfo[1]));
                pet.setTypeID(Integer.parseInt(petInfo[2]));
                pet.setName(petInfo[3]);
                pet.setAge(Integer.parseInt(petInfo[4]));
                pet.setPrice(Integer.parseInt(petInfo[5]));
                pet.setOnSell(Integer.parseInt(petInfo[6]));
                petLists.add(pet);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return petLists;
    }
}
