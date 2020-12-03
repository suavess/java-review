package com.suave.spring5.demo06;

import com.suave.spring5.demo06.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Suave
 * @date 2020/12/3 17:44
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.insert();
        userService.delete();
        userService.update();
        userService.select();
    }
}
