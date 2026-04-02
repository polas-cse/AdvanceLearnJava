package com.advance.learn.springboot.fluxmono;

import reactor.core.publisher.Flux;

import java.util.List;

public class MainFlux {

    public static Flux<String> fluxNames(){
        return Flux.fromIterable(List.of("a", "aa", "aaa","aaaa"));
    }

    public static void main(String[] args) {
        MainFlux.fluxNames()
                .map(String::toUpperCase)
                .filter(s->s.length()>2)
                .subscribe(name -> System.out.println("Name: "+name));
    }
}
