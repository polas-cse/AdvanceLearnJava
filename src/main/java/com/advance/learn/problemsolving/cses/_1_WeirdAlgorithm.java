package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_WeirdAlgorithm {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        StringBuffer sb = new StringBuffer();
        sb.append(n);

        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
            }else {
                n = n * 3 + 1;
            }
            sb.append(' ').append(n);
        }
        System.out.println(sb.toString());
    }
}
