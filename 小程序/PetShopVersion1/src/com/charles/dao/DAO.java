package com.charles.dao;

import com.charles.entity.Pet;
import com.charles.entity.User;

import java.util.List;

/**
 * 数据访问层接口
 * 定义：增删改查等标准方法
 * Created by Charles on 2017/6/27
 */
public interface DAO<T,E> {
    void add(T t);
    void del(T t);
    void alter(T t);
//    boolean selectUser(T t);
//    boolean selectPet(E e );
//    List<T> selectAllUsers();
//    List<E> selectAllPets();


}
