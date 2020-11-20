package com.suave.annotation;

import java.lang.annotation.*;

/**
 * 测试元注解
 * @author Suave
 * @date 2020/11/20 16:29
 */
@MyAnnotation
public class Test01 {
    @MyAnnotation
    public void test(){

    }
}

/**
 * 定义一个注解
 * Target表示注解可以用在哪些地方
 * Retention表示注解在什么地方还有效
 * runtime > class > sources
 * Documented表示是否将注解生成在JavaDoc中
 * Inherited子类可以继承父类注解
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

}