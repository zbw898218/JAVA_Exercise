package DesignMode.ObMode1;

/**
 * 观察者接口，定义获取/刷新数据功能
 * Created by Charles on 2017/6/21
 */
public interface IObserver<T> {
   void refresh(ISubject<T> sub);
   int getMark();
}
