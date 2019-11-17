package com.marlo.java;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MyBitSet {
	
	// Sobre longitud de un BitSet: https://stackoverflow.com/a/40787359
    
	public static void main(String [] args){
    	BitSet bs1 = new BitSet();
    	bs1.set(0, true);
    	bs1.set(1, false);
    	bs1.set(2, false);
    	bs1.set(3, true);
    	// longitud real
//    	System.err.println("bs1.length() = " +  bs1.length());
    	// tamaño disponible
//    	System.err.println("bs1.size() = " +  bs1.size());
    	// cantidad de elementos igual a true
//    	System.err.println("bs1.cardinality() = " +  bs1.cardinality());
    	System.out.println("---- Elementos bs1 -----");
    	for (int i = 0; i < bs1.length(); i ++) {
    		System.out.println(bs1.get(i));
    	}
    	
    	
    	BitSet bs2 = new BitSet(2);
    	bs2.set(0, false);
    	bs2.set(1, true);
    	bs2.set(2, true);
    	bs2.set(3, false);
//    	System.err.println("bs1.length() = " +  bs2.length());
    	System.out.println("---- Elementos bs2 -----");
    	// no toma en cuenta el ultimo valor, ya que es un "false"
    	for (int i = 0; i < bs2.length(); i ++) {
    		System.out.println(bs2.get(i));
    	}
    	System.out.println("-------------------------");
    	
    	System.out.println("bs1 indices igual a true (antes de AND) = "+ bs1);
    	System.out.println("bs2 indices igual a true (antes de AND) = "+ bs2);
    	// ejecuta el operador logico sobre bs1
    	bs1.and(bs2);
    	System.out.println("bs1 indices igual a true (despues de AND) = "+ bs1);
    	System.out.println("bs2 indices igual a true (despues de AND) = "+ bs2);
    	System.out.println("-------------------------");
    	
    	// convertimos los 10 primeros elementos de bs1 y bs2 a su valor opuesto
    	IntStream.range(0, 10).forEach(bs1::flip);
    	IntStream.range(0, 10).forEach(bs2::flip);
    	System.out.println(bs1);
    	System.out.println(bs2);
    	System.out.println("-------------------------");
    	
    	// XOR: si y solo si el primer elemento es true y el siguiente false o viceversa
    	// en caso contrario serà false!
    	// OR vs XOR: https://stackoverflow.com/a/17659838
    	bs1.xor(bs2);
    	System.out.println(bs1);
    	System.out.println("-------------------------");
    	
    	// EJERCICIO
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        while (m-- > 0) {
        	String operator = in.next();
        	int n1 = in.nextInt();
        	int n2 = in.nextInt();
            BitSet bLeft = b1;
            BitSet bRight = b2;
			if (n1 == 2) {
				bLeft = b2;
				bRight = b1;
			}
        	switch (operator) {
        		case "OR":
        			bLeft.or(bRight);
        			break;
        		case "AND":
        			bLeft.and(bRight);
        			break;
        		case "XOR":
        			bLeft.xor(bRight);
        			break;
        		case "FLIP":
        			bLeft.flip(n2);
        			break;
        		case "SET":
        			bLeft.set(n2);
        			break;
        	}
        	System.out.println(b1.cardinality() + " " + b2.cardinality() + "\n");
        }
        in.close();
    	
    }

}
