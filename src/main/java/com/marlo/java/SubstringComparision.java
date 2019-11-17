package com.marlo.java;


public class SubstringComparision {
	
	
	public static void main(String[] args) {
		String str = "we";
		int n = 3;
		java.util.List<String> slices = new java.util.ArrayList(); 
		for (int i = 0; i < str.length() - n + 1; i++) {
			slices.add(str.substring(i, (i + n)));
		};
		java.util.Collections.sort(slices);
		slices.stream().forEach(System.out::println);
		
	}

}
