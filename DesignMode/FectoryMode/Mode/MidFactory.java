package DesignMode.FectoryMode.Mode;

/**
 * 定义中档工厂
 * Created by Charles on 2017/6/7
 */
public class MidFactory extends AbstractFactory1 {
    /**
     * 中档工厂生产中档小汽车
     * @return 返回中档小汽车对象
     */
    @Override
    public ICar createCar() {
        return new MidCar();
    }

    /**
     * 中档工厂生产中档公共汽车
     * @return 返回中档公共汽车对象
     */
    @Override
    public IBus createBus() {
        return new MidBus();
    }
}
