package com.charles.entity;

/**
 * 宠物类
 * Created by Charles on 2017/6/27
 */
public class Pet {
    private int petID;//宠物编号
    private int userID;//宠物主人编号
    private int typeID;//宠物类型编号
    private String name;//宠物名称
    private int age;//宠物年龄
    private int price;//售价
    private int onSell;//0:销售中 1：售完/下架
    public Pet() {
    }

    public Pet(int petID, int userID, int typeID, String name, int age,int price) {
        this.petID = petID;
        this.userID = userID;
        this.typeID = typeID;
        this.name = name;
        this.age = age;
        this.price=price;
    }
    
    public int getOnSell() {
        return onSell;
    }
    
    public void setOnSell(int onSell) {
        this.onSell = onSell;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", userID=" + userID +
                ", typeID=" + typeID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }
}
