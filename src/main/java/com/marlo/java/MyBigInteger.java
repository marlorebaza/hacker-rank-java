package com.marlo.java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class MyBigInteger {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n1 = in.nextBigInteger();
		BigInteger n2 = in.nextBigInteger();
		System.out.println(n1.add(n2));
		System.out.println(n1.multiply(n2));
		
		BigDecimal number = new BigDecimal(".1");
		System.out.println(number);
	}

}
