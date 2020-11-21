package com.suave.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author Suave
 * @date 2020/11/20 19:40
 */
public class Test02 {
    /**
     * 如果没有默认值就必须赋值
     */
    @MyAnnotation2(name = "Suave",schools = {"杭电"})
    public void test02(){
        
    }
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    /**
     * 注解的参数 ：参数类型 + 参数名()
     */
    String name() default "";
    int age() default 0;

    /**
     * 默认值为-1表示不存在
     */
    int id() default -1;

    String[] schools() default {"清华"};
}