package com.marlo.java;

import java.util.Scanner;

public class StdInStdOut {

    /**
     Input Format
     There are three lines of input:
     The first line contains an integer.
     The second line contains a double.
     The third line contains a String.

     Output Format
     There are three lines of output:
     On the first line, print String: followed by the unaltered String read from stdin.
     On the second line, print Double: followed by the unaltered double read from stdin.
     On the third line, print Int: followed by the unaltered integer read from stdin.

     Nota: Si usa el método nextLine () inmediatamente después del método nextInt (),
     recuerde que nextInt () lee tokens enteros; debido a esto, el último carácter de
     nueva línea para esa línea de entrada de enteros todavía está en cola en el búfer
     de entrada y el siguiente nextLine () leerá el resto de la línea de enteros (que está vacía).
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

}
