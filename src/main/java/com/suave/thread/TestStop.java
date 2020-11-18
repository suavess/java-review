package com.suave.thread;

/**
 * 测试停止线程
 * 1.建议线程正常停止-->利用次数，不建议死循环
 * 2.建议使用标志位-->设置一个标志位
 * 3.不要使用stop或者destroy等过时或者jdk不建议的方法
 *
 * @author Suave
 * @date 2020/11/18 20:17
 */
public class TestStop implements Runnable {

    private boolean flag = true;

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main " + i);
            if (i == 900){
                testStop.stop();
            }
        }
    }

    public void stop(){
        this.flag = false;
        System.out.println("线程该停止了~");
    }

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
    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run Thread " + i++);
        }
    }
}
