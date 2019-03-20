package com.hw8.concurrency;

import java.sql.Time;
import java.util.concurrent.*;

public class MyThreadPoolExecutor {

    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("Thread started " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Thread finished " + Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,6,1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 5; i++) {
            MyCallable callable = new MyCallable();
            poolExecutor.submit(callable);
        }
        poolExecutor.shutdown();
    }
}
