package com.advance.learn.java.callback.synchronously;

import com.advance.learn.java.callback.synchronously.age.AgeCallback;
import com.advance.learn.java.callback.synchronously.age.AgeChecker;
import com.advance.learn.java.callback.synchronously.age.AgeProcessor;
import com.advance.learn.java.callback.synchronously.payment.PaymentCallback;
import com.advance.learn.java.callback.synchronously.payment.PaymentProcessor;
import com.advance.learn.java.callback.synchronously.payment.PaymentValidationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeProcessorTest {

    @Test
    void testSuccessfullyAge() {
        AgeCallback ageCallback = new AgeChecker();
        AgeProcessor ageProcessor = new AgeProcessor(ageCallback);
        String msg = ageProcessor.processAge(15);
        assertEquals("You are a minor (under 18).", msg);
    }

    @Test
    void testFailedAge() {
        AgeCallback ageCallback = new AgeChecker();
        AgeProcessor ageProcessor = new AgeProcessor(ageCallback);
        String msg = ageProcessor.processAge(90);
        assertEquals("You are 80 or older – long life!", msg);
    }
}