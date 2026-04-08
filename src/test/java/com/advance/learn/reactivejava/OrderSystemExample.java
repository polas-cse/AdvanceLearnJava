package com.advance.learn.reactivejava;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;

public class OrderSystemExample {

    public static void main(String[] args) {

        // 🔥 Shared virtual time
        VirtualTimeScheduler vts = VirtualTimeScheduler.getOrSet();

        // 🛒 Order created
        Mono<String> order = Mono.just("Order Created")
                .doOnNext(System.out::println);

        // ⏱ Payment timeout after 10 sec
        Mono<String> paymentTimeout =
                Mono.delay(Duration.ofSeconds(10), vts)
                        .map(i -> "❌ Order Cancelled (Payment Timeout)");

        // 🔄 Status checker every 2 sec
        Flux<String> statusChecker =
                Flux.interval(Duration.ofSeconds(2), vts)
                        .map(i -> "Checking payment status... " + i)
                        .take(5);

        // Subscribe all
        order.subscribe(System.out::println);
        statusChecker.subscribe(System.out::println);
        paymentTimeout.subscribe(System.out::println);

        // ⏩ Move time forward (simulate 10 seconds instantly)
        vts.advanceTimeBy(Duration.ofSeconds(10));
    }
}


