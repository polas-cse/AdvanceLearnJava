package com.advance.learn.java.callback.synchronously;

public class MainSync {
    public static void main(String[] args) {

        SyncService service = new SyncService();

        System.out.println("👉 Start");

        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            service.processTask(result -> {
                System.out.println("Callback for task " + taskNumber + ": " + result);
            });
        }

        System.out.println("👉 Doing other work...");
        System.out.println("👉 End");
    }
}
