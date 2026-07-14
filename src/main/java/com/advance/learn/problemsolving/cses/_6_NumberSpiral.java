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
            long row = Long.parseLong(st.nextToken());
            long col = Long.parseLong(st.nextToken());
            long k = Math.max(row, col);
            long ans;
            if (k % 2 == 1) {
                if (col == k) {
                    ans = k * k - row + 1;
                } else {
                    ans = (k - 1) * (k - 1) + col;
                }
            } else {
                if (row == k) {
                    ans = k * k - col + 1;
                } else {
                    ans = (k - 1) * (k - 1) + row;
                }
            }
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}