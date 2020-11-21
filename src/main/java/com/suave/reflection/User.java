package com.suave.reflection;

import lombok.*;

/**
 * @author Suave
 * @date 2020/11/21 09:22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String name;
    private int id;
    private int age;
}
