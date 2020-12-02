package com.suave.spring5.demo05;

import com.suave.spring5.demo05.config.MyConfiguration;
import com.suave.spring5.demo05.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Suave
 * @date 2020/12/2 14:22
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
