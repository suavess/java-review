package com.suave.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Suave
 * @date 2020/11/21 10:11
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获得class对象
        Class c1 = Class.forName("com.suave.reflection.User");
        // 构造一个对象,默认调用了无参构造器
        User user = (User) c1.newInstance();
        System.out.println(user);

        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) declaredConstructor.newInstance("Suave",10,20);
        System.out.println(user2);

        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user2,"King");
        System.out.println(user2);

        Field name = c1.getDeclaredField("name");
        // 不能直接操作私有属性，需要设置允许访问
        name.setAccessible(true);
        name.set(user2,"Test");
        System.out.println(user2);
    }
}
