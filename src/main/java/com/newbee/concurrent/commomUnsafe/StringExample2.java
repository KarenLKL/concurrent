package com.newbee.concurrent.commomUnsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 实验证明：StringBuffer是线程安全的
 */
public class StringExample2 {
    public static int threadTotal = 200;
    public static int clientTotal = 5000;

    private static StringBuffer stringBuffer=new StringBuffer();
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(String.format("stringBuilder length:%s", stringBuffer.length()));
    }

    private static void update() {
        stringBuffer.append("1");
    }
}
