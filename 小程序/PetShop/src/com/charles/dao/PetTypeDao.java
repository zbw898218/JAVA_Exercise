package com.charles.dao;

import com.charles.entity.PetType;
import com.charles.tools.GetFile;
import com.charles.tools.IOTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles on 2017/6/28
 */
public class PetTypeDao {
    public static List<PetType> selectPetType(){
        List<PetType> petTypes =new ArrayList<>();
        PetType petType =null;
        File file=new  File(GetFile.PETTYPE_FILE_NAME);
        BufferedReader br= IOTools.reader(file);
        try {
            while(br.ready()){
                String str=br.readLine();
                if(!str.equals("")){
                    String[] info=str.split(",");
                    petType =new PetType();
                    petType.setPetTypeID(Integer.parseInt(info[0]));
                    petType.setPetTypeName(info[1]);
                    petTypes.add(petType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return petTypes;
    }
}
