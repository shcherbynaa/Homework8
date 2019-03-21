package com.hw8.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyForkFoinPool {

    private final static int numOperations = 1000;
    private final static int numThreads = Runtime.getRuntime().availableProcessors();

    static class MyFork extends RecursiveTask<Integer> {

        int begin;
        int end;

        public MyFork(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if ((end - begin) <= numOperations / numThreads) {
                int result = 1;
                for (int i = begin; i < end; i++) {
                    result = result + i;
                }
                return result;
            }else {
                int middle = (begin + end)/2;
                MyFork firstPart = new MyFork(begin, middle);
                firstPart.fork();

                MyFork secondPart = new MyFork(middle + 1, end);
                int secondValue = secondPart.compute();
                return firstPart.join() + secondValue;
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(numThreads);
        System.out.println(forkJoinPool.invoke(new MyFork(1, numOperations)));
    }

}
