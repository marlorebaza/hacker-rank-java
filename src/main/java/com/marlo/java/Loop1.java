package com.marlo.java;

import java.util.Scanner;

public class Loop1 {

    /**
     * Fuente: https://www.hackerrank.com/challenges/java-loops-i/
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N >= 2 && N <= 20) {
            for (int i = 1; i < 11; i++) {
                System.out.printf("%d x %d = %d\n", N, i, (N*i));
            }
        }
        scanner.close();
    }

}
