package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6_NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long k = Math.max(x, y); // point টা k-তম ring/layer এ আছে
            long ans;

            if (k % 2 == 1) {
                // odd ring: top row এ k*k থাকে, নিচের দিকে কমতে থাকে
                if (x == k) {
                    ans = k * k - y + 1;
                } else { // y == k
                    ans = (k - 1) * (k - 1) + x;
                }
            } else {
                // even ring: top row এ (k-1)^2+1 থাকে, নিচের দিকে বাড়তে থাকে
                if (y == k) {
                    ans = k * k - x + 1;
                } else { // x == k
                    ans = (k - 1) * (k - 1) + y;
                }
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}