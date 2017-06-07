package DesignMode.FectoryMode.Example;

/**
 * Created by Charles on 2017/6/7
 */
public class ImageFactory extends AbstractFactory {
    @Override
    public IRead create() {
        return new ImageRead();//图像工厂产生具体读图像类
    }
}
