package com.advance.learn.java.callback.synchronously.payment;

public class PaymentValidationService implements PaymentCallback {

    @Override
    public boolean validatePayment(double amount) {
        System.out.println("Validating payment...");

        if (amount <= 0) {
            return false;
        }

        System.out.println("Payment validated successfully");
        return true;
    }
}