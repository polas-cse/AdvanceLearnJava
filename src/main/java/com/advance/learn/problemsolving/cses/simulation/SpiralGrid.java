package com.advance.learn.problemsolving.cses.simulation;

import java.util.Scanner;

public class SpiralGrid {

    // ANSI color codes cycled per ring, so each ring prints in a different color
    static final String[] COLORS = {
            "\u001B[31m", // red
            "\u001B[33m", // yellow
            "\u001B[32m", // green
            "\u001B[36m", // cyan
            "\u001B[34m", // blue
            "\u001B[35m"  // magenta
    };
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[][] matrix = generateSpiralGrid(n);

        System.out.println("\nFinal Grid:");
        printGrid(matrix, n);
    }

    public static int[][] generateSpiralGrid(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;

        int size = (n % 2 == 1) ? 1 : 2;
        int count = 1;
        matrix[0][0] = 1;

        if (size == 2) {
            matrix[0][1] = 2;
            matrix[1][1] = 3;
            matrix[1][0] = 4;
            count = 4;
        }

        while (size < n) {
            int s = size;

            for (int row = 0; row <= s; row++) matrix[row][s] = ++count;
            for (int col = s - 1; col >= 0; col--) matrix[s][col] = ++count;
            for (int col = 0; col <= s + 1; col++) matrix[s + 1][col] = ++count;
            for (int row = s; row >= 0; row--) matrix[row][s + 1] = ++count;

            size += 2;
        }
        return matrix;
    }

    // prints the matrix with each ring in a different color
    static void printGrid(int[][] matrix, int n) {
        int width = String.valueOf(n * n).length() + 1;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int ring = Math.max(r, c);              // ring index of this cell
                String color = COLORS[ring % COLORS.length];
                System.out.printf(color + "%" + width + "d" + RESET, matrix[r][c]);
            }
            System.out.println();
        }
    }
}