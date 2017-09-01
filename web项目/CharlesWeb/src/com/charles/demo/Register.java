package com.charles.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaersi on 2017/7/26.
 */
public class Register {
    private String name="";
    private String age="";
    private String email="";
    private Map<String,String> errors=null;
    public Register(){
        errors=new HashMap<>();
    }

    public boolean isVilidate(){

        boolean flg=true;
        if(!this.name.matches("\\w{6,15}")){
            this.name="";
            flg=false;
            this.errors.put("errname","用户名长度必须在6-15位");

        }
        if(!this.age.matches("\\d+")){
            this.age="";
            flg=false;
            errors.put("errage","年龄必须是数字");
        }
        if(!this.email.matches("\\w+@\\w+.\\w+\\.?\\w*")){
            this.email="";
            flg=false;
            errors.put("erremail","邮箱格式不合法");
        }
        return flg;
    }
    public String  getErrorMsg(String key){

        String value=errors.get(key);
        if(value==null){
            value="";
        }
        return value;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
