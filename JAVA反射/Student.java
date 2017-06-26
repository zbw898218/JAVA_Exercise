package Exercise.Work0606;

import java.lang.reflect.Method;

/**
 * Created by Charles on 2017/6/6.
 */
public class Student {
    private String sNO;
    private String sName;
    private String sSex;
    private int sAge;
    private int sJAVA;
    
    public Student() {
    }
    
    public Student(String sNO, String sName, String sSex, Integer sAge, Integer sJAVA) {
        this.sNO = sNO;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sJAVA = sJAVA;
    }
//    统一设置参数方法
    public void setData(String sNO, String sName, String sSex, Integer sAge, Integer sJAVA){
        this.sNO = sNO;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sJAVA = sJAVA;
    }
    public String getsNO() {
        return sNO;
    }
    
    public void setsNO(String sNO) {
        this.sNO = sNO;
    }
    
    public String getsName() {
        return sName;
    }
    
    public void setsName(String sName) {
        this.sName = sName;
    }
    
    public String getsSex() {
        return sSex;
    }
    
    public void setsSex(String sSex) {
        this.sSex = sSex;
    }
    
    public int getsAge() {
        return sAge;
    }
    
    public void setsAge(int sAge) {
        this.sAge = sAge;
    }
    
    public int getsJAVA() {
        return sJAVA;
    }
    
    public void setsJAVA(int sJAVA) {
        this.sJAVA = sJAVA;
    }
    //复写toString方法，自定义打印格式
    @Override
    public String toString() {
        return "学生信息{" +
                "学号='" + sNO + '\'' +
                ", 姓名='" + sName + '\'' +
                ", 性别='" + sSex + '\'' +
                ", 年龄=" + sAge +
                ", JAVA课程=" + sJAVA +"分"+
                '}';
    }
    //    自定义反射方法。利用类名，方法名，方法参数，调用Student类的方法
    
}
