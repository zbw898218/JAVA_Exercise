package DesignMode.ObMode1;


/**
 * 主题接口，定义通用功能:注册、删除、通知观察等
 * Created by Charles on 2017/6/21
 */
public interface ISubject<T> {
    void register(IObserver obs);
    void unregister(IObserver obs);
    void notifyObservers();
}
