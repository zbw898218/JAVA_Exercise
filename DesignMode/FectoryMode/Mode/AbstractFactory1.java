package DesignMode.FectoryMode.Mode;

/**
 * Created by Charles on 2017/6/7
 */

/**
 * 定义抽象子工厂：
 * 1：具有相同特征的小汽车、公共汽车放在相同的工厂中；
 * 2：该类也是抽象类，表明“特征” 是多个，本例中“特征”表示“高档”及“中档”，差别要在子类中体现
 */
public abstract class AbstractFactory1 extends AbstractFactory {
    public abstract ICar createCar();//产生小汽车对象
    public abstract IBus createBus();//产生公共汽车对象
}
