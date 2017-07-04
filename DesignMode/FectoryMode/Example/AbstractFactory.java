package DesignMode.FectoryMode.Example;

/**
 * 定义抽象工厂
 * Created by Charles on 2017/6/7
 */
public abstract class AbstractFactory  {
    private static String TEXT="text";
    private static String IMAGE="image";

    public abstract IRead create();

    /**
     * 第一种情况：
     * 抽象方法create()：具体工厂类对象有客户端调用方产生；
     * 静态方法create（）：具体工厂类对象在本类产生的，根据mark标志自动生成不同的具体工厂类对象，本类暗含2种产生工厂对象的方法，方便用户加以选择
     * @param mark
     * @return
     */
    static AbstractFactory create(String mark){
//        mark：具体工厂类型标识字符串，不是类名
        AbstractFactory factory=null;
        if(mark.equals(TEXT)){
            factory=new TextFactory();
        }else if(mark.equals(IMAGE)){
            factory=new ImageFactory();
        }
        return factory;
    }

    /**
     * 第二种情况：
     * 运用反射技术，编制更加灵活的代码
     * @param className 具体工厂类名字的字符串，注意加包名
     * @return 返回具体工厂类的对象
     * 优点：运用反射技术，实现了更加灵活的自动工厂选择功能。当新增具体工厂类时，无需修改抽象工厂类
     *
     */
    static AbstractFactory createR(String className){
        AbstractFactory factory=null;
        try {
            Class c=Class.forName(className);
            factory=(AbstractFactory)c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
}

