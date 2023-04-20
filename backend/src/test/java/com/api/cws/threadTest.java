package com.api.cws;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class threadTest {

    @Test
    public void test() {
        MyThread myThread = new MyThread();
        myThread.start(); // 스레드 실행

        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(1000); // 1초간 일시 정지
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("MyThread: " + i);
                try {
                    sleep(1000); // 1초간 일시 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            int result = 0;
            for (int i = 0; i < 10; i++) {
                result += i;
                Thread.sleep(1000); // 1초간 일시 정지
            }
            return result;
        };

        Future<Integer> future = executor.submit(task);

        while (!future.isDone()) {
            System.out.println("Waiting for the result...");
            Thread.sleep(1000); // 1초간 일시 정지
        }

        int result = future.get();
        System.out.println("Result: " + result);

        executor.shutdown();
    }

    @Test
    public void test3() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(i -> executor.execute( () -> {
            // TimeUnit.MILLISECONDS.sleep(1000);
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        }));
    }

    @Test
    public void test4() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        final List<Integer> integers = Arrays.asList(1,2,3,4,5);

        Future<Integer> future = executor.submit(() -> {
            // TimeUnit.MILLISECONDS.sleep(5000);
            int result = integers.stream().mapToInt(i -> i.intValue()).sum();
            return result;
        });
        try {
            Integer result = future.get();
            System.out.print("result: " + result);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
