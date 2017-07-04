package DesignMode.ObMode1;

/**
 * 测试类
 * Created by Charles on 2017/6/21
 */
public class Test01 {
    public static void main(String[] args){

        AbstractSubject<Person> abs=new Subject1();
        IObserver<Person> obs=new Observer1();
        abs.register(obs);
        abs.setT1(new Person("Charles",25));
        abs.notifyObservers();
    }
}
