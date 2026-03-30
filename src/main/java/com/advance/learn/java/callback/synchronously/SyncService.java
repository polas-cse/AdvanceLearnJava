package com.advance.learn.java.callback.synchronously;

public class SyncService {
    public void processTask(Callback callback) {
        System.out.println("Processing task...");

        // simulate work
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        String result = "✅ Task done (Sync)";

        // callback call
        callback.onComplete(result);
    }
}
