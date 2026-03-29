package com.advance.learn.java.callback.synchronously.fraction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FractionChecker implements FractionCallback{

    static class Logical{
        Predicate<Double> predicate;
        String message;
        Logical(Predicate<Double> predicate, String message){
            this.predicate = predicate;
            this.message = message;
        }
    }

    private List<Logical> logicals = Arrays.asList(
            new Logical(n -> n < 0, "The number is Negative"),
            new Logical(n -> n == 0, "The number is zero"),
            new Logical(n -> n % 1 != 0, "The number is a fraction"),
            new Logical(n -> n % 2 == 0, "The number is even"),
            new Logical(n -> n % 2 != 0, "The number is odd")
    );

    @Override
    public String fraction(double n) {
        return logicals.stream().filter(p-> p.predicate.test(n)).findFirst().map(p->p.message).orElse("Something went wrong");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Double> numbers = Arrays.asList(1.0, -2.0, 3.0, 5.5, 6.0);
        for(Double number : numbers){
            System.out.println(new FractionChecker().fraction(number));
            Thread.sleep(1000);
        }
    }

}
