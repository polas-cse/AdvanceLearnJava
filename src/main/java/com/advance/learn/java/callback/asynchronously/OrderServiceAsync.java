package com.advance.learn.java.callback.asynchronously;

import java.util.concurrent.*;

public class OrderServiceAsync {

    // 1️⃣ Fixed Thread Pool
    // Always maintains 10 threads.
    // Extra tasks wait in the queue until a thread is free.
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    // 2️⃣ Single Thread Executor
    // Only 1 thread. Tasks execute **one by one** in order.
    // Useful when order of execution matters.
    private final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    // 3️⃣ Dynamic Thread Pool with limits (ThreadPoolExecutor)
    // Core threads = 10 → always keep 10 threads running
    // Max threads = 100 → can scale up to 100 threads if load increases
    // Idle threads above core threads terminate after 60 seconds
    // Tasks beyond max threads are put into the queue
    ExecutorService dynamicThreadPool = new ThreadPoolExecutor(
            10,   // core threads (minimum always alive)
            100,  // maximum threads allowed
            60, TimeUnit.SECONDS,  // idle thread timeout above core threads
            new LinkedBlockingQueue<>() // queue for pending tasks
    );

    public void placeOrderAsync(OrderCallback callback) {

        dynamicThreadPool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 🛒 Order received...");

            try {
                Thread.sleep(2000); // simulate processing
            } catch (Exception e) {}

            callback.onComplete("✅ Order processed successfully");
        });
    }

}
