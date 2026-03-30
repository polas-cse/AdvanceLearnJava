package com.advance.learn.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AgeProcessor {

    // Define an AgeRange class with a predicate and message
    static class AgeRange {
        Predicate<Double> condition;
        String message;

        AgeRange(Predicate<Double> condition, String message) {
            this.condition = condition;
            this.message = message;
        }
    }

    private final List<AgeRange> ageRanges = Arrays.asList(
            new AgeRange(age -> age < 18, "You are a minor (under 18)."),
            new AgeRange(age -> age >= 18 && age <= 24, "You are a young adult (18-24)."),
            new AgeRange(age -> age >= 25 && age <= 34, "You are an adult (25-34)."),
            new AgeRange(age -> age >= 35 && age <= 44, "You are in your mid-adult years (35-44)."),
            new AgeRange(age -> age >= 45 && age <= 54, "You are in your mature adult years (45-54)."),
            new AgeRange(age -> age >= 55 && age <= 64, "You are approaching senior age (55-64)."),
            new AgeRange(age -> age >= 65 && age <= 69, "You are a senior (65-69)."),
            new AgeRange(age -> age >= 70 && age <= 79, "You are an elderly person (70-79)."),
            new AgeRange(age -> age >= 80, "You are 80 or older – long life!")
    );

    // Lambda expression to find the message for the age
    public String processAge(double age) {
        return ageRanges.stream()
                .filter(range -> range.condition.test(age))
                .findFirst()
                .map(range -> range.message)
                .orElse("Age not categorized");
    }

    public static void main(String[] args) throws InterruptedException {
        AgeProcessor processor = new AgeProcessor();

        double[] testAges = {15, 22, 30, 40, 50, 60, 68, 75, 85};

        for (double age : testAges) {
            System.out.println("Age: " + age + " -> " + processor.processAge(age));
            Thread.sleep(1000);
        }
    }
}