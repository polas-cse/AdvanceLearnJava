package com.advance.learn.problemsolving.cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11_PalindromeReorder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'A']++;
            }

            int odd = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 == 1) {
                    odd++;
                }
            }

            if (odd > 1) {
                System.out.println("NO SOLUTION");
                return;
            }

        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('A' + i));
            }

            if (freq[i] % 2 == 1) {
                middle.append((char) ('A' + i));
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(middle);
        ans.append(new StringBuilder(left).reverse());

        System.out.println(ans);
        }
}
