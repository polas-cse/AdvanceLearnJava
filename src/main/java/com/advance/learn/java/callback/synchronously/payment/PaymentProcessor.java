package com.advance.learn.java.callback.synchronously.payment;

public class PaymentProcessor {

    private final PaymentCallback callback;

    public PaymentProcessor(PaymentCallback callback) {
        this.callback = callback;
    }

    public String processPayment(double amount) {

        System.out.println("Starting payment processing...");

        // Synchronous callback
        boolean isValid = callback.validatePayment(amount);

        if (!isValid) {
            return "Payment failed due to validation error";
        }

        // Main logic continues only after callback
        System.out.println("Processing payment...");

        return "Payment processed successfully";
    }
}