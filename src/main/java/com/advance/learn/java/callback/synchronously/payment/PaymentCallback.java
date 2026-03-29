package com.advance.learn.java.callback.synchronously.payment;

public interface PaymentCallback {
    boolean validatePayment(double amount);
}