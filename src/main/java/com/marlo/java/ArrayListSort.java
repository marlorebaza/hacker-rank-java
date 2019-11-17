package com.marlo.java;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSort {
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList();
		numbers.add(12);
		numbers.add(50);
		numbers.add(1);
		numbers.add(5);
		numbers.add(-1);
		numbers.add(0);
        // ascendete: esultado negativo SIEMPRE manda primero a o1
		numbers.sort((o1, o2) -> {
			return o1.compareTo(o2);
		});
		numbers.forEach(System.out::println);
		double n1 = 3.75;
		double n2 = 3.76;
		System.out.println((int) ( n1 * 100 - n2 * 100));
	}

}
