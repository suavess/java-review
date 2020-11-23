package com.suave.spring5.demo01;

import com.suave.spring5.demo01.dao.UserDao;
import com.suave.spring5.demo01.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Suave
 * @date 2020/11/23 10:45
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userService.print(userDao);
    }
}
