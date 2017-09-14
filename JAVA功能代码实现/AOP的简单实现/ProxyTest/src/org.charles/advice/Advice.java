package org.charles.advice;

import java.lang.reflect.Method;

/**
 * Created by chaersi on 2017/9/14.
 */
public interface Advice {
    void beforeInvoke(Method method);
    void afterInvoke(Method method);
}
