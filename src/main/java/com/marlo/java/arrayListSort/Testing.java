package com.marlo.java.arrayListSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testing {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
        	List<Integer> s = new ArrayList<>();
        	for (int j = 0; j < d; j++) {
        		s.add(scanner.nextInt());
        	}
        	a.add(s);
        }
        n = scanner.nextInt();
        while (n-- > 0) {
        	try {
        		System.out.println(a.get( scanner.nextInt() - 1 ).get( scanner.nextInt() - 1 ));
        	} catch (IndexOutOfBoundsException e) {
        		System.out.println("ERROR!");
        	}
        }
        scanner.close();
	}

}
