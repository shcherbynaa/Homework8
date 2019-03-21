package com.hw8.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyCallableFuture {

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int result = 0;
            while (result != 10) {
                ++result;
            }
            Thread.sleep(1000);
            return result;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}
