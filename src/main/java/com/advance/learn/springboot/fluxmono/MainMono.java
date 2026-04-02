package com.advance.learn.springboot.fluxmono;

import reactor.core.publisher.Mono;

public class MainMono {

    public static Mono<String> monoNames(){
        return Mono.just("A");
    }

    public static void main(String[] args) {
        MainMono.monoNames()
                .map(String::toUpperCase)
                .log()
                .defaultIfEmpty("Hello")
                .subscribe(name -> System.out.println("Name: "+name));
    }
}
