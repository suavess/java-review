package com.suave.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全的ArrayList
 * 1、使用new Vector<>()
 * 2、使用Collections集合工具类的Collections.SynchronizeList(new ArrayList<>());
 * 3、使用new CopyOnWriteArrayList<> ()
 *
 * @author Suave
 * @date 2020/11/19 13:57
 */
public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
