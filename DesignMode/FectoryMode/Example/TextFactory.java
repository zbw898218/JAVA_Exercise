package DesignMode.FectoryMode.Example;

/**
 * 定义具体工厂
 * Created by Charles on 2017/6/7
 */
public class TextFactory extends AbstractFactory{
    @Override
    public IRead create() {
        return new TextRead();//文件工厂产生具体的读文件类
    }
}
