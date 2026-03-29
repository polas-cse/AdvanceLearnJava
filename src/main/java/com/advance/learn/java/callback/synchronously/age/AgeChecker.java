package com.advance.learn.java.callback.synchronously.age;

public class AgeChecker implements AgeCallback {

    @Override
    public String processAge(double age) {
        System.out.println("Calculating age for age: " + age);
        String msg;

        if (age < 18) {
            msg = "You are a minor (under 18).";
        } else if (age <= 24) {
            msg = "You are a young adult (18-24).";
        } else if (age <= 34) {
            msg = "You are an adult (25-34).";
        } else if (age <= 44) {
            msg = "You are in your mid-adult years (35-44).";
        } else if (age <= 54) {
            msg = "You are in your mature adult years (45-54).";
        } else if (age <= 64) {
            msg = "You are approaching senior age (55-64).";
        } else if (age <= 69) {
            msg = "You are a senior (65-69).";
        } else if (age <= 79) {
            msg = "You are an elderly person (70-79).";
        } else {
            msg = "You are 80 or older – long life!";
        }

        System.out.println("Age calculated successfully");
        return msg;
    }

}
