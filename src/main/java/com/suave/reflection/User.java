package com.suave.reflection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Suave
 * @date 2020/11/21 09:22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int id;
    private int age;
}
