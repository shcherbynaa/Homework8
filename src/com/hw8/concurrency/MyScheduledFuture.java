package com.hw8.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MyScheduledFuture {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getName());
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            System.out.println(this.getName());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new MyThread(), 10, TimeUnit.SECONDS);
        ScheduledFuture scheduledFuture1 = scheduledExecutorService.schedule(new MyThread2(), 3, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }

}
