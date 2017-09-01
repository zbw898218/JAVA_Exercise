package com.charles.entity;

/**
 * 宠物对象表
 * Created by Charles on 2017/6/27
 */
public class Pet {
    private int petID;//宠物编号
    private int typeID;//宠物类型编号
    private String name;//宠物名称
    private int age;//宠物年龄
    private String color;
    private int price;//
    private int onSell;//0:不在出售；1：正在出售
    private int masterID;
    public Pet() {
    }

    public Pet(int petID, int typeID, String name, int age, String color, int price, int onSell, int masterID) {
        this.petID = petID;
        this.typeID = typeID;
        this.name = name;
        this.age = age;
        this.color = color;
        this.price = price;
        this.onSell = onSell;
        this.masterID = masterID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOnSell() {
        return onSell;
    }

    public void setOnSell(int onSell) {
        this.onSell = onSell;
    }

    public int getMasterID() {
        return masterID;
    }

    public void setMasterID(int masterID) {
        this.masterID = masterID;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", typeID=" + typeID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", onSell=" + onSell +
                ", masterID=" + masterID +
                '}';
    }
}
