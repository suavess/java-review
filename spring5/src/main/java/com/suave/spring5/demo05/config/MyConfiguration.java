package com.suave.spring5.demo05.config;

import com.suave.spring5.demo05.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Suave
 * @date 2020/12/2 14:20
 */
@Configuration
public class MyConfiguration {

    @Bean
    public User getUser() {
        return new User();
    }

}
