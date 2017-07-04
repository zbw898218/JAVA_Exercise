package com.charles.entity;

/**
 * 宠物类型表
 * Created by Charles on 2017/6/27
 */
public class PetType {
    private int petTypeID;//宠物类型编号
    private String petTypeName;//类型名称

    public PetType() {
    }

    public PetType(int petTypeID, String petTypeName) {
        this.petTypeID = petTypeID;
        this.petTypeName = petTypeName;
    }

    public int getPetTypeID() {
        return petTypeID;
    }

    public void setPetTypeID(int petTypeID) {
        this.petTypeID = petTypeID;
    }

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "petTypeID=" + petTypeID +
                ", petTypeName='" + petTypeName + '\'' +
                '}';
    }
}
