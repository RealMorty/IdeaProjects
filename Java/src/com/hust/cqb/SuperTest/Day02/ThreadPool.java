package com.hust.cqb.SuperTest.Day02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new RunnableImpl()) ;
        executorService.submit(new RunnableImpl()) ;
        executorService.submit(new RunnableImpl()) ;

        executorService.shutdown();
    }
}
























