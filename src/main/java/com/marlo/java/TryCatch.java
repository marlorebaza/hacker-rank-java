package com.marlo.java;

import java.util.Scanner;

public class TryCatch {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        Integer n1;
        Integer n2;
        try {
            n1 = Integer.parseInt(in.nextLine());
            n2 = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
        	System.out.println("java.util.InputMismatchException");
        	return;
        }
        if (n2 != 0) {
            System.out.println(n1 / n2);
        } else {
        	System.out.println("java.lang.ArithmeticException: / by zero");
        }
        in.close();
    }

}
