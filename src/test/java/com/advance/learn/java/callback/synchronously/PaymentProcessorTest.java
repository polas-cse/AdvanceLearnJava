package com.advance.learn.java.callback.synchronously;

import com.advance.learn.java.callback.synchronously.payment.PaymentCallback;
import com.advance.learn.java.callback.synchronously.payment.PaymentProcessor;
import com.advance.learn.java.callback.synchronously.payment.PaymentValidationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    @Test
    void testSuccessfulPayment() {
        PaymentCallback callback = new PaymentValidationService();
        PaymentProcessor processor = new PaymentProcessor(callback);

        String result = processor.processPayment(100.0);
        System.out.println(result);
        assertEquals("Payment processed successfully", result);
    }

    @Test
    void testFailedPayment() {
        PaymentCallback callback = new PaymentValidationService();
        PaymentProcessor processor = new PaymentProcessor(callback);

        String result = processor.processPayment(-10.0);
        System.out.println(result);
        assertEquals("Payment failed due to validation error", result);
    }
}