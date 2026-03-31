package com.advance.learn.java.lambda.msg;

public class MainLambda {
    public static void main(String[] args) {

        Greeting greeting = msg-> System.out.println("HI "+msg);
        greeting.say("Polas");

    }
}
