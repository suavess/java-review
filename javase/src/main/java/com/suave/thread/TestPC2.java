package com.suave.thread;

import lombok.SneakyThrows;

/**
 * 测试生产者消费者问题2
 * 信号灯法
 * @author Suave
 * @date 2020/11/19 16:13
 */
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

/**
 * 生产者->演员
 */
class Player extends Thread {

    private TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("快乐大本营");
            } else {
                this.tv.play("广告");
            }
        }
    }
}

/**
 * 消费者->观众
 */
class Watcher extends Thread {
    private TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

/**
 * 产品->节目
 * 演员录制节目时，观众等待
 * 观众观看时，演员等待
 */
class TV {
    /**
     * 表演的节目
     */
    String voice;
    boolean flag = true;

    /**
     * 表演
     *
     * @param voice
     */
    public synchronized void play(String voice) throws InterruptedException {
        if (!flag) {
            this.wait();
        }
        System.out.println("演员表演了:" + voice);
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    /**
     * 观看
     */
    public synchronized void watch() throws InterruptedException {
        if (flag) {
            this.wait();
        }
        System.out.println("观众观看了:" + voice);
        // 观看完通知
        this.notifyAll();
        this.flag = !this.flag;
    }

}