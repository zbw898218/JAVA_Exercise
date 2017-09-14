package org.charles.advice;

import java.lang.reflect.Method;

/**
 * Created by chaersi on 2017/9/14.
 */
public class MyAdvice implements Advice {
    private Long beginTime;
    private Long endTime;
    @Override
    public void beforeInvoke(Method method) {
        System.out.println("前置增强开始！");
        beginTime=System.currentTimeMillis();
    }

    @Override
    public void afterInvoke(Method method) {
        endTime=System.currentTimeMillis();
        System.out.println("方法：--> "+method.getName()+",执行消耗的时间：--> "+(endTime-beginTime)+" 毫秒！" );
        System.out.println("后置增强结束！");
    }
}
