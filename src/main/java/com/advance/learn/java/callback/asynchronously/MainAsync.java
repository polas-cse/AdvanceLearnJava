package com.advance.learn.java.callback.asynchronously;

public class MainAsync {
    public static void main(String[] args) {

        OrderServiceAsync service = new OrderServiceAsync();

        System.out.println("👉 Start");

        for (int i = 1; i <= 100; i++) {
            int taskNumber = i;
            service.placeOrderAsync(result -> {
                System.out.println("Callback for task " + taskNumber + ": " + result);
            });
        }

        System.out.println("👉 Doing other work...");
        System.out.println("👉 End");
    }
}
