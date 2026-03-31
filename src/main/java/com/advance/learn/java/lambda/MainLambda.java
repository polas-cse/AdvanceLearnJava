package com.advance.learn.java.lambda;

import java.util.function.*;

public class MainLambda {
    public static void main(String[] args) {

        Supplier<String> sp = ()-> "I'm called from supplier";
        System.out.println(sp.get());

        Consumer<String> con = System.out::println;
        con.accept("I'm called from consumer");

        Function<String, Integer> fc = String::length;
        System.out.println(fc.apply("I'm called from Function"));

        Predicate<Integer> pred = i -> i%2==0;
        System.out.println(pred.test(4) ? "Even" : "Odd");

        UnaryOperator<Integer> un = (i)-> i*i;
        System.out.println(un.apply(4));

        BinaryOperator<Integer> bo = (i,j) -> i*j;
        System.out.println(bo.apply(1,2));

        BiFunction<Integer, Double, String> bf = (a,b) -> "result: "+(a+b);
        System.out.println(bf.apply(10,2.5));

    }
}
