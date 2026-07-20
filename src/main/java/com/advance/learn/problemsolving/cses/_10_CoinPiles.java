package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10_CoinPiles {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine().trim());

        while (t-->0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if ((a + b) % 3 == 0 && Math.max(a, b) <= 2 * Math.min(a, b)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
