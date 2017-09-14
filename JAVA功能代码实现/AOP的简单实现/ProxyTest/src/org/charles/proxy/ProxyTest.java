package org.charles.proxy;

import org.charles.advice.Advice;
import org.charles.advice.MyAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaersi on 2017/9/14.
 */
public class ProxyTest {
    public static void main(String[] args) {
        final List list=new ArrayList();
        Advice advice=new MyAdvice();
        List proxy=(List) getProxy(list,new MyAdvice());
        proxy.add("a");
        proxy.add("b");
        System.out.println(proxy.size());
    }
    public static Object getProxy(final Object target, final Advice advice){
        Object proxyx= Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.beforeInvoke(method);
                        Object resultVal=method.invoke(target,args);
                        advice.afterInvoke(method);
                        return resultVal;
                    }
                }
        );
        return proxyx;
    }
}
