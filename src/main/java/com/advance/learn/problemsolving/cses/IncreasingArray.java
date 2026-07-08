package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IncreasingArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        long count=0;

        for (int i = 1; i < n; i++) {
            if(arr[i-1]>arr[i]){
                count += arr[i-1] - arr[i];
                arr[i] =  arr[i-1];
            }
        }
        System.out.println(count);
    }
}
