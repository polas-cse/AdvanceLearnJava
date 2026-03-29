package com.advance.learn.java.callback.synchronously.age;

public class AgeProcessor {

    private final AgeCallback ageCallback;

    public AgeProcessor(AgeCallback ageCallback) {
        this.ageCallback = ageCallback;
    }

    public String processAge(double age) {
        System.out.println("Starting age processing...");

        String msg = this.ageCallback.processAge(age);

        System.out.println("Message: " + msg);

        System.out.println("Ending age processing...");

        return msg;

    }

}
