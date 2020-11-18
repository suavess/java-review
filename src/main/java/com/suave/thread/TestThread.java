package com.suave.thread;

import lombok.SneakyThrows;

/**
 * 购买火车票的例子
 * 多线程并发操作同一对象
 * 数据紊乱，线程不安全
 *
 * @author Suave
 * @date 2020/11/18 15:39
 */
public class TestThread implements Runnable {

    private Integer ticket = 10;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @SneakyThrows
    public void run() {
        while (ticket > 0) {
            System.out.printf("%s抢到了第%d张票%n", Thread.currentThread().getName(), ticket--);
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        new Thread(testThread, "小明").start();
        new Thread(testThread, "老师").start();
        new Thread(testThread, "黄牛").start();
    }
}
