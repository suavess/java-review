package com.suave.spring5.demo04;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Suave
 * @date 2020/11/24 17:16
 */
@Getter
@Setter
@ToString
public class People {
    private String name;
    private Dog dog;
    private Cat cat;
}
