package com.marlo.java;

import java.util.Arrays;
import java.util.Scanner;

public class Loop2 {

    /**
     * Fuente: https://www.hackerrank.com/challenges/java-loops/
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        if (q <= 500) {
            for (int i = 0; i < q; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();
                if (a >= 0 && a <= 500
                        && b >= 0 && b <= 500
                        && n >= 1 && n <= 15) {
                    for (int j = 0; j < n; j ++) {
                        int result = a;
                        for (int k = 0; k <= j; k++) {
                            result += Math.pow(2, k) * b;
                        }
                        // no fué una restricción que haya un espacio en blanco al final x cada linea
                        System.out.print(result + " ");
                    }
                    System.out.println();
                }
            }
        }
        in.close();
    }

}
