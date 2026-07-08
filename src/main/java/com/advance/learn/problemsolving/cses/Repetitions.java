package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        int subLength = 1;
        int maxLength = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1))
                subLength++;
            else
                subLength = 1;

           maxLength = Math.max(subLength, maxLength);

        }
        System.out.println(maxLength);

    }
}
