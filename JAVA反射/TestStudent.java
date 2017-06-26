package Exercise.Work0606;

import java.lang.reflect.Method;

/**
 * Created by Charles on 2017/6/6.
 */
public class TestStudent implements ILess<Student>{
    /**
     * 定义一个通用方法，通过类名，方法名，方法参数序列，反射调用指定类的指定方法
        本例，通过反射方法，创建一个student类实例，并调用setData方法将值赋给对应属性，并将创建的类实例返回
     */
    public static Student reflectFun(String className,String methodName,Object[]param) {
        Student stu=null;
        try {
            Class classInfo = Class.forName(className);
//            创建学生类数组，存储学生类对象
            
            Class[] c = new Class[param.length];
//            创建Class[]数组，循环获得方法的参数列表
            for (int i = 0; i < param.length; i++) {
                c[i] = param[i].getClass();
            }
//            调用无参构造函数，实例化一个Student对象
            stu=(Student)classInfo.getConstructor().newInstance();
            Method mt=classInfo.getMethod(methodName,c);
            mt.invoke(stu,param);
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stu;
    }
    
    /**
     * 本例通过类名和构造方法的参数列表，反射创建类的实例，并将该实例返回
     * @param className：类名
     * @param param：构造函数的参数列表
     * @return ：返回反射生成的Student类实例
     */
    public static Student reflectFun(String className,Object[]param){
        Student st=null;
        try {
            Class classInfo=Class.forName(className);
            Class[] c=new Class[param.length];
            for(int i=0;i<param.length;i++){
                c[i]=param[i].getClass();
            }
            st=(Student)classInfo.getConstructor(c).newInstance(param);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
  
    public static void main(String[] args){
        Student[] stus=new Student[5];
        Student[] stus1=new Student[5];
        String str="Exercise.Work0606.Student";
        String mstr="setData";
        /**
         * 定义一个二维Object数组，存储setData方法的参数，具体值可以通过不同方法设定，本例为简便。
         * 默认设定了5个值。并依次传入反射方法中，从而获得5个Student类实例，增强for循环打印出来。
         */
        Object[][] par={{"G1","张三","男",25,89},
                {"G2","李四","男",20,79},{"G3","王二小","男",15,67},{"G4","三妹","女",23,99},{"G5","梁茵","女",35,77},};
//        reflectFun(str,mstr,par[0]);
        for(int i=0;i<par.length;i++){
            /**
             * reflectFun:使用了重载方法
             * 反射小结：1.可以通过反射创建已知类的实例，从而得到该类的所有属性和方法，并对其进行任意操作。
             */
            stus[i]=reflectFun(str,mstr,par[i]);
            stus1[i]=reflectFun(str,par[i]);
        }
        for(Student st:stus){
            System.out.println(st);
        }
        System.out.println("-----------------------分割线------------------------");
        for(Student st:stus1){
            System.out.println(st);
        }
        System.out.println("-----------------------分割线------------------------");
        /**
         * 利用接口和泛型方法类实现比较
         */
        Algo<Student> al=new Algo();
        ILess ts=new TestStudent();
        Student max=al.getMax(stus,ts);
        System.out.println(max);
        Student min=al.getMin(ts,stus);
        System.out.println(min);
        
        System.out.println("-----------------------分割线------------------------");
        int sum=0;
        for(Student st:stus){
            sum+=st.getsJAVA();
        }
        System.out.println("JAVA的均分为："+sum/stus.length);
    }
    
    @Override
    public boolean less(Student x, Student y) {
        return x.getsJAVA()<y.getsJAVA();
    }
}
