package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9_TrailingZeros {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long count = 0;
        for (long p = 5; p <= n; p *= 5) {
            count += n / p;
        }

        System.out.println(count);
    }
}