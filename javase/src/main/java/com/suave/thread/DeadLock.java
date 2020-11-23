package com.suave.thread;

import lombok.SneakyThrows;

/**
 * 死锁 多个线程同时抱着对方需要的资源，形成僵持
 *
 * @author Suave
 * @date 2020/11/19 14:42
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup(0,"灰姑娘");
        Makeup m2 = new Makeup(1,"白雪公主");
        m1.start();
        m2.start();
    }
}

/**
 * 口红
 */
class Lipstick {

}

/**
 * 镜子
 */
class Mirror {

}

class Makeup extends Thread {
    /**
     * 需要的资源只有一份
     */
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    /**
     * 选择
     */
    int choice;
    /**
     * 使用化妆品的人
     */
    String girlName;

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @SneakyThrows
    @Override
    public void run() {
        makeup();
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            /**
             * 获得口红的锁
             */
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红锁");
                Thread.sleep(1000);
                /**
                 * 一秒后获得镜子锁
                 */
//                synchronized (mirror) {
//                    System.out.println(this.girlName + "获得镜子锁");
//                }
            }
            /**
             * 一秒后获得镜子锁
             */
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子锁");
            }
        } else {
            /**
             * 获得镜子的锁
             */
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子锁");
                Thread.sleep(1000);
                /**
                 * 一秒后获得口红锁
                 */
//                synchronized (lipstick) {
//                    System.out.println(this.girlName + "获得口红锁");
//                }
            }
            /**
             * 一秒后获得口红锁
             */
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红锁");
            }
        }
    }
}

