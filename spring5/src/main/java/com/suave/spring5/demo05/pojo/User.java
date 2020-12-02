package com.suave.spring5.demo05.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Suave
 * @date 2020/12/2 14:18
 */
@Getter
@Setter
@ToString
public class User {
    @Value("1234")
    private String name;
}
