package com.suave.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Suave
 * @date 2020/11/21 09:23
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.suave.reflection.User");
        /**
         * 获取包名+类名
         */
        System.out.println(c1.getName());
        /**
         * 获取类名
         */
        System.out.println(c1.getSimpleName());
//        只能获取到本类及其父类的public属性
//        Field[] fields = c1.getFields();
        // 可以获得所有属性
        Field[] fields = c1.getDeclaredFields();
        Iterator<Field> iterator = Arrays.stream(fields).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        只能获取到本类及其父类的public属性
//        Field name = c1.getField("name");
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
//        只能获取到本类及其父类的public方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }
//        只能获取到本类的所有方法
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("DeclaredMethod：" + method);
        }
//        获取指定方法
        Method getName = c1.getMethod("getName");
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
//        获得所有构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("#" + constructor);
        }
//        获得指定构造器
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println("指定的有参构造：" + constructor);
    }
}
