package com.charles.dao;

import com.charles.entity.Pet;
import com.charles.tools.GetFile;
import com.charles.tools.IOTools;
import com.charles.tools.PrintTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Charles on 2017/6/28
 */
public class PetDao {
    /**
     * 查询宠物对象表，返回所有宠物对象组成的集合
     * @return
     */
    public static List<Pet> selectPets(){
        List<Pet> pets=new ArrayList<>();
        Pet pet=null;
        File file=new  File(GetFile.PET_FILE_NAME);
        BufferedReader br= IOTools.reader(file);
        try {
            while(br.ready()){
                String str=br.readLine();
                if(!str.equals("")){
                    String[] info=str.split(",");
                    pet=new Pet();
                    pet.setPetID(Integer.parseInt(info[0]));
                    pet.setTypeID(Integer.parseInt(info[1]));
                    pet.setName(info[2]);
                    pet.setAge(Integer.parseInt(info[3]));
                    pet.setColor(info[4]);
                    pet.setPrice(Integer.parseInt(info[5]));
                    pet.setOnSell(Integer.parseInt(info[6]));
                    pet.setMasterID(Integer.parseInt(info[7]));
                    pets.add(pet);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pets;
    }
    /**
     * 刷新宠物表，更新信息
     * 将被交易的宠物信息修改后再写入表中
     *
     */
    public static void updatePetInfo(List<Pet> petList){
        BufferedWriter bw=null;
        File file=new File(GetFile.PET_FILE_NAME);
        bw=IOTools.writers(file);
        Pet pet=null;
        Iterator<Pet> it=petList.iterator();
        while(it.hasNext()){
            pet=new Pet();
            String petInfo=pet.getPetID()+","+pet.getTypeID()+","+pet.getName()+","+pet.getAge()+","+pet.getColor()+","+pet.getPrice()
                    +","+pet.getOnSell()+","+pet.getMasterID();
            try {
                bw.write(petInfo);
                bw.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
