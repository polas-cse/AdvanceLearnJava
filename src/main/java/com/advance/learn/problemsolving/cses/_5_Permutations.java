package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5_Permutations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if(4<=n || n==1){
            StringBuffer sbOdd = new StringBuffer();
            StringBuffer sbEven = new StringBuffer();
            for (int i = 1; i <= n; i++) {
                if(i%2==0){
                    sbEven.append(i+" ");
                }else{
                    sbOdd.append(i+" ");
                }
            }
            sbEven.append(sbOdd);
            System.out.println(sbEven);
        }else{
            System.out.println("NO SOLUTION");
        }


    }
}
