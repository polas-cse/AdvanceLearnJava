package com.advance.learn.problemsolving.codeforces.offline;

import java.util.Scanner;

public class LineTrip {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt(), x = in.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = in.nextInt();

                int max = arr[0];

                for (int i = 1; i < n; i++)
                    max = Math.max(max, arr[i] - arr[i - 1]);
                max = Math.max(max, (x - arr[n - 1]) * 2);
                System.out.println(max);
            }
        }
    }
}
