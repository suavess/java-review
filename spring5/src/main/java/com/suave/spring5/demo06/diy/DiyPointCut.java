package com.suave.spring5.demo06.diy;

/**
 * @author Suave
 * @date 2020/12/3 19:26
 */
public class DiyPointCut {

    public void before() {
        System.out.println("================ 方法执行前 ================");
    }

    public void after() {
        System.out.println("================ 方法执行后 ================");
    }
}
