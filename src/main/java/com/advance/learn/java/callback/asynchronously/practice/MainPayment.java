package com.advance.learn.java.callback.asynchronously.practice;

// Main class
public class MainPayment {
    public static void main(String[] args) {
        PaymentServiceAsync paymentService = new PaymentServiceAsync();

        System.out.println("Start payments...");

        paymentService.processPayment("PAY-1001", res -> {
            System.out.println("Callback received: " + res);
            return "PAY-1001";
        });

        paymentService.processPayment("PAY-1002", res -> {
            System.out.println("Callback received: " + res);
            return "PAY-1002";
        });

        System.out.println("Payments submitted!");
        paymentService.shutdown();
    }
}