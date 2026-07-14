package com.advance.learn.problemsolving.cses;

import java.io.*;

public class _8_TwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        long total = (long) n * (n + 1) / 2;

        if (total % 2 != 0) {
            System.out.println("NO");
            return;
        }

        long target = total / 2;
        boolean[] inSet1 = new boolean[n + 1];
        long remaining = target;

        for (int i = n; i >= 1; i--) {
            if (i <= remaining) {
                inSet1[i] = true;
                remaining -= i;
            }
        }
        StringBuilder set1 = new StringBuilder();
        StringBuilder set2 = new StringBuilder();
        int count1 = 0, count2 = 0;

        for (int i = 1; i <= n; i++) {
            if (inSet1[i]) {
                set1.append(i).append(' ');
                count1++;
            } else {
                set2.append(i).append(' ');
                count2++;
            }
        }

        StringBuilder out = new StringBuilder();
        out.append("YES\n");
        out.append(count1).append('\n').append(set1.toString().trim()).append('\n');
        out.append(count2).append('\n').append(set2.toString().trim()).append('\n');

        System.out.print(out);
    }
}