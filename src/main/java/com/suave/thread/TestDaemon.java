package com.suave.thread;

import lombok.SneakyThrows;

/**
 * 守护线程
 * 程序只需等待用户线程，无需等待守护线程
 *
 * @author Suave
 * @date 2020/11/19 09:54
 */
public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        // 默认为false，即用户线程
        thread.setDaemon(true);
        thread.start();
        thread.join();
        new Thread(you).start();
    }

}

class God implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(10);
            System.out.println("上帝保佑着你");
        }
    }

}

class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.printf("活到了第%d天%n", i);
        }
        System.out.println("====== goodbye =====");
    }
}
