package org;


import java.util.Date;

public class UserMyClassLoader {
    public static void main(String[] args) {
        try {
            System.out.println("****");
            Class clz=new MyClassLoader("E:\\IdeaProjects\\Workspace01\\ClassLoaderTest\\src\\cypherlib").loadClass("test.TargetClass");
            Date d1=(Date) clz.newInstance();
            System.out.println(d1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
