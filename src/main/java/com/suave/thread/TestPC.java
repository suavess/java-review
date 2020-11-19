package com.suave.thread;

import lombok.SneakyThrows;

/**
 * 测试生产者消费者问题
 * wait方法和notify方法
 * 管程法
 *
 * @author Suave
 * @date 2020/11/19 15:35
 */
public class TestPC {
    public static void main(String[] args) {
        SyncContainer container = new SyncContainer();
        Consumer consumer = new Consumer(container);
        Producer producer = new Producer(container);
        consumer.start();
        producer.start();
    }
}

/**
 * 生产者
 */
class Producer extends Thread {
    SyncContainer container;

    public Producer(SyncContainer container) {
        this.container = container;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }

}

/**
 * 消费者
 */
class Consumer extends Thread {
    SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            container.pop();
            System.out.println("消费了" + i + "只鸡");
        }
    }
}

/**
 * 产品
 */
class Chicken {
    /**
     * 产品编号
     */
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

/**
 * 缓冲区
 */
class SyncContainer {
    /**
     * 容器大小
     */
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    /**
     * 生产者放入产品
     */
    public synchronized void push(Chicken chicken) throws InterruptedException {
        if (count == chickens.length) {
            //如果容器满了就需要等待消费者消费
            this.wait();
        }

        // 如果没有满就丢入容器
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    /**
     * 消费者消费产品
     */
    public synchronized Chicken pop() throws InterruptedException {
        if (count == 0) {
            // 等待生产者生产
            this.wait();
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }

}