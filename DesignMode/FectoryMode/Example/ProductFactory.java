package DesignMode.FectoryMode.Example;

/**
 * 反射技术对抽象工厂最恰当。抽象工厂对应多产品簇，每个具体工厂包含多种产品
 * 从层次清晰角度说：应先得到具体工厂，再得到该工厂中某个具体产品
 *
 * 同时：对于简单工厂和工厂模式来说，都对应单一产品簇
 * 在反射技术下，没必要利用反射先产生具体工厂，再产生具体产品，直接用反射产生具体产品就可以了，而且该类也可由抽象类变成普通类
 * Created by Charles on 2017/6/7
 */
public class ProductFactory {
    static IRead create(String className){
        IRead product=null;
        try {
            Class c=Class.forName(className);
            product=(IRead)c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
