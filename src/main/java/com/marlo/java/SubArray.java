package com.marlo.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubArray {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList(); 
        for (int i = 0; i < n; i++) {
        	numbers.add(scanner.nextInt());
        }
        do {
        	for (int j = 0; j < numbers.size(); j++) {
        		if ((j + n) <= numbers.size() && numbers.subList(j, j + n).stream().mapToInt(Integer::new).sum() < 0) {
            		count++;
        		}
        	}
        } while (--n > 0);
        System.out.println(count);
        scanner.close();
	}

}
