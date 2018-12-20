package com.newbee.concurrent.current;

import com.newbee.concurrent.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * CopyOnWriteArrayList——并发容器
 * 1、写操作时候，复制一份进行修改。修改完后指向最新修改后的副本。保证写操作正确
 * 2、读操作，读的是元数据，不加锁，访问快。
 * 3、写操作加锁
 */
@ThreadSafe
public class CopyOnWriteArrayListExample {
    private final static Logger LOGGER = LoggerFactory.getLogger(CopyOnWriteArrayListExample.class);

    public static int threadTotal = 200;
    public static int clientTotal = 5000;

    public static List<Integer> list = new CopyOnWriteArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            final Integer value = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(value);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        LOGGER.info("copyOnWriteArrayList size:{}", list.size());
    }

    private static void add(Integer value) {
        list.add(value);
    }
}
