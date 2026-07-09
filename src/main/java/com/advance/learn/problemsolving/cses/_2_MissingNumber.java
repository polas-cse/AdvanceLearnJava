package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class _2_MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n-1; i++) {
            arr[i] = Integer.parseInt(st.nextToken().trim());
        }
        Arrays.sort(arr);

        int missingNumber = -1;
        for (int i = 1; i < n; i++) {
            if((arr[i] - arr[i-1]) > 1){
                missingNumber = arr[i-1]+1;
            }
        }

        if (missingNumber == -1) {
            System.out.println(n);
        }else  {
            System.out.println(missingNumber);
        }

    }

}
