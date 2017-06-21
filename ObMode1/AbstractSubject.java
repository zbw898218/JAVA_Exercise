package DesignMode.ObMode1;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题中间层类，通过此类实现主题接口中的功能，供子类选择性继承
 * Created by Charles on 2017/6/21
 */
public class AbstractSubject <T>implements ISubject {
    private List<IObserver> observers=new ArrayList<>();//观察者集合
    private String t;//要更新的数据对象
    private T t1;
    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }

    @Override

    public void register(IObserver obs) {
        if(!observers.contains(obs)){
            observers.add(obs);
        }
    }

    @Override
    public void unregister(IObserver obs) {
        if(observers.contains(obs)){
            observers.remove(obs);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i=0;i<observers.size();i++){
            observers.get(i).refresh(this);
        }
    }
}
