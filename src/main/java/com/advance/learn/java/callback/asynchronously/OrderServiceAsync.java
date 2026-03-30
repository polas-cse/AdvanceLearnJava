package com.advance.learn.java.callback.asynchronously;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderServiceAsync {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void placeOrderAsync(OrderCallback callback) {

        executor.submit(() -> {
            System.out.println("🛒 Order received...");

            try {
                Thread.sleep(2000); // simulate processing
            } catch (Exception e) {}

            callback.onComplete("✅ Order processed successfully");
        });
    }

}
