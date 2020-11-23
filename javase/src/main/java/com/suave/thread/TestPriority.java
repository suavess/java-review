package com.suave.thread;

/**
 * 优先级低只是获得调度的概率低，并不是绝对的
 * @author Suave
 * @date 2020/11/19 09:39
 */
public class TestPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "->" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        TestPriority testPriority = new TestPriority();
        System.out.println(Thread.currentThread().getName() + "->" + Thread.currentThread().getPriority());
        Thread thread1 = new Thread(testPriority);
        Thread thread2 = new Thread(testPriority);
        Thread thread3 = new Thread(testPriority);
        thread1.setPriority(1);
        thread2.setPriority(8);
        thread3.setPriority(10);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
