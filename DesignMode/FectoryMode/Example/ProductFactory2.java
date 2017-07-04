package DesignMode.FectoryMode.Example;

/**
 *运用泛型技术+反射技术，可以得到更加通用一般的形式。
 *
 * Created by Charles on 2017/6/7
 */
public class ProductFactory2<T> {//T:定义的产品接口
    public T create(String className){//具体的产品类名
        T product=null;//产品初始化为null
        try {
            Class c=Class.forName(className);
            product=(T)c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
