package org;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String classDir;

    public MyClassLoader(String classDir) {
        this.classDir = classDir;
    }

    public MyClassLoader() {
    }


    /**
     * 加密方法：b^0xff 0--->1 1--->0
     * @param is
     * @param os
     */
    public static void cypher(InputStream is, OutputStream os){
        int b=-1;
        try {
            while ((b=is.read())!=-1){
                os.write(b^0xff);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String srcpath="E:\\IdeaProjects\\Workspace01\\out\\production\\ClassLoaderTest\\test\\TargetClass.class";
        String descdir="E:\\IdeaProjects\\Workspace01\\ClassLoaderTest\\src\\cypherlib";
        String fileName=srcpath.substring(srcpath.lastIndexOf("\\"));
        String descpath=descdir+File.separator+fileName;
        System.out.println(descpath);
        try {
            InputStream is=new FileInputStream(srcpath);
            OutputStream os=new FileOutputStream(descpath);
//            对文件进行加密操作！
            cypher(is,os);
            is.close();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
//        获取要加载的文件类名
        String classFileName=classDir+File.separator+name.substring(name.lastIndexOf(".")+1)+".class";
        try {
            FileInputStream fis=new FileInputStream(classFileName);
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
//            对文件进行解密操作
            cypher(fis,bos);
            System.out.println("myclassloader");
            fis.close();
            bos.close();
            byte[] bytes=bos.toByteArray();
            return defineClass(bytes,0,bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
