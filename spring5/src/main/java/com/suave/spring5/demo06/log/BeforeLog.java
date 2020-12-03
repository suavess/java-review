package com.suave.spring5.demo06.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Suave
 * @date 2020/12/2 19:40
 */
public class BeforeLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + " 的 " + method.getName() + " 方法被执行了~");
    }
}
