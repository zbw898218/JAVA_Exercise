package DesignMode.ObMode1;

/**
 * Created by Charles on 2017/6/21
 */
    public class Observer1 implements IObserver {
    private static final int MARK=1;

    @Override
    public void refresh(ISubject sub) {
        Subject1 subject=(Subject1)sub;
        System.out.println("update:"+subject.getT1());

    }

    @Override
    public int getMark() {
        return MARK;
    }
}
