package com.marlo.java;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Array2D {
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
        
        BiFunction<Integer, Integer, Integer> sum = (y, x) -> {
        	int result = 0;
        	for (int i = y; i < y + 3; i++) {
        		for (int j = x; j < x + 3; j++) {
        			if (i != (y + 1) || (j != x && j != (x + 2))) {
        				result += arr[i][j];
        			}
        		}
        	}
        	return result;
        };
        
        Integer result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
        	for (int j = 0; j < arr[i].length - 2; j++) {
        		int sumResult = sum.apply(i, j);
        		result = result == null || sumResult > result ? sumResult : result; 
        	}
        }
        
        System.out.println(result);
    }

}
