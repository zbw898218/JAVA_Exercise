package DesignMode.FectoryMode.Mode;

/**
 * 定义高档工厂
 * Created by Charles on 2017/6/7
 */
public class TopFactory extends AbstractFactory1 {
    /**
     * 高档工厂生产高档小汽车对象
     * @return 高档小汽车对象
     */
    @Override
    public ICar createCar() {
        return new TopCar();
    }

    /**
     * 高档工厂生产高档公共汽车对象
     * @return 高档公共汽车对象
     */
    @Override
    public IBus createBus() {
        return new UpBus();
    }
}
