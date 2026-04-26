package com.advance.learn.reactivejava;

import java.util.List;

public class ReactiveJava {

    private static List<String> getNames() {
        return List.of("Polas", "Naime", "Jakariya", "Jakir", "Mim", "Shopon");
    }

    public static void main(String[] args) {
        List<String> names = getNames()
                .stream()
                .map(String::toUpperCase)
                .filter(name -> {
                    if(name.length() <= 3) {
                        System.out.println("Your name length is too short. your name length is " + name.length());
                        return false;
                    }
                    return true;
                })
                .toList();
        names.forEach(name->{
            System.out.println("Hi "+name+" Your name size is "+name.length());
        });
    }

}
