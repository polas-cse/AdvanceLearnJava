package com.advance.learn.java.lambda.discount;

public class MainCustomLambda {

        public static void main(String[] args) {
            // Lambda for regular customers: 10% discount
            DiscountCalculator regular = price -> price * 0.90;

            // Lambda for premium customers: 20% discount
            DiscountCalculator premium = price -> price * 0.80;

            // Lambda for VIP customers: 30% discount
            DiscountCalculator vip = price -> price * 0.70;

            double originalPrice = 1000;

            System.out.println("Original Price: " + originalPrice);
            System.out.println("Regular Customer: " + regular.applyDiscount(originalPrice));
            System.out.println("Premium Customer: " + premium.applyDiscount(originalPrice));
            System.out.println("VIP Customer: " + vip.applyDiscount(originalPrice));
        }

}
