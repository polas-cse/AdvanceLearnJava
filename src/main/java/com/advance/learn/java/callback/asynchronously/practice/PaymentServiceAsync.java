package com.advance.learn.java.callback.asynchronously.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Payment Service
class PaymentServiceAsync {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public void processPayment(String paymentId, PaymentCallback callback) {
        executor.submit(() -> {
            System.out.println("Processing start...");

            try {
                Thread.sleep(2000); // simulate payment processing
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String response = "✅ Payment '" + paymentId + "' completed successfully";
            String callbackResult = callback.onComplete(response);
            System.out.println(Thread.currentThread().getName() + " 📦 Callback returned ID: " + callbackResult);
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}