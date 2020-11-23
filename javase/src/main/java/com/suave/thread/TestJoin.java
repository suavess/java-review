package com.suave.thread;

/**
 * join()方法会等待当前线程执行完毕再继续执行其他线程
 * @author Suave
 * @date 2020/11/19 09:06
 */
public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin, "join线程");
        for (int i = 0; i < 500; i++) {
            if (i == 200){
                thread.start();
                thread.join(10);
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}
