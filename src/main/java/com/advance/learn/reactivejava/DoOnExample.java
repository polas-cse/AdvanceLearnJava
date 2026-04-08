package com.advance.learn.reactivejava;

import reactor.core.publisher.Flux;

public class DoOnExample {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("A", "B", "C")
                .map(value -> {
                    if (value.equals("B")) {
                        throw new RuntimeException("Error at B");
                    }
                    return value.toLowerCase();
                })
                .doOnSubscribe(sub -> System.out.println("Subscribed to stream"))
                .doOnNext(data -> System.out.println("Processing: " + data))
                .doOnError(error -> System.out.println("Error occurred: " + error.getMessage()))
                .doOnComplete(() -> System.out.println("Stream completed successfully"))
                .doFinally(signal -> System.out.println("Stream finished with signal: " + signal));
        flux.subscribe(
                data -> System.out.println("Received: " + data),
                err -> System.out.println("Subscriber received error")
        );
    }
}
