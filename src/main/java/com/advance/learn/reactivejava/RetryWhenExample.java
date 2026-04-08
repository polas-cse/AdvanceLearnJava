package com.advance.learn.reactivejava;

import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryWhenExample {
    static int attempt = 0;

    public static void main(String[] args) {

        Flux<String> flux = Flux.just("A", "B", "C")
                .map(value -> {
                    if (value.equals("B")) {
                        attempt++;
                        System.out.println("Processing " + value + ", attempt: " + attempt);
                        throw new RuntimeException("Temporary Error");
                    }
                    return value;
                })
                .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(1))
                        .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                                new RuntimeException("Retries exhausted: " + retrySignal.totalRetries()))
                );

        flux.subscribe(
                System.out::println,
                err -> System.out.println("Final Error: " + err.getMessage())
        );
    }
}



