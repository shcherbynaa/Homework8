package com.hw8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutors {
    static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("First Thread");
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("Second Thread");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyThread1());
        executorService.submit(new MyThread2());
        executorService.shutdown();
    }
}