package com.advance.learn.java.lambda.discount;

@FunctionalInterface
public interface DiscountCalculator {
    double applyDiscount(double price); // returns discounted price
}