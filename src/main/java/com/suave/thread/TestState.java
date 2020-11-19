package com.suave.thread;

import lombok.SneakyThrows;

/**
 * state线程状态
 * @author Suave
 * @date 2020/11/19 09:19
 */
public class TestState implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("线程开始执行~");
        Thread.sleep(5000);
        System.out.println("线程结束执行~");
    }

    public static void main(String[] args) throws InterruptedException {
        TestState testState = new TestState();
        Thread thread = new Thread(testState);
        thread.start();
        while (thread.getState().equals(Thread.State.TERMINATED)){
            Thread.State state = thread.getState();
            System.out.println(state);
            Thread.sleep(1000);
        }
    }
}
