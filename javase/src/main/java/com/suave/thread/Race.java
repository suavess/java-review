package com.suave.thread;

/**
 * 龟兔赛跑
 *
 * @author Suave
 * @date 2020/11/18 15:49
 */
public class Race implements Runnable {

    private static String winner;

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
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%s-->跑了%d步%n", Thread.currentThread().getName(), i);
            if (gameOver(i)) {
                break;
            }
        }
    }

    // 判断是否结束
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.printf("winner is %s", winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
