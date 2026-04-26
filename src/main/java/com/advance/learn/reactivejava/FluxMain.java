package com.advance.learn.reactivejava;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxMain {
    public static void main(String[] args) {
        Flux<String> flux = Flux.fromIterable(List.of("abc","bcd"));
        Mono<String> mono = Mono.just("hello");
    }
}
