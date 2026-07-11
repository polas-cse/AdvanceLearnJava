package com.advance.learn.problemsolving.cses.simulation;

import java.util.Scanner;

public class SpiralGrid {

    // set true if you want step-by-step trace printed while filling
    static boolean DEBUG = true;

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

        // core size: odd n -> single cell, even n -> 2x2 block
        int size = (n % 2 == 1) ? 1 : 2;
        int count = 1;

        matrix[0][0] = 1;
        debug("core: (0,0) = 1");

        if (size == 2) {
            matrix[0][1] = 2;
            matrix[1][1] = 3;
            matrix[1][0] = 4;
            count = 4;
            debug("core: (0,1)=2, (1,1)=3, (1,0)=4  [count=4]");
        }

        // grow outward ring by ring, each ring adds width 2
        while (size < n) {
            int s = size; // size of the previously completed ring
            debug("\n-- new ring: growing from size " + s + " to " + (s + 2) + " --");

            // Step 1: go DOWN the new right column (col = s), rows 0..s
            for (int row = 0; row <= s; row++) {
                matrix[row][s] = ++count;
                debug("step1 down   -> (" + row + "," + s + ") = " + count);
            }

            // Step 2: go LEFT along row s, cols s-1..0
            for (int col = s - 1; col >= 0; col--) {
                matrix[s][col] = ++count;
                debug("step2 left   -> (" + s + "," + col + ") = " + count);
            }

            // Step 3: go RIGHT along the new bottom row (row = s+1), cols 0..s+1
            for (int col = 0; col <= s + 1; col++) {
                matrix[s + 1][col] = ++count;
                debug("step3 right  -> (" + (s + 1) + "," + col + ") = " + count);
            }

            // Step 4: go UP the new right column (col = s+1), rows s..0
            for (int row = s; row >= 0; row--) {
                matrix[row][s + 1] = ++count;
                debug("step4 up     -> (" + row + "," + (s + 1) + ") = " + count);
            }

            size += 2; // ring complete, grid is now (size x size)
        }
        return matrix;
    }

    // prints a debug line only if DEBUG flag is on
    static void debug(String msg) {
        if (DEBUG) System.out.println(msg);
    }

    // pretty-prints the matrix with aligned column widths
    static void printGrid(int[][] matrix, int n) {
        int width = String.valueOf(n * n).length() + 1; // for alignment
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("%" + width + "d", matrix[r][c]);
            }
            System.out.println();
        }
    }
}