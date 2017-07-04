package DesignMode.FectoryMode.Example;

/**
 * 定义读文件接口
 * Created by Charles on 2017/6/7
 */
public interface IRead<T> {
    T read(String... in);
}
