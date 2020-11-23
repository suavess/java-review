package com.suave.thread;

import java.util.concurrent.*;

/**
 * 线程实现--实现callable接口
 * 优点：
 * 1.可以定义返回值
 * 2.可以抛出异常
 * @author Suave
 * @date 2020/11/18 16:12
 */
public class TestCallable implements Callable<Boolean> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public Boolean call() throws Exception {
        System.out.printf("%s执行----%n",Thread.currentThread().getName());
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testCallable1 = new TestCallable();
        TestCallable testCallable2 = new TestCallable();
        TestCallable testCallable3 = new TestCallable();

        // 执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> result1 = executorService.submit(testCallable1);
        Future<Boolean> result2 = executorService.submit(testCallable2);
        Future<Boolean> result3 = executorService.submit(testCallable3);

        Boolean r1 = result1.get();
        Boolean r2 = result2.get();
        Boolean r3 = result3.get();

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);

        executorService.shutdown();

    }
}
